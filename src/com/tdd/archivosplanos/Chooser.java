package com.tdd.archivosplanos;

import javax.swing.JFileChooser;

public class Chooser {
	
	public static String rutaArchivo() {
		String ruta = "";
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			ruta = chooser.getSelectedFile().getPath();
		}
		return ruta;
	}

}
