package com.heredia.testUnidad;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

public class TestHelicoptero {
	private Helicoptero heli;
	private PistaSimple pistaAAterrizar;

	
	@Before
	public void setUp() throws PosicionesEntradaVaciaException {
		Posicion posInicial = new Posicion(0,0);
		Posicion posFinal = new Posicion(5,5);
		Posicion posAMover = new Posicion(10,10);
		pistaAAterrizar = new PistaSimple(posAMover);
		Mapa mapa = new Mapa();
		heli = new Helicoptero(posInicial,posFinal,mapa);
	}
	
	@Test
	public void testPuedeAterrizar() {
		assertTrue("Se puede aterrizar helicoptero?", heli.puedeAterrizar(pistaAAterrizar));
		
	}
	
	@Test
	public void testDetenerHelicoptero() {
		heli.detener();
		assertTrue("Se pudo detener helicoptero?",heli.estaDetenido());
	}
	
}
