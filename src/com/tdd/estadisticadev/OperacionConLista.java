package com.tdd.estadisticadev;

import com.tdd.listas.ListaEnlazada;
import com.tdd.listas.Nodo;

public class OperacionConLista {

	public ListaEnlazada dividirListas(ListaEnlazada l1, ListaEnlazada l2) {
		ListaEnlazada listaDivision = new ListaEnlazada();
		Nodo datoL1 = l1.primero();
		Nodo datoL2 = l2.primero();
		if (verificarListas(l1, l2) == true) {

			do {
				listaDivision.insertarFin(datoL1.retorneDato() / datoL2.retorneDato());
				datoL1 = datoL1.retorneSig();
				datoL2 = datoL2.retorneSig();
			} while (datoL1 != l1.ultimo().retorneSig() && datoL2 != l2.ultimo().retorneSig());
		}
		return listaDivision;
	}

	public ListaEnlazada sacarLn(ListaEnlazada l1) {
		ListaEnlazada listaLn = new ListaEnlazada();
		Nodo datoL1 = l1.primero();
		if (!l1.esVacia()) {
			do {
				listaLn.insertarFin(Math.log(datoL1.retorneDato()));
				datoL1 = datoL1.retorneSig();
			} while (datoL1 != l1.ultimo().retorneSig());
		}
		return listaLn;
	}

	public ListaEnlazada sacarLnMenosAvg(ListaEnlazada l1, double media) {
		ListaEnlazada listaLnMenosAvg = new ListaEnlazada();
		Nodo datoL1 = l1.primero();
		if (!l1.esVacia()) {
			do {
				listaLnMenosAvg.insertarFin(Math.pow((datoL1.retorneDato() - media), 2));
				datoL1 = datoL1.retorneSig();
			} while (datoL1 != l1.ultimo().retorneSig());
		}
		return listaLnMenosAvg;
	}

	public double calcularDatosLista(ListaEnlazada l1) {

		if (l1.esVacia()) {
			return 0;
		}
		double numeroValores = 0;
		Nodo dato = l1.primero();
		do {
			dato = dato.retorneSig();
			numeroValores += 1;
		} while (dato != l1.ultimo().retorneSig());
		return numeroValores;

	}

	public boolean verificarListas(ListaEnlazada lx, ListaEnlazada ly) {

		double tamanoLx = calcularDatosLista(lx);
		double tamanoLy = calcularDatosLista(ly);
		if (lx.esVacia() || ly.esVacia() || tamanoLx != tamanoLy) {
			return false;
		} else {
			return true;
		}
	}

}
