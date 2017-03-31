package com.tdd.estadisticatest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.tdd.archivosplanos.Chooser;
import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.Estadistica;
import com.tdd.listas.ListaEnlazada;

public class EstadisticaTest {

	static final String loc = Chooser.rutaArchivo();
	static final String method = Chooser.rutaArchivo();
	final Estadistica estadistica = new Estadistica();
	final LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
	
	@Test
	public void testMediaListaVacia(){
		ListaEnlazada l1 = new ListaEnlazada();
		double mediaValor  = estadistica.calcularMediaLista(l1);
		System.out.println("El resultado de la media de la lista vacía es: "+ mediaValor);
		assertEquals(0, mediaValor, 0);
	}
	
	@Test
	public void testMediaLista(){
		ListaEnlazada l1 = new ListaEnlazada();
		
		for (int i = 0; i < 10; i++) {
			l1.insertarFin(2.0);	
		}
		double mediaValor  = estadistica.calcularMediaLista(l1);
		System.out.println("El resultado de la media de la lista es: "+ mediaValor);
		assertEquals(2, mediaValor, 0);
	}
	
	@Test
	public void testMediaLoc() {
		ListaEnlazada l1 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		double resultadoMedia = estadistica.calcularMediaLista(l1);
		System.out.println("El resultado de la media de los datos en el archivo LOC es: "+ resultadoMedia);
		assertEquals(109.92, resultadoMedia, 0.05);
	}
	
	@Test
	public void testVarianzaLoc() {
		ListaEnlazada l1 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(loc);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}

		double resultadoMedia = estadistica.calcularMediaLista(l1);
		double resultadoVarianza = estadistica.calcularVarianza(l1, resultadoMedia);
		System.out.println("El resultado de la varianza de LOC es: "+ resultadoVarianza);
		assertEquals(119.08, resultadoVarianza, 0.05);
	}
	
	@Test
	public void testDesviacionEstandarMethod() {
		ListaEnlazada l1 = new ListaEnlazada();
		try {
			l1 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			   JOptionPane.showMessageDialog(null,"Error: No se encontró el archivo",
			      "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		double resultadoMedia = estadistica.calcularMediaLista(l1);
		double resultadoVarianza = estadistica.calcularVarianza(l1, resultadoMedia);
		double resultadoDesviacionEstandar = estadistica.calcularDesviacionEstandar(resultadoVarianza);
		System.out.println("El resultado de la desviación estandar de METHOD es: "+ resultadoDesviacionEstandar);
		assertEquals(2.19, resultadoDesviacionEstandar, 0.05);
	}

}
