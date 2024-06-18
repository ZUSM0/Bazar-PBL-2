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
