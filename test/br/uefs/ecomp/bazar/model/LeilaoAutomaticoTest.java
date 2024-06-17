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

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Calendar;
import java.util.Date;


public class LeilaoAutomaticoTest {
    private Usuario u1, u2, u3;
    private Produto p1;
    private LeilaoAutomatico leilao;
    
    @Before
    public void setup() throws Exception{
        u1 = new Usuario("Login1", "nome1", "senha1", "123456789", "endere�o1", "75900000000");
        u2 = new Usuario("Login2", "nome2", "senha2", "123456789", "endere�o2", "75900000000");
        u3 = new Usuario("Login3", "nome3", "senha3", "123456789", "endere�o3", "75900000000");
        p1 = new Produto("Video Game", "Play 5", "Playstation 5");
        Calendar inicio = Calendar.getInstance();
        inicio.add(Calendar.SECOND, +1);
        Calendar termino = Calendar.getInstance();
        termino.add(Calendar.SECOND, +2);
        leilao = new LeilaoAutomatico(p1, 500.0, 20.0, u1, inicio.getTime(), termino.getTime());
    }
    
    @Test
    public void testEstadoLeilaoAutomatico() throws InterruptedException{
        assertEquals(Leilao.CADASTRADO, leilao.getStatus());
        
        Thread.sleep(1000);
        assertEquals(Leilao.INICIADO, leilao.getStatus());
        
        Thread.sleep(1000);
        assertEquals(Leilao.ENCERRADO, leilao.getStatus());
    }
    
    @Test
    public void testCadasstroELancesLeilao() throws LanceInvalidoException, InterruptedException{
        Thread.sleep(1000);
        leilao.cadastrarParticipante(u2);
        Iterator iterator = leilao.listarParcipantes();
        assertTrue(iterator.hasNext());
        
        leilao.darLanceMinimo(u2);
        Lance l = leilao.getUltimoLance();	
        assertEquals(520.00, l.getValor(), 0.001);
        assertEquals(u2, l.getParticipante());
        
	assertTrue(leilao.darLance(u2, 550.00));
        l = leilao.getUltimoLance();
        assertEquals(550.00, l.getValor(), 0.001);
        
        assertFalse(leilao.darLance(u2, 560.00));
        l = leilao.getUltimoLance();
        assertEquals(550.00, l.getValor(), 0.001);
        
        assertFalse(leilao.darLance(u3, 580.00));
        l = leilao.getUltimoLance();
        assertEquals(550.00, l.getValor(), 0.001);        
        
        leilao.cadastrarParticipante(u3);
        
        assertTrue(leilao.darLance(u3, 580.00));
        l = leilao.getUltimoLance();
        assertEquals(580.00, l.getValor(), 0.001);   
        
        Thread.sleep(1000);
        assertFalse(leilao.darLance(u2, 5000.00));
    }
    
    @Test
    public void testEncerrarLeilaoAutomatico() throws InterruptedException, LanceInvalidoException{
        Thread.sleep(1000);
        leilao.cadastrarParticipante(u2);
        leilao.cadastrarParticipante(u3);
        leilao.darLanceMinimo(u2);
        leilao.darLanceMinimo(u3);
        leilao.darLanceMinimo(u2);
        
        assertFalse(leilao.darLance(u1, 5000.00));
        assertNull(leilao.getVenda());
        
        Thread.sleep(1000);
        leilao.darLanceMinimo(u3);
        Venda v = leilao.getVenda();
        assertNotNull(v);
        assertEquals(560.00, v.getValor(), 0.001);
        assertEquals(u1, v.getVendedor());
        assertEquals(u2, v.getComprador());
        assertEquals(p1, v.getProduto());
        assertEquals(leilao, v.getLeilao());
    }
}











