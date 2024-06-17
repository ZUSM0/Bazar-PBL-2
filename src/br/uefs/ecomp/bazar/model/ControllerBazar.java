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

import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.LoginFalhouException;
import br.uefs.ecomp.bazar.model.exception.ProdutoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoEncerradoException;
import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;

public class ControllerBazar {
    private Usuario usuarioLogado;
    private boolean logado = false;
    private Produto produto;
    public DbLeiloes leiloes = new DbLeiloes();
    public DbUsuario usuarios = new DbUsuario();
    
    public ControllerBazar(){
        
    }
      
    public Usuario cadastrarUsuario(String login, String nome, String senha, String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException {
        if(login.isEmpty() || senha.isEmpty() || nome.isEmpty() || cpf.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || usuarios.isLogin(login)){
            throw new UsuarioNaoCadastrouException();
        }
        Usuario usuario = new Usuario(login, nome, senha, cpf, endereco, telefone);
        usuarios.usuarioCadastradoDb(usuario);    
        return usuario;
    }
    
    public Usuario fazerLogin(String login, String senha) throws UsuarioNaoCadastrouException, LoginFalhouException{
        this.deslogar();
        Iterator iterator = usuarios.listarUsuariosCadastradosDb();
        
        while(iterator.hasNext()){
            Usuario usuario = (Usuario) iterator.next();
            if((usuario.getLogin().equals(login)) && (usuario.getSenha().equals(senha))){
                this.usuarioLogado = usuario;
                this.logar();
                return usuario;
            }
        }
        throw new LoginFalhouException();
    }
    
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException, UsuarioNaoCadastrouException, LoginFalhouException{
        if(tipo.isEmpty() || descricaoDetalhada.isEmpty() || descricaoResumida.isEmpty()){
            throw new ProdutoNaoCadastrouException();
        }
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
    
    public LeilaoManual cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) throws UsuarioNaoCadastrouException, LoginFalhouException, ProdutoNaoCadastrouException, LeilaoNaoCadastrouException{
        if(precoMinimo == 0.0 || incrementoMinimo == 0.0){
            throw new LeilaoNaoCadastrouException();
        }
        LeilaoManual leilao = this.usuarioLogado.cadastrarLeilaoManual(precoMinimo, incrementoMinimo, produto);
        this.leiloes.leilaoCadastradoDb(leilao);
        return leilao;
    }
    
    public LeilaoAutomatico cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino) throws UsuarioNaoCadastrouException, LoginFalhouException, 
			ProdutoNaoCadastrouException, LeilaoNaoCadastrouException{
        Date atual = Calendar.getInstance().getTime();
        if(precoMinimo == 0.0 || incrementoMinimo == 0.0 || inicio.getTime() > termino.getTime() || inicio.getTime() < atual.getTime()){
            throw new LeilaoNaoCadastrouException();
        }
        LeilaoAutomatico leilao = this.usuarioLogado.cadastrarLeilaoAutomatico(produto, precoMinimo, incrementoMinimo, inicio, termino);
        this.leiloes.leilaoCadastradoDb(leilao);
        return leilao;
    }
    
    public LeilaoAutomaticoFechado cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino) throws UsuarioNaoCadastrouException, LoginFalhouException, 
			ProdutoNaoCadastrouException, LeilaoNaoCadastrouException{
        Date atual = Calendar.getInstance().getTime();
        if(precoMinimo == 0.0 || incrementoMinimo == 0.0 || inicio.getTime() > termino.getTime() || inicio.getTime() < atual.getTime()){
            throw new LeilaoNaoCadastrouException();
        }
        LeilaoAutomaticoFechado leilao = this.usuarioLogado.cadastrarLeilaoAutomaticoFechado(produto, precoMinimo, incrementoMinimo, inicio, termino);
        this.leiloes.leilaoCadastradoDb(leilao);
        return leilao;
    }
    
    public Iterator<Lance> abrirEnvelopesLeilaoAutomaticoFechado() throws LeilaoNaoEncerradoException{
        if(this.usuarioLogado.getLeilao().status != Leilao.ENCERRADO){
            throw new LeilaoNaoEncerradoException();
        }
        if(this.usuarioLogado.getLeilao() instanceof LeilaoAutomaticoFechado){
            LeilaoAutomaticoFechado leilaoFechado = (LeilaoAutomaticoFechado) this.usuarioLogado.getLeilao();
            return leilaoFechado.abrirEnvelopesLeilaoAutomaticoFechado();
        }
        return null;
    }
    
    public Iterator<Leilao> listarLeiloesIniciados(){
        Iterator<Leilao> iterator = this.leiloes.listaLeiloesIniciadosDb().iterator();
        return iterator;
    }
    
    public void participarLeilao(Leilao leilao) throws LeilaoNaoCadastrouException{
        if(leilao.getStatus() == Leilao.ENCERRADO){
            throw new LeilaoNaoCadastrouException("Usuario não pode mais participar do leilão!");
        }
        leilao.cadastrarParticipante(this.usuarioLogado);
    }
    
    public void darLanceMinimo() throws LanceInvalidoException{
        if(this.usuarioLogado.getLeilao().status != Leilao.INICIADO){
            throw new LanceInvalidoException();
        }
        this.usuarioLogado.darLanceMinimo();
    }
    
    public boolean darLance(double valor) throws LanceInvalidoException{
        if(this.usuarioLogado.getLeilao().getStatus() != Leilao.INICIADO ){
            throw new LanceInvalidoException();
        }
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

