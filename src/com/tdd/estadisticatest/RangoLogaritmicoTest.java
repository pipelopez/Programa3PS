package com.tdd.estadisticatest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.estadisticadev.RangoLogaritmico;

public class RangoLogaritmicoTest {

	final double resultadoDesvEstandar = 0.6605;
	final double resultadoMedia = 2.8015;
	final RangoLogaritmico rangoLogaritmico = new RangoLogaritmico();
	
	@Test
	public void testLnVerySmall(){
		double resultado = rangoLogaritmico.lnVerySmall(resultadoMedia, resultadoDesvEstandar);
		System.out.println("Ln(VS): "+ resultado);
		assertEquals(1.48, resultado, 0.5);
	}
	
	@Test
	public void testLnSmall(){
		double resultado = rangoLogaritmico.lnSmall(resultadoMedia, resultadoDesvEstandar);
		System.out.println("Ln(S): "+ resultado);
		assertEquals(2.14, resultado, 0.5);
	}
	
	@Test
	public void testLnMedium(){
		double resultado = rangoLogaritmico.lnMedium(resultadoMedia);
		System.out.println("Ln(M): "+ resultado);
		assertEquals(2.80, resultado, 0.5);
	}
	
	@Test
	public void testLnLarge(){
		double resultado = rangoLogaritmico.lnLarge(resultadoMedia, resultadoDesvEstandar);
		System.out.println("Ln(L): "+ resultado);
		assertEquals(3.46, resultado, 0.5);
	}
	
	@Test
	public void testLnVeryLarge(){
		double resultado = rangoLogaritmico.lnVeryLarge(resultadoMedia, resultadoDesvEstandar);
		System.out.println("Ln(VL): "+ resultado);
		assertEquals(4.12, resultado, 0.5);
	}

}
