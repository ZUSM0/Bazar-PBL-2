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

public class Produto {
    
    private String tipo;
    private String descricaoResumida;
    private String descricaoDetalhada;
    private Usuario vendedor;
    private boolean vendido = false;
    
    public Produto(String tipo, String descricaoResumida, String descricaoDetalhada){
        this.tipo = tipo;
        this.descricaoResumida = descricaoResumida;
        this.descricaoDetalhada = descricaoDetalhada; 
    }
    
    public Produto(String tipo, String descricaoResumida, String descricaoDetalhada, Usuario vendedor){
        this(tipo, descricaoResumida, descricaoDetalhada);
        this.vendedor = vendedor;     
    }
    
    // Getters e Setters
    public boolean isVendido(){
        return this.vendido;
    }
    
    public void setVendido(){
        this.vendido = true;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public Usuario getVendedor() {
        return vendedor;
    }    
}
