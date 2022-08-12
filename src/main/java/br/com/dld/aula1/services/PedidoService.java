package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.ItemPedido;
import br.com.dld.aula1.models.entities.Pedido;
import br.com.dld.aula1.repositories.CustomerRepository;
import br.com.dld.aula1.repositories.ItemPedidoRepository;
import br.com.dld.aula1.repositories.PedidoRepository;
import br.com.dld.aula1.repositories.ProductRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private CustomerRepository customerRepository;



    public Pedido find(Integer id) {
        Pedido obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                    + ", Tipo: " + Pedido.class.getName());
        }
        return obj;
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        //obj.setInstante(new Date());
        obj.setCustomer(customerRepository.findOne(obj.getCustomer().getId()));
        //obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        //obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(productRepository.findOne(ip.getProduto().getId()));
            ip.setPreco(ip.getProduct().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.save(obj.getItens());
        emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }

    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Cliente cliente =  clienteRepository.findOne(user.getId());
        return repo.findByCliente(cliente, pageRequest);
    }
}
