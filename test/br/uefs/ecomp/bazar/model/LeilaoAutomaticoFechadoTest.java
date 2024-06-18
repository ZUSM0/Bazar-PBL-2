package br.uefs.ecomp.bazar.model;

import java.util.Calendar;
import org.junit.Before;

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

public class LeilaoAutomaticoFechadoTest {
    private Usuario u1, u2, u3;
    private Produto p1;
    private LeilaoAutomaticoFechado leilao;
    
    @Before
    public void setup() throws Exception{
        u1 = new Usuario("Login1", "nome1", "senha1", "123456789", "endereço1", "75900000000");
        u2 = new Usuario("Login2", "nome2", "senha2", "123456789", "endereço2", "75900000000");
        u3 = new Usuario("Login3", "nome3", "senha3", "123456789", "endereço3", "75900000000");
        p1 = new Produto("Video Game", "Play 5", "Playstation 5");
        Calendar inicio = Calendar.getInstance();
        inicio.add(Calendar.SECOND, +1);
        Calendar termino = Calendar.getInstance();
        termino.add(Calendar.SECOND, +2);
        leilao = new LeilaoAutomaticoFechado(p1, 500.0, 20.0, u1, inicio.getTime(), termino.getTime());
    }
    
    @Test
    public void testEstadoLeilaoAutomaticoFechado() throws InterruptedException{
        assertEquals(Leilao.CADASTRADO, leilao.getStatus());

        Thread.sleep(1000);
        assertEquals(Leilao.INICIADO, leilao.getStatus());

        Thread.sleep(1000);
        assertEquals(Leilao.ENCERRADO, leilao.getStatus());
    }
    
    @Test
    public void testAbrirEnvelopeLeilaoAutomaticoFechado() throws InterruptedException{
        Thread.sleep(1000);
        leilao.cadastrarParticipante(u2);
        leilao.cadastrarParticipante(u3);
        leilao.darLanceMinimo(u2);
        leilao.darLanceMinimo(u3);
        leilao.darLanceMinimo(u2);
        
        Thread.sleep(1000);
        Iterator lances = leilao.abrirEnvelopesLeilaoAutomaticoFechado();
        assertNotNull(lances);                

    }
}
