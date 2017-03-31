package com.tdd.estadisticadev;

public class RangoLogaritmico {

	public double lnVerySmall(double resultadoMedia, double resultadoDesvEstandar){
		return (resultadoMedia-(2*resultadoDesvEstandar));
	}
	
	public double lnSmall(double resultadoMedia, double resultadoDesvEstandar){
		return (resultadoMedia-resultadoDesvEstandar);
	}
	
	public double lnMedium(double resultadoMedia){
		return resultadoMedia;
	}
	
	public double lnLarge(double resultadoMedia, double resultadoDesvEstandar){
		return (resultadoMedia+resultadoDesvEstandar);
	}
	
	public double lnVeryLarge(double resultadoMedia, double resultadoDesvEstandar){
		return (resultadoMedia+(2*resultadoDesvEstandar));
	}
}
