/*******************************************************************************
Autor: João Manoel da Fé Oliveira
Componente Curricular: MI-Programação
Concluido em: 05/05/2024
* 
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico {
    protected ArrayList<Usuario> participanteDeuLance = new ArrayList<>();
    
    public LeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Usuario vendedor,Date inicio, Date termino) {
        super(produto, precoMinimo, incrementoMinimo, vendedor, inicio, termino);
    }
    
    // METODOS GERAIS
    public Iterator<Lance> abrirEnvelopesLeilaoAutomaticoFechado(){
        return super.lances.iterator();
    }
    
    
    // METODOS SOBRESCRITOS
    @Override
    public void darLanceMinimo(Usuario comprador){
        if(!participanteDeuLance.contains(comprador)){
            this.participanteDeuLance.add(comprador);
            super.darLanceMinimo(comprador);
        }

    }
    
    @Override
    public boolean darLance(Usuario comprador, double valor) throws LanceInvalidoException{
        if(participanteDeuLance.contains(comprador)){
            throw new LanceInvalidoException();
        }
        
        if(super.darLance(comprador, valor)){
            this.participanteDeuLance.add(comprador);
            return true;           
        }
        return false;
    }
    
}
