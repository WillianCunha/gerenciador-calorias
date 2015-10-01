/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author visitante
 */
public enum NivelAtividadeFisicaEnum {

    BASAL(0, "Basal"),
    SEDENTARIO(1, "Sedentário"),
    ATIVIDADE_LEVE(2, "Atividade Leve"),
    ATIVIDADE_MODERADA(3, "Atividade Moderada"),
    ATIVIDADE_INTENSA(4, "Atividade Intesa"),
    ATIVIDADE_MUITO_INTENSA(5, "Atividade Muito Intensa");

    private final int valor;
    private final String descricao;

    NivelAtividadeFisicaEnum(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
