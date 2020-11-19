package com.heredia.testIntegracion;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import avion.AvionPesado;
import copControl.Mapa;
import copControl.Posicion;
import pista.Pista;
import pista.PistaLarga;
import pista.PosicionesEntradaVaciaException;

public class TestMapa {
	private Mapa mapa;
	private Mapa mapaMov;
	private List<Pista> pistas;
	private PistaLarga pista;
	private Posicion pos;
	private AvionPesado avion;
	
	@Before
	public void setUp() throws PosicionesEntradaVaciaException {
		pos = new Posicion(10,10);
		pista = new PistaLarga(pos);
		pistas = new ArrayList<Pista>();
		pistas.add(pista);
		mapaMov = new Mapa();
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(5,5);
		avion = new AvionPesado(pos1,pos2,mapaMov);
		mapa = new Mapa(pistas);
		mapa.colocarAvionEnAire(avion);
		
	}
	
	
	@Test
	public void testTieneAvionesVolando() {
		assertTrue("Tiene aviones volando?",mapa.tieneAvionesVolando());
	}
}
