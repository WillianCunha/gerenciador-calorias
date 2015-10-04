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

    /**
     *
     */
    public static final String TELA_CADASTRO_PESO_USUARIO = "telacadastropesousuario";
    // Adicionado para trabalhar com a TelaCadastroAlimento

    /**
     *
     */
    public static final String TELA_CADASTRO_ALIMENTO = "telacadastroalimento";
    // Adicionado para trabalhar com a TelaCadastroRefeicao

    /**
     *
     */
    public static final String TELA_CADASTRO_REFEICAO = "telacadastrorefeicao";
    // Adicionado para trabalhar com a TelaConsultaPeso

    /**
     *
     */
    public static final String TELA_CONSULTA_PESO = "telaconsultapeso";
    // Adicionado para trabalhar com a TelaConsultaAlimento
    public static final String TELA_CONSULTA_ALIMENTO = "telaconsultaalimento";
    // Adicionado para trabalhar com a TelaCadastroAtributo
    public static final String TELA_CADASTRO_ATRIBUTO = "telacadastroatributo";

    private static Map<String, Component> windows;

    static {
        windows = new HashMap();
    }

    /**
     *
     * @param name
     * @param window
     */
    public static void add(String name, Component window) {
        try {
            windows.put(name, window);
        } catch (NullPointerException e) {
            System.out.println("retorno de put é null");
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public static Component get(String name) {
        return windows.get(name);
    }

    /**
     *
     * @param name
     * @return
     */
    public static boolean contains(String name) {
        return windows.containsKey(name);
    }

    /**
     *
     * @param name
     */
    public static void remove(String name) {
        windows.remove(name);
    }

}
