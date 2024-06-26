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
import java.util.Calendar;
import java.util.Date;

public class Usuario {

    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Leilao leilao;
    
    public Usuario(String login, String nome, String senha, String cpf, String endereco, String telefone){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;    
    }
    
    // METODOS DE VENDEDOR!
    public void cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada){
        Produto produto = new Produto(tipo, descricaoResumida, descricaoDetalhada, this);
        this.cadastrarProduto(produto);
    }
    
    public void cadastrarProduto(Produto produto){
        this.listaProdutos.add(produto);
    }
    
    public Iterator<Produto> listarProdutosCadastrados(){
        Iterator<Produto> iterator = listaProdutos.iterator();
        return iterator;
    }
    
    public LeilaoManual cadastrarLeilaoManual(double precoMinimo, double incrementoMinimo, Produto produto){
        LeilaoManual leilaoManual = new LeilaoManual(precoMinimo, incrementoMinimo, this, produto);
        this.leilao = leilaoManual;
        return leilaoManual;   
    }
    
    public LeilaoAutomatico cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino){
        LeilaoAutomatico leilaoAutomatico = new LeilaoAutomatico(produto, precoMinimo, incrementoMinimo, this, inicio, termino);
        this.leilao = leilaoAutomatico;
        return leilaoAutomatico;
    }
    
    public LeilaoAutomaticoFechado cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino){
        LeilaoAutomaticoFechado leilaoFechado = new LeilaoAutomaticoFechado(produto, precoMinimo, incrementoMinimo, this, inicio, termino);
        this.leilao = leilaoFechado;
        return leilaoFechado;
    }
    
    public void iniciarLeilao(Leilao leilao){
        this.leilao = leilao;
        
    }
    
    public Iterator<Usuario> listarParticipantesLeilao(){
        if(this.leilao.vendedor == this){ // S� verificar se o usu�rio que quer ver a lista � o vendedor.
            return this.leilao.listarParcipantes();
        }
        return null;
        
    }
    
    public Venda encerrarLeilaoAtivo(){
        if(this.leilao.getDeuLance()){
            this.leilao.encerrar();
            this.leilao.getProduto().setVendido();
            return this.leilao.getVenda();
        } else{
            return null;
        }
    }
    
    // METODOS DE COMPRADOR!
    public void participarLeilao(Leilao leilao){
        this.leilao = leilao;   

    }
    
    public void darLanceMinimo(){
        this.leilao.darLanceMinimo(this);
    }

    public boolean darLance(double valor) throws LanceInvalidoException{
        return this.leilao.darLance(this, valor); 
    }
    
    // METODOS GERAIS
    public Calendar listarMomentoAtual(){
        return Calendar.getInstance();
    }
    
    // Getters e Setters
    public Leilao getLeilao(){
        return this.leilao;
    }
    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
}