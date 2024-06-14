package br.uefs.ecomp.bazar.model.exception;

public class LoginFalhouException extends Exception {

    public LoginFalhouException() {
        super("Erro no Login!");
    }

    public LoginFalhouException(String message) {
        super(message);
    }
    
}
