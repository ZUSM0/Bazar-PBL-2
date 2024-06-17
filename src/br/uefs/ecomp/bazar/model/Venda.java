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

import java.util.Date;

public class Venda {
    private double valor;
    private Usuario vendedor;
    private Usuario comprador;
    private Produto produto;
    private Leilao leilao;
    private Date momento;
    
    public Venda(double valor, Usuario vendedor, Usuario comprador, Produto produto, Leilao leilao, Date momento){
        this.valor = valor;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.produto = produto;
        this.leilao = leilao;
        this.momento = momento;
    }
    
    // Getters e Setters!
    public double getValor() {
        return valor;
    }
    
    public Usuario getVendedor() {
        return vendedor;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public Leilao getLeilao() {
        return leilao;
    }
    
    
}
