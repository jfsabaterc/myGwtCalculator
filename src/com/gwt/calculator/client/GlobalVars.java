package com.gwt.calculator.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

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
