package br.com.dld.aula1.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class SalesProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salesId")
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Integer amount;

    private Double price;

    private Double value;

    public SalesProduct(){

    }

    public SalesProduct(Long id, Sales sales, Product product,
                        Integer amount, Double price, Double value) {
        super();
        this.id = id;
        this.sales = sales;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.value = value;
    }

}


