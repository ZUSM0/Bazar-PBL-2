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

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class ControllerBazar {
    private Usuario usuarioLogado;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private boolean logado = false;
    private Produto produto;
    public DbLeiloes leiloes = new DbLeiloes();
    
    public ControllerBazar(){
        
    }
      
    public Usuario cadastrarUsuario(String login, String nome, String senha, String cpf, String endereco, String telefone) {
        Usuario usuario = new Usuario(login, nome, senha, cpf, endereco, telefone);
        usuarios.add(usuario);    
        return usuario;
    }
    
    public Usuario fazerLogin(String login, String senha){
        this.deslogar();
        Iterator iterator = usuarios.iterator();
        
        while(iterator.hasNext()){
            Usuario usuario = (Usuario) iterator.next();
            if((usuario.getLogin().equals(login)) && (usuario.getSenha().equals(senha))){
                this.usuarioLogado = usuario;
                this.logar();
                return usuario;
            }
        }
        return null;
    }
    
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada){
        if(this.logado){
            produto = new Produto(tipo, descricaoResumida, descricaoDetalhada, this.usuarioLogado);
            this.usuarioLogado.cadastrarProduto(produto);
            return produto;
        } else{
            return null;
        }
    }
    
    public Iterator<Produto> listarProdutosCadastrados(){
        return this.usuarioLogado.listarProdutosCadastrados();
    }
    
    public void iniciarLeilao(Leilao leilao){
        leilao.iniciar();
        leiloes.leilaoIniciadoDb(leilao);
        
    }
    
    public LeilaoManual cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo){
        LeilaoManual leilao = this.usuarioLogado.cadastrarLeilaoManual(precoMinimo, incrementoMinimo, produto);
        this.leiloes.leilaoCadastradoDb(leilao);
        return leilao;
    }
    public LeilaoAutomatico cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino){
        LeilaoAutomatico leilao = this.usuarioLogado.cadastroLeilaoAutomatico(produto, precoMinimo, incrementoMinimo, inicio, termino);
        this.leiloes.leilaoCadastradoDb(leilao);
        return leilao;
    }
    
    public Iterator<Leilao> listarLeiloesIniciados(){
        Iterator<Leilao> iterator = this.leiloes.listaLeiloesIniciadosDb().iterator();
        return iterator;
    }
    
    public void participarLeilao(Leilao leilao){
        this.usuarioLogado.participarLeilao(leilao);
    }
    
    public void darLanceMinimo(){
        this.usuarioLogado.darLanceMinimo();
    }
    
    public boolean darLance(double valor){
        return this.usuarioLogado.darLance(valor);
    }
    
    public Venda encerrarLeilao(){
        return this.usuarioLogado.encerrarLeilaoAtivo();
    }
    
    public Date listarMomentoAtual(){
        return Calendar.getInstance().getTime();
    }
        
    // GETTERS E SETTERS!
    public int quantidadeUsuarios(){
        return usuarios.size();
    }
    
    public boolean getlogado(){
        return this.logado;
    }
    
    private void logar(){
        this.logado = true;
    }
    
    private void deslogar(){
        this.logado = false;
    }
    
}

