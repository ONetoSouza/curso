package br.com.dld.aula1.models.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @OneToOne
    private Customer customer;
    @NotNull
    private StatusDoPedido status;
    @NotNull
    private String sessao;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemDoPedido> items;

    private Pedido() {
    }

    public Pedido(Customer customer) {

        this.customer = customer;
        this.status = StatusDoPedido.PENDENTE;
        this.sessao = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public String getSessao() {
        return sessao;
    }

    public List<ItemDoPedido> getItems() {
        return items;
    }

    public void adcionarProduct(Product product, int quantidade) {

        ItemDoPedido item = new ItemDoPedido(product, quantidade);
        items.add(item);
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (ItemDoPedido item : items) {
            valorTotal += item.getValorTotal();
        }
        return valorTotal;
    }
}
