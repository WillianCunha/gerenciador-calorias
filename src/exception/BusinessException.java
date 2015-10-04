/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author aron.oliveira
 */
public class BusinessException extends Exception {

    /**
     *
     */
    public static final String USUARIO_NAO_CADASTRADO = "Usuário ou senha inválidos";
    
    /**
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param cause
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }
    
}

