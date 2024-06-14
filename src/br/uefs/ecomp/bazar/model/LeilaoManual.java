package br.uefs.ecomp.bazar.model;
import java.util.Date;
import java.util.Calendar;


public class LeilaoManual extends Leilao{
    
    
    public LeilaoManual(double precoMinimo, double incrementoMinimo, Produto produto){
        super(precoMinimo, incrementoMinimo, produto);
    }
    
    public LeilaoManual(double precoMinimo, double incrementoMinimo, Usuario vendedor, Produto produto){
        super(precoMinimo, incrementoMinimo, vendedor, produto);
    }
    
    // METODOS ABSTRATOS
    @Override
    public void iniciar() {
        super.inicio = Calendar.getInstance().getTime();
        super.iniciarLeiao();
    }
    
    public void encerrar(){
        if(this.getDeuLance()){
            Venda v  =  new Venda(super.getUltimoLance().getValor(), super.getVendedor(), super.getUltimoLance().getParticipante(), super.getProduto(), this);
            super.setVenda(v);
        }
        super.termino = Calendar.getInstance().getTime();
        super.status = Leilao.ENCERRADO;
    }
    
    public void darLanceMinimo(Usuario comprador){
        if (super.vendedor != comprador){
            comprador.darLanceMinimo();
        }
    }
    
    @Override
    public boolean darLance(Usuario comprador, double valor){
        if((getDeuLance() == false) && (super.getPrecoMinimo() + getIncrementoMinimo() > valor)){
            return false;
        } else if(super.getUltimoLance() != null&&(super.vendedor == comprador || (super.getUltimoLance().getValor() + super.getIncrementoMinimo()) >= valor)){
            return false;
        } else{
            Lance l = new Lance(valor, comprador, comprador.listarMomentoAtual().getTime());
            super.setUltimoLance(l);
            return true;
        }
    }
    
}