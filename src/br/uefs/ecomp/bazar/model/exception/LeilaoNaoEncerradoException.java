package br.uefs.ecomp.bazar.model.exception;

public class LeilaoNaoEncerradoException extends Exception{

    public LeilaoNaoEncerradoException() {
        super("Leilao n�o encerrado!");
    }

    public LeilaoNaoEncerradoException(String message) {
        super(message);
    }
    
}
