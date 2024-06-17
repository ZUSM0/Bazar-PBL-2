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
