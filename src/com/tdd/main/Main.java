package com.tdd.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.tdd.archivosplanos.Chooser;
import com.tdd.archivosplanos.LeerArchivoTxt;
import com.tdd.estadisticadev.Estadistica;
import com.tdd.estadisticadev.OperacionConLista;
import com.tdd.estadisticadev.RangoLogaritmico;
import com.tdd.estadisticadev.RangoRelativo;
import com.tdd.listas.ListaEnlazada;

public class Main {

	static final String loc = Chooser.rutaArchivo();
	static final String method = Chooser.rutaArchivo();
	
	public static void main(String[] args) {
		realizarCalculos();
	}
	
	public static void realizarCalculos(){
		Estadistica estadistica = new Estadistica();
		RangoLogaritmico rangoLogaritmico = new RangoLogaritmico();
		RangoRelativo rangoRelativo = new RangoRelativo();
		OperacionConLista operacionConLista = new OperacionConLista();
		ListaEnlazada l1 = new ListaEnlazada();
		ListaEnlazada l2 = new ListaEnlazada();
		LeerArchivoTxt lectorArchivo = new LeerArchivoTxt();
		try {
			//Leer los dos archivos y crear las listas
			l1 = lectorArchivo.leerArchivoDouble(loc);
			l2 = lectorArchivo.leerArchivoDouble(method);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: No se encontró el archivo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
		//Realizar la división de las listas por cada parámetro
		ListaEnlazada listaDivision = operacionConLista.dividirListas(l1, l2);
		//Sacar el ln de cada parámetro de la nueva lista
		ListaEnlazada listaLn = operacionConLista.sacarLn(listaDivision);
		//Calcular la media de la lista con los ln
		double mediaLista = estadistica.calcularMediaLista(listaLn);
		System.out.println("La media de la lista es: "+mediaLista);
		//Calcular ln-media para cada dato de la lista con los ln
		ListaEnlazada listaLnMenosMedia = operacionConLista.sacarLnMenosAvg(listaLn, mediaLista);
		//Calcular la varianza de la nueva lista
		double varianzaLista = estadistica.calcularVarianza(listaLnMenosMedia, mediaLista);
		System.out.println("La varianza de la lista es: "+varianzaLista);
		//Ahora calcular la desviación estandar
		double desvEstandar = estadistica.calcularDesviacionEstandar(varianzaLista);
		System.out.println("La desviación estandar de la lista es: "+ desvEstandar);
		//Calcular los rangos logarítmicos
		double lnVerySmall = rangoLogaritmico.lnVerySmall(mediaLista, desvEstandar);
		System.out.println("El resultado para el logaritmo very small es: "+lnVerySmall);
		double lnSmall = rangoLogaritmico.lnSmall(mediaLista, desvEstandar);
		System.out.println("El resultado para el logaritmo small es: "+lnSmall);
		double lnMedium = rangoLogaritmico.lnMedium(mediaLista);
		System.out.println("El resultado para el logaritmo medium es: "+lnMedium);
		double lnLarge = rangoLogaritmico.lnLarge(mediaLista, desvEstandar);
		System.out.println("El resultado para el logaritmo large es: "+lnLarge);
		double lnVeryLarge = rangoLogaritmico.lnVeryLarge(mediaLista, desvEstandar);
		System.out.println("El resultado para el logaritmo very large es: "+lnVeryLarge);
		//Calcular los rangos relativos
		double verySmall = rangoRelativo.verySmall(lnVerySmall);
		System.out.println("El resultado para el very small es: "+verySmall);
		double small = rangoRelativo.small(lnSmall);
		System.out.println("El resultado para el logaritmo small es: "+small);
		double medium = rangoRelativo.medium(lnMedium);
		System.out.println("El resultado para el logaritmo medium es: "+medium);
		double large = rangoRelativo.large(lnLarge);
		System.out.println("El resultado para el logaritmo large es: "+large);
		double veryLarge = rangoRelativo.verylarge(lnVeryLarge);
		System.out.println("El resultado para el logaritmo very large es: "+veryLarge);
		
	}

}
