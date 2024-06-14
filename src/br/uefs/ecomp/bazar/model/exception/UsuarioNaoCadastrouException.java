package br.uefs.ecomp.bazar.model.exception;

public class UsuarioNaoCadastrouException extends Exception {

    public UsuarioNaoCadastrouException() {
        super("Erro no usuario!");
    }

    public UsuarioNaoCadastrouException(String message) {
        super(message);
    }
    
}
