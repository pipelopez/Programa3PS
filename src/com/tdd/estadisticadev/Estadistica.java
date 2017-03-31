package com.tdd.estadisticadev;

import com.tdd.listas.ListaEnlazada;
import com.tdd.listas.Nodo;

public class Estadistica {

	public double calcularMediaLista(ListaEnlazada l1) {

		if (l1.esVacia()) {
			return 0;
		}
		double sumaValores = 0;
		double numeroValores = 0;
		Nodo dato = l1.primero();
		do {
			sumaValores += dato.retorneDato();
			dato = dato.retorneSig();
			numeroValores += 1;
		} while (dato != l1.ultimo().retorneSig());
		return sumaValores / numeroValores;

	}

	public double calcularVarianza(ListaEnlazada l1, double resultadoMedia) {

		if (l1.esVacia()) {
			return 0;
		}
		double sumaValores = 0;
		double numeroValores = 0;
		Nodo dato = l1.primero();
		do {
			sumaValores += dato.retorneDato();
			dato = dato.retorneSig();
			numeroValores += 1;
		} while (dato != l1.ultimo().retorneSig());
		return (sumaValores / (numeroValores - 1));
	}

	public double calcularDesviacionEstandar(double resultadoVarianza) {
		return Math.sqrt(resultadoVarianza);
	}
}
