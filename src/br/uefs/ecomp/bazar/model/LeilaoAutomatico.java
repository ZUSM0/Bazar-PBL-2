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

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LeilaoAutomatico extends Leilao{

    public LeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Usuario vendedor, Date inicio, Date termino) {
        super(precoMinimo, incrementoMinimo, vendedor, produto);
        super.inicio = inicio;
        super.termino = termino;
        TimerTask startTask = new TimerTask(){
            @Override
            public void run(){
                iniciar();
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(startTask, this.inicio);
    }
    
    // METODOS ABSTRATOS
    @Override
    public void iniciar(){
        this.iniciado = true;
        this.status = Leilao.INICIADO;
        TimerTask endTask = new TimerTask(){
            @Override
            public void run(){
                encerrar();
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(endTask, this.termino);
    }
    
    @Override
    public void darLanceMinimo(Usuario comprador){
        if (super.vendedor != comprador && this.participantes.contains(comprador) &&  super.termino.after(Calendar.getInstance().getTime())){
            double valor = 0;
        
            if (super.deuLance){ 
                valor = super.ultimoLance.getValor() + super.incrementoMinimo;           
            } else{
                super.setDeuLance();
                valor = super.precoMinimo + super.incrementoMinimo;  
            }
            Lance l = new Lance(valor, comprador, Calendar.getInstance().getTime());
            super.lances.add(l);
            super.setUltimoLance(l);
        }
    }
    
    @Override
    public boolean darLance(Usuario comprador, double valor) throws LanceInvalidoException{
        Date atual = new Date();
        if((getDeuLance() == false) && (super.getPrecoMinimo() + getIncrementoMinimo() > valor)){
            return false;
        } else if(super.getUltimoLance() != null && (super.vendedor == comprador || !super.participantes.contains(comprador) || (super.getUltimoLance().getValor() + super.getIncrementoMinimo()) >= valor) || !super.termino.after(atual)){
            return false;
        } else{
            Lance l = new Lance(valor, comprador, comprador.listarMomentoAtual().getTime());
            super.lances.add(l);
            
            super.setUltimoLance(l);
            return true;
        }
    }       
    
    
    // GETTERS E SETTERS
    
    
}
