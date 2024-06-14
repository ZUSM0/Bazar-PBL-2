package br.uefs.ecomp.bazar.model.exception;

public class ProdutoNaoCadastrouException extends Exception {

    public ProdutoNaoCadastrouException() {
        super("Produto não foi cadastrado!");
    }

    public ProdutoNaoCadastrouException(String message) {
        super(message);
    }
    
}
