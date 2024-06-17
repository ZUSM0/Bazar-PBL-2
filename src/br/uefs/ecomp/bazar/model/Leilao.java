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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public abstract class Leilao {
    private Produto produto;
    protected double precoMinimo;
    protected double incrementoMinimo;
    protected Usuario vendedor;
    protected ArrayList<Usuario> participantes = new ArrayList<>();
    protected boolean iniciado = false;
    protected Venda venda;
    protected ArrayList<Lance> lances = new ArrayList<>();
    protected Lance ultimoLance;
    protected boolean deuLance = false;
    protected int status;
    protected Date inicio;
    protected Date termino;
   
    
    public static final int CADASTRADO = 0;
    public static final int INICIADO = 1;
    public static final int ENCERRADO = 2;
        
    public Leilao(double precoMinimo, double incrementoMinimo, Produto produto){
        this.produto = produto;
        this.precoMinimo = precoMinimo;
        this.incrementoMinimo = incrementoMinimo;
        this.status = Leilao.CADASTRADO;
        
    }
    
    public Leilao(double precoMinimo, double incrementoMinimo, Usuario vendedor, Produto produto){
        this(precoMinimo, incrementoMinimo, produto);
        this.vendedor = vendedor;
    }
    
    // M�todos abstratos
    public abstract void iniciar();
    
    public abstract void darLanceMinimo(Usuario comprador);
    
    public abstract boolean darLance(Usuario comprador, double valor) throws LanceInvalidoException;
    
    // Metodos gerais!
    public void encerrar(){
        if(this.getDeuLance()){
            Venda v  =  new Venda(this.getUltimoLance().getValor(), this.getVendedor(), this.getUltimoLance().getParticipante(), this.getProduto(), this, Calendar.getInstance().getTime());
            this.setVenda(v);
        }
        this.termino = Calendar.getInstance().getTime();
        this.status = Leilao.ENCERRADO;
    }
    
    // M�todos relacionados ao participante!
    public void cadastrarParticipante(Usuario comprador){
        if(this.vendedor != comprador && !this.participantes.contains(comprador)){
            comprador.participarLeilao(this);
            this.participantes.add(comprador);
        }
    }
    
    public Iterator<Usuario> listarParcipantes(){
        Iterator<Usuario> iterator = participantes.iterator();
        return iterator;
    }
      
    // Getters e Setters
    public boolean getIniciado(){
        return this.iniciado;
    }
    
    public Date getInicio() {
        return inicio;
    }

    public Date getTermino() {
        return termino;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public double getPrecoMinimo() {
        return this.precoMinimo;
    }

    public double getIncrementoMinimo() {
        return this.incrementoMinimo;
    }
    
    public void setVenda(Venda venda){
        this.venda = venda;
    }

    public Venda getVenda() {
        return this.venda;
    }
    
    public Lance getUltimoLance(){
        return this.ultimoLance;
    }
    
    public void setUltimoLance(Lance lance){
        this.ultimoLance = lance;
    }    
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public Usuario getVendedor(){
        return this.vendedor;
    }
    
    public boolean getDeuLance(){
        return this.deuLance;
    }
    
    public void setDeuLance(){
        this.deuLance = true;
    }
}