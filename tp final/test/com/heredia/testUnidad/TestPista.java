package com.heredia.testUnidad;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import avion.AvionSimple;
import copControl.Mapa;
import copControl.Posicion;
import pista.PistaDoble;
import pista.PosicionesEntradaVaciaException;

public class TestPista {

	
	private AvionSimple avion;
	private Posicion posInicial;
	private Posicion posFinal;
	private Posicion posAMover;
	private PistaDoble pistaAAterrizar;
	private Mapa mapa;
	
	@Before
	public void setUp() throws PosicionesEntradaVaciaException {
		posInicial = new Posicion(0,0);
		posFinal = new Posicion(5,5);
		posAMover = new Posicion(10,10);
		mapa = new Mapa();
		pistaAAterrizar = new PistaDoble(posAMover);
		avion = new AvionSimple(posInicial,posFinal,mapa);
	}
	
	
	@Test
	public void testPuedeAterrizar() {
		assertTrue("Puede avion aterrizar en pista?",pistaAAterrizar.puedeAterrizar(avion));
	}
	

}
