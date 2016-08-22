package com.gwt.calculator.client;


/**
 * Se usa para guardar las variables globales de la aplicación cliente
 * @author Juan_Fran
 *
 */
public class GlobalVars {

	
	public enum operation {
		ADD, SUBTRACT, MULTIPLICATION, DIVISION, RESULT, PERCENTAJE
	}

	public enum pressedButton {
		NUMERIC, FUNCTION, SIGNCHANGE
	}

	/**
	 * Primer operando, vamos guardando también el resultado de las operaciones
	 */
	public static Double operingOne;

	/**
	 * Segundo operando, valor reción introducido
	 */
	public static Double operingTwo;

	/**
	 * última operación solicitada
	 */
	public static operation lastOperation;

	/**
	 * último tipo de botón pulsado
	 */
	public static pressedButton lastPressedBtn;
	

	/**
	 * Quita los valores de las variables de entorno
	 */
	public static void clear() {

		lastPressedBtn = pressedButton.FUNCTION;
		
		operingTwo = null;
		operingOne = 0.0;
		lastOperation = null;

	}
	
	
}
