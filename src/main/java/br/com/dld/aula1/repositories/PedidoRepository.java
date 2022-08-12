package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.Customer;
import br.com.dld.aula1.models.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Transactional//(readOnly=true)
    Page<Pedido> findByCustomer(Customer customer, Pageable pageRequest);
}
