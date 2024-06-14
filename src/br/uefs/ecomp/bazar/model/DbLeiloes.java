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

class DbLeiloes {
    // Fazer ele generico e pode receber qualquer tipo de leilão
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
