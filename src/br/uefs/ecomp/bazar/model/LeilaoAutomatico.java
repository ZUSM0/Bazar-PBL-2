package br.uefs.ecomp.bazar.model;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// FAZER TESTE PARA TESTAR ESSE CÓDIGO!!!!!

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
        super.iniciarLeiao();
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
    public void encerrar(){
        
    }
    
    @Override
    public boolean darLance(Usuario comprador, double valor) {
        Date atual = new Date();
        if((super.getUltimoLance() == null) || (super.vendedor != comprador && (super.getUltimoLance().getValor() + super.getIncrementoMinimo()) < valor && !this.termino.after(atual))){
            Lance l = new Lance(valor, comprador, Calendar.getInstance().getTime());
            super.setUltimoLance(l);
            return true;
        } else{
            return false;
        }
    }
    
    // GETTERS E SETTERS
    
    
}
