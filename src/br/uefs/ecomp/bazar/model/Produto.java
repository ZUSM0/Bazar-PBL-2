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
