package br.uefs.ecomp.bazar.model.exception;

public class LanceInvalidoException extends Exception{

    public LanceInvalidoException() {
        super("LAnce inv�lido!");
    }

    public LanceInvalidoException(String message) {
        super(message);
    }
    
}
