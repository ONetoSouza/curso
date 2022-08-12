package br.com.dld.aula1.models.entities;

import br.com.dld.aula1.models.enums.UN;
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
    @Enumerated(EnumType.STRING)
    private UN unity;

    @Column(columnDefinition = "float default 0")
    private Float preco;

    @Column(columnDefinition = "0")
    private int quantidade;

    //public void removerQuantidade(int quantidade) {
    // }
}
