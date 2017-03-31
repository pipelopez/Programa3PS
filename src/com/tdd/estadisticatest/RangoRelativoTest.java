package com.tdd.estadisticatest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.estadisticadev.RangoRelativo;

public class RangoRelativoTest {

	final double lnVs = 1.4805;
	final double lnS = 2.1410;
	final double lnM = 2.8015;
	final double lnL = 3.4620;
	final double LnVl = 4.1225;
	final RangoRelativo rangoRelativo = new RangoRelativo();
	
	@Test
	public void testVerySmall(){
		double resultado = rangoRelativo.verySmall(lnVs);
		System.out.println("VS= "+ resultado);
		assertEquals(4.39, resultado, 0.5);
	}
	
	@Test
	public void testSmall(){
		double resultado = rangoRelativo.small(lnS);
		System.out.println("S= "+ resultado);
		assertEquals(8.50, resultado, 0.5);
	}
	
	@Test
	public void testMedium(){
		double resultado = rangoRelativo.medium(lnM);
		System.out.println("M= "+ resultado);
		assertEquals(16.46, resultado, 0.5);
	}
	
	@Test
	public void testLarge(){
		double resultado = rangoRelativo.large(lnL);
		System.out.println("L= "+ resultado);
		assertEquals(31.88, resultado, 0.5);
	}
	
	@Test
	public void testVeryLarge(){
		double resultado = rangoRelativo.verylarge(LnVl);
		System.out.println("VL= "+ resultado);
		assertEquals(61.71, resultado, 0.5);
	}

}
