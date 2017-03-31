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
	
	@Test
	public void testVerificarListasVacias() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		boolean resultado = operacionConLista.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de listas vacías es: "+ resultado);
		assertEquals(false, resultado);
	}

	@Test
	public void testCalcularDatosListaVacia() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();		
		double total = operacionConLista.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en la lista es: "+ total);
		assertEquals(0.0, total, 0);
	}
	
	@Test
	public void testCalcularDatosLoc() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		double cantDatos = operacionConLista.calcularDatosLista(l1);
		System.out.println("La cantidad de datos en la lista es: "+ cantDatos);
		assertEquals(13.0, cantDatos, 0.05);
	}
	
	@Test
	public void testVerificarDatosArchivos() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado = operacionConLista.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de archivos es: "+ resultado);
		assertEquals(true, resultado);
	}

	/*@Test
	private void testVerificarListasArchivos() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado = operacionConLista.verificarListas(l1, l2);
		System.out.println("El resultado de verificación de las listas es: "+ resultado);
		assertEquals(true, resultado);
	}

	/*@Test
	private void testDividirListas() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado=false;
		ListaEnlazada listaResultado = operacionConLista.dividirListas(l1, l2);
		if(!listaResultado.esVacia()){
			resultado = true;
		}
		Nodo nodo = new Nodo();
		nodo = listaResultado.primero();
		System.out.println("El primer dato de la lista dividida es: "+ nodo.retorneDato());
		assertEquals(true, resultado);
	}
	
	@Test
	private void testSacarLn() {
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado=false;
		ListaEnlazada listaResultado = operacionConLista.sacarLn(l1);
		if(!listaResultado.esVacia()){
			resultado = true;
		}
		Nodo nodo = new Nodo();
		nodo = listaResultado.primero();
		System.out.println("El primer dato de la lista Ln es: "+ nodo.retorneDato());
		assertEquals(true, resultado);	
	}
	
	@Test
	private void testSacarLnMenosAvg() {
		OperacionConLista operacionConLista = new OperacionConLista();
		Estadistica estadistica = new Estadistica();
		ListaEnlazada l1 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		boolean resultado=false;
		double media = estadistica.calcularMediaLista(l1);
		ListaEnlazada listaResultado = operacionConLista.sacarLnMenosAvg(l1, media);
		if(!listaResultado.esVacia()){
			resultado = true;
		}
		Nodo nodo = new Nodo();
		nodo = listaResultado.primero();
		System.out.println("El primer dato de la lista Ln menos avg es: "+ nodo.retorneDato());
		assertEquals(true, resultado);	
	}*/
}
