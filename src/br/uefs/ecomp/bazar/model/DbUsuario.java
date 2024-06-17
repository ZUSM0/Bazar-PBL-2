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

import java.util.ArrayList;
import java.util.Iterator;

public class DbUsuario {
    private ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    private ArrayList<String> loginsExistentes = new ArrayList<>();
    
    public void usuarioCadastradoDb(Usuario usuario){
        this.usuariosCadastrados.add(usuario);
        this.loginsExistentes.add(usuario.getLogin());
    }
    
    public Iterator<Usuario> listarUsuariosCadastradosDb(){
        return usuariosCadastrados.iterator();
    }
    
    public int size(){
        return this.usuariosCadastrados.size();
    }
    
    public boolean isLogin(String login){
        return this.loginsExistentes.contains(login);
    }
}
