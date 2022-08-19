package br.com.dld.aula1.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Sales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Transient
    @ManyToOne
    private List<SalesProduct> salesProduct;

//    @Transient
//    private List<SalesProduct> product;

    public Sales(){

    }

    public  Sales(Long id, Customer customer) {
        super();
        this.id = id;
        this.customer = customer;

    }


//    public void setName(String name) {
//    }
}
