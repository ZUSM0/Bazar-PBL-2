package br.uefs.ecomp.bazar.model.exception;

public class LeilaoNaoCadastrouException extends Exception{

    public LeilaoNaoCadastrouException() {
        super("Leil�o N�o cadastrado!");
    }

    public LeilaoNaoCadastrouException(String message) {
        super(message);
    }
    
}
