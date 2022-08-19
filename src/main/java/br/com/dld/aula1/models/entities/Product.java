package br.com.dld.aula1.models.entities;

import br.com.dld.aula1.models.enums.UN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private String unity;

    @Column(length = 15, nullable = false)
    private Integer amount;

    @Column(length = 15, nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product(){

    }

    public Product(Long id, String name, String unity, Integer amount,
                   Double price, Category category) {
        super();
        this.id = id;
        this.name = name;
        this.unity = unity;
        this.amount = amount;
        this.price = price;
        this.category = category;
    }
}
