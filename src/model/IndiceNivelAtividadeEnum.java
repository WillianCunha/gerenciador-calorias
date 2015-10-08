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
public enum IndiceNivelAtividadeEnum {

    /**
     *
     */
    BASAL(1.0f, "Basal"),
    /**
     *
     */
    SEDENTARIO(1.2f, "Sedentário"),
    /**
     *
     */
    ATIVIDADE_LEVE(1.375f, "Atividade Leve"),
    /**
     *
     */
    ATIVIDADE_MODERADA(1.55f, "Atividade Moderada"),
    /**
     *
     */
    ATIVIDADE_INTENSA(1.725f, "Atividade Intesa"),
    /**
     *
     */
    ATIVIDADE_MUITO_INTENSA(1.9f, "Atividade Muito Intensa");

    private final float valor;
    private final String descricao;

    IndiceNivelAtividadeEnum(float valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public float getValor() {
        return valor;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
}
