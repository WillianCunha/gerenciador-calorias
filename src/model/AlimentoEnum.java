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
public enum AlimentoEnum {

    FRUTA(0, "Fruta"),
    VEGETAL(1, "Vegetal"),
    CEREAL_REFINADO(2, "Cereal Refinado"),
    CEREAL_INTEGRAL(3, "Cereal Integral"),
    LACTEO(4, "Lácteo"),
    OLEO_VEGETAL(5, "Óleo Vegetal"),
    LEGUMINOSA(6, "Leguminosa"),
    CARNE_VERMELHA(7, "Carne Vermelha"),
    AVE(8, "Ave"),
    PEIXE(9, "Peixe"),
    FRUTO_DO_MAR(10, "Fruto do Mar"),
    OVO(11, "Ovo"),
    DOCE(12, "Doce"),
    ACUCAR(13, "Açúcar"),
    SALGADO(14, "Salgado"),
    BEBIDA(15, "Bebida"),
    CASTANHA(16, "Castanha"),
    SEMENTE(17, "Semente");

    private final int valor;
    private final String descricao;

    AlimentoEnum(int valor, String descricao) {
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
