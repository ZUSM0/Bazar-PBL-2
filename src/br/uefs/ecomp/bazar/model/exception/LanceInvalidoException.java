package br.uefs.ecomp.bazar.model.exception;

public class LanceInvalidoException extends Exception{

    public LanceInvalidoException() {
        super("LAnce inválido!");
    }

    public LanceInvalidoException(String message) {
        super(message);
    }
    
}
