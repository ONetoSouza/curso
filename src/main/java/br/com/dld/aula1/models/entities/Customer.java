package br.com.dld.aula1.models.entities;

import br.com.dld.aula1.models.enums.UF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Entity
@Getter
@Setter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private Long rg;

    @Column(nullable = false)
    private Integer zipCode;

    @Column(length = 50, nullable = false)
    private String district;

    @Column(length = 100, nullable = false)
    private String publicPlace;

    @Column(length = 10, nullable = false)
    private String number;

    @Column(length = 100)
    private String complement;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private UF state;
}
