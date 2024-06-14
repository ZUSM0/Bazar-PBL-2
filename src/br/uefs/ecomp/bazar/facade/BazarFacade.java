package br.uefs.ecomp.bazar.facade;

import java.util.Iterator;
import java.util.List;
import br.uefs.ecomp.bazar.model.ControllerBazar;
import br.uefs.ecomp.bazar.model.Leilao;
import br.uefs.ecomp.bazar.model.LeilaoManual;
import br.uefs.ecomp.bazar.model.LeilaoAutomatico;
import br.uefs.ecomp.bazar.model.LeilaoAutomaticoFechado;
import br.uefs.ecomp.bazar.model.Produto;
import br.uefs.ecomp.bazar.model.Usuario;
import br.uefs.ecomp.bazar.model.Venda;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.LoginFalhouException;
import br.uefs.ecomp.bazar.model.exception.ProdutoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;

import java.util.Calendar;
import java.util.Date;

public class BazarFacade {

    ControllerBazar cb;

    public BazarFacade() {
        this.cb = new ControllerBazar();
    }

    //chamadas do cb do usuario
    public Usuario cadastrarUsuario(String login, String nome, String senha,
            String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException{
        return cb.cadastrarUsuario(login, nome, senha, cpf, endereco, telefone);
    } 
    
    public Usuario fazerLogin(String login, String senha) throws UsuarioNaoCadastrouException, LoginFalhouException {
        return cb.fazerLogin(login, senha);
    }

    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException, UsuarioNaoCadastrouException, LoginFalhouException {
        return cb.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
    }

    public Iterator listarProdutosCadastrados() {
        return this.cb.listarProdutosCadastrados();
    }

    public LeilaoManual cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) throws UsuarioNaoCadastrouException, LoginFalhouException, 
			ProdutoNaoCadastrouException, LeilaoNaoCadastrouException {
        return this.cb.cadastrarLeilaoManual(produto, precoMinimo, incrementoMinimo);
    }
    
    public LeilaoAutomatico cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino) throws UsuarioNaoCadastrouException, LoginFalhouException, 
			ProdutoNaoCadastrouException, LeilaoNaoCadastrouException{
        return this.cb.cadastrarLeilaoAutomatico(produto, precoMinimo, incrementoMinimo, inicio, termino);
    }
    
    public LeilaoAutomaticoFechado cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino){
        return this.cb.cadastrarLeilaoAutomaticoFechado(produto, precoMinimo, incrementoMinimo, inicio, termino);
    }
    
    public Date listarMomentoAtual(){
        return this.cb.listarMomentoAtual();
    }

    public void iniciarLeilao(Leilao leilao) {
        this.cb.iniciarLeilao(leilao);
    }

    public Iterator listarLeiloesIniciados() {
        return this.cb.listarLeiloesIniciados();
    }

    public void participarLeilao(Leilao leilao) {
        this.cb.participarLeilao(leilao);
    }

    public void darLanceMinimo() {
        this.cb.darLanceMinimo();
    }

    public boolean darLance(double valor) throws LanceInvalidoException {
        return this.cb.darLance(valor);
    }

    public Venda encerrarLeilao() {
        return this.cb.encerrarLeilao();
    }
    
}
