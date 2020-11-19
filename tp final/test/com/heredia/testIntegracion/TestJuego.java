package com.heredia.testIntegracion;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import copControl.Dificultad;
import copControl.Juego;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

public class TestJuego {
	private Juego juego;
	private List<Nivel> niveles;
	private Jugador jugador;
	private Nivel nivel;
	private AvionPesado avion1;
	private Mapa mapa;
	private Dificultad dificultad;
	private List<Pista> pistas;
	
	@Before
	public void setUp() throws PosicionesEntradaVaciaException {
		mapa = new Mapa();

		dificultad = new Dificultad(10,10,10);
		
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(1,1);
		Posicion pos3 = new Posicion(2,2);
		Posicion pos4 = new Posicion(3,3);
		Posicion pos5 = new Posicion(4,4);
		
		PistaDoble pista = new PistaDoble(pos1);
		PistaSimple pista2 = new PistaSimple(pos2);
		Helipuerto pista3 = new Helipuerto(pos3);
	
		avion1 = new AvionPesado(pos1,pos2,mapa);
		AvionSimple avion2 = new AvionSimple(pos3,pos4,mapa);
		AvionComputarizado avion3 = new AvionComputarizado(pos5,mapa);
		
		pistas = new ArrayList<Pista>();
		pistas.add(pista);
		pistas.add(pista2);
		pistas.add(pista3);
		
		mapa = new Mapa(pistas);
		mapa.colocarAvionEnAire(avion1);
		mapa.colocarAvionEnAire(avion2);
		mapa.colocarAvionEnAire(avion3);

		nivel = new Nivel(mapa,dificultad);
		
		niveles = new ArrayList<Nivel>();
		niveles.add(nivel);
		
		jugador = new Jugador("Nicolas");
		
		juego = new Juego(jugador,niveles);
	}
	
	
	
	@Test
	public void verificarUltimoNivel() {
		assertTrue("Se gano el juego?",juego.esJuegoGanado());
	}
	
}
