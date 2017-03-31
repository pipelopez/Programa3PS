package com.tdd.estadisticatest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.tdd.archivosplanos.Chooser;
import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.Estadistica;
import com.tdd.estadisticadev.OperacionConLista;
import com.tdd.listas.ListaEnlazada;
import com.tdd.listas.Nodo;

public class OperacionConListaTest {

	static final String loc = Chooser.rutaArchivo();
	static final String method = Chooser.rutaArchivo();
	final OperacionConLista operacionConLista = new OperacionConLista();
	final LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
	final Estadistica estadistica = new Estadistica();
	
	@Test
	public void testVerificarListasVacias() {
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		boolean resultado = operacionConLista.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de listas es: "+ resultado+ ", no tienen datos o difieren en tamaño");
		assertEquals(false, resultado);
	}

	@Test
	public void testCalcularDatosListaVacia() {
		ListaEnlazada l1 = new ListaEnlazada();		
		double total = operacionConLista.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en la lista es: "+ total);
		assertEquals(0.0, total, 0);
	}
	
	@Test
	public void testCalcularDatosLoc() {
		ListaEnlazada l1 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		double cantDatos = operacionConLista.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en el archivo es: "+ cantDatos);
		assertEquals(13.0, cantDatos, 0.05);
	}
	
	@Test
	public void testVerificarDatosArchivos() {
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado = operacionConLista.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de archivos es: "+ resultado+", son iguales en tamaño y tienen datos.");
		assertEquals(true, resultado);
	}

	@Test
	public void testDividirArchivos() {
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		ListaEnlazada listaResultado= new ListaEnlazada();
		Nodo nodo = new Nodo();
		listaResultado = operacionConLista.dividirListas(l1, l2);
		nodo = listaResultado.primero();
		System.out.println("El resultado de división para la primer fila es: "+ nodo.retorneDato());
		assertEquals(6.0, nodo.retorneDato(), 0.05);
	}


	@Test
	public void testSacarLn() {
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		ListaEnlazada listaResultado= new ListaEnlazada();
		Nodo nodo = new Nodo();
		listaResultado = operacionConLista.dividirListas(l1, l2);
		listaResultado = operacionConLista.sacarLn(listaResultado);
		nodo = listaResultado.primero();
		System.out.println("El resultado de ln para la primer fila es: "+ nodo.retorneDato());
		assertEquals(1.79, nodo.retorneDato(), 0.05);		
	}
	
	@Test
	public void testSacarLnMenosAvg() {
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		ListaEnlazada listaResultado= new ListaEnlazada();
		Nodo nodo = new Nodo();
		listaResultado = operacionConLista.dividirListas(l1, l2);
		listaResultado = operacionConLista.sacarLn(listaResultado);
		double media = estadistica.calcularMediaLista(listaResultado);
		listaResultado = operacionConLista.sacarLnMenosAvg(listaResultado, media);
		nodo = listaResultado.primero();
		System.out.println("El resultado de ln menos avg para la primer fila es: "+ nodo.retorneDato());
		assertEquals(1.0196, nodo.retorneDato(), 0.05);		
	}
}
