/*******************************************************************************
Autor: Jo�o Manoel da F� Oliveira
Componente Curricular: MI-Programa��o
Concluido em: 05/05/2024
* 
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
