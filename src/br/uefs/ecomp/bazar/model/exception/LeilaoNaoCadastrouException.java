package br.uefs.ecomp.bazar.model.exception;

public class LeilaoNaoCadastrouException extends Exception{

    public LeilaoNaoCadastrouException() {
        super("Leilão Não cadastrado!");
    }

    public LeilaoNaoCadastrouException(String message) {
        super(message);
    }
    
}
