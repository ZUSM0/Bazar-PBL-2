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

class DbLeiloes {
    // Fazer ele generico e pode receber qualquer tipo de leil�o
    private ArrayList<Leilao> dbLeiloesCadastrados = new ArrayList<>();
    private ArrayList<Leilao> dbLeiloesIniciados = new ArrayList<>();

    public DbLeiloes(){

    }

    public void leilaoCadastradoDb(Leilao leilao){
        dbLeiloesCadastrados.add(leilao);
    }
    
    public void leilaoIniciadoDb(Leilao leilao){
        dbLeiloesIniciados.add(leilao);
    }

    public ArrayList<Leilao> listaLeiloesIniciadosDb(){
        return this.dbLeiloesIniciados;
    }

    public int size(){
        return dbLeiloesCadastrados.size();
    }
    
    public Leilao get(int n){
        Iterator iterator = dbLeiloesCadastrados.iterator();
        Leilao leilao = null;
        for(int i = 0; i <= n;i++){
            leilao = (Leilao) iterator.next();
        }
        return leilao;
    }
   }
