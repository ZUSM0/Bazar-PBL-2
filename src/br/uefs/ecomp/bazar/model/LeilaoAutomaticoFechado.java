package br.uefs.ecomp.bazar.model;

import java.util.Date;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico {

    public LeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Usuario vendedor,Date inicio, Date termino) {
        super(produto, precoMinimo, incrementoMinimo, vendedor, inicio, termino);
    }
    
    
    
}
