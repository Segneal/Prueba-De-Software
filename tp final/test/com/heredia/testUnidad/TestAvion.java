package com.heredia.testUnidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avion.AvionPesado;
import copControl.Mapa;
import copControl.Posicion;
import pista.PistaDoble;
import pista.PosicionesEntradaVaciaException;

public class TestAvion {
	private AvionPesado avion;
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
		avion = new AvionPesado(posInicial,posFinal,mapa);
	}
	
	@Test
	public void testAterrizarAvion() {
		assertTrue("Se puede aterrizar avion?",avion.aterrizar(pistaAAterrizar));
	}
	
	@Test
	public void testMoverAvion() {
		Posicion curPos = avion.getPosicionActual();
		avion.moverHacia(posAMover);
		assertTrue("Se pudo mover avion?",avion.getPosicionActual().igualA(curPos));
	}
	
	

}
