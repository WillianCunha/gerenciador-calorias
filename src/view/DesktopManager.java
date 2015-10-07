/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author visitante
 */
public class DesktopManager {

    public static final String MANUTENCAO_PESO_USUARIO_VIEW = "manutencaopesousuarioview";
    public static final String MANUTENCAO_REFEICAO_VIEW = "manutencaorefeicaoview";
    public static final String MANUTENCAO_PESO_VIEW = "manutencaopesoview";
    public static final String MANUTENCAO_ALIMENTO_VIEW = "manutencaoalimentoview";
    public static final String MANUTENCAO_CARACTERISTICA_ALIMENTO_VIEW = "manutencaocaracteristicaalimentoview";
    public static final String MANUTENCAO_DIARIO_VIEW = "manutencaodiarioview";

    private static Map<String, Component> windows;

    static {
        windows = new HashMap();
    }

    public static void add(String name, Component window) {
        try {
            windows.put(name, window);
        } catch (NullPointerException e) {
            System.out.println("retorno de put é null");
        }
    }

    public static Component get(String name) {
        return windows.get(name);
    }

    public static boolean contains(String name) {
        return windows.containsKey(name);
    }

    public static void remove(String name) {
        windows.remove(name);
    }

}
