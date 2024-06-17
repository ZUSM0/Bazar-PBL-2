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
