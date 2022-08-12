package br.com.dld.aula1.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UN {

    UN("Unidade", "UN"),
    CX("Caixa", "CX"),
    M("Metro", "M"),
    PC("Peça", "PC"),
    RL("Rolo", "RL"),
    KG("Quilograma", "KG");


    private final String descricao;
    private final String unidade;
}
