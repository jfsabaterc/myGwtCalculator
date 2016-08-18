package com.gwt.calculator.client.handlers;

import com.gwt.calculator.client.GlobalVars;
import com.gwt.calculator.client.GlobalVars.operation;
import com.gwt.calculator.client.GlobalVars.pressedButton;
import com.gwt.calculator.client.SendMessagesToCLient;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

public class BtnOperationClickHandler implements SelectHandler {

	public String mensajeString;

	public operation op;

	public TextField textBox;

	public BtnOperationClickHandler(TextField textBox, operation op) {

		this.textBox = textBox;
		this.op = op;
	}

	/**
	 * Añade y actualiza el número actual del display al valor que había anteriormente
	 */
	@Override
	public void onSelect(SelectEvent event) {
		String text;
		Double nuevoNumero;
		mensajeString = new String();
		//Obtenemos el texto del display
		text = textBox.getText();

		//Tratamos de convertir el valor a double
		nuevoNumero = Double.parseDouble(text);

		SendMessagesToCLient.clearMessage();

		//Si tenemos operación pendiente, y ya habíamos cargado algo para operar (la otra parte del if)
		if (GlobalVars.lastOperation != null && GlobalVars.operingOne != null) {

			SendMessagesToCLient.addMessage("Entramos a operar");
			SendMessagesToCLient.addMessage("GlobalVars.operingOne: " + GlobalVars.operingOne.toString());
			SendMessagesToCLient.addMessage("GlobalVars.operingTwo: " + GlobalVars.operingTwo.toString());
			
			//El operando 1 es el número antiguo
			
			//El operando 2 es el nuevo número
			GlobalVars.operingTwo = nuevoNumero;

			//Operamos
			operate();

			//Convertimos a string el resultado
			text = GlobalVars.operingOne.toString();

			//Actualizamos el display
			textBox.setText(text);
			
			SendMessagesToCLient.addMessage("Resultado al display: " + text);

		} else {
			//El nuevo número pulsado pasa a ser el primer operando
			GlobalVars.operingOne = nuevoNumero;
			SendMessagesToCLient.addMessage("GlobalVars.operingOne = nuevoNumero;" + GlobalVars.operingOne);

		}

		//Actualizamos lo operación pulsada
		//

		GlobalVars.lastOperation = op;
		
		SendMessagesToCLient.addMessage("GlobalVars.lastOperation=op: " + GlobalVars.lastOperation.toString());
		SendMessagesToCLient.addMessage("GlobalVars.operingOne: " + GlobalVars.operingOne.toString());
				

		//Actualizamos el valor del último botón pulsado
		GlobalVars.lastPressedBtn = pressedButton.FUNCTION;

	}

	/**
	 * Operamos dependiendo de la función seleccionada
	 */
	public void operate() {
		switch (op) {
		case ADD:
			//Sumamos el valor a lo que teníamos en la memoria
			GlobalVars.operingOne = GlobalVars.operingOne + GlobalVars.operingTwo;
			break;
		case SUBTRACT:
			//Restamos el valor a lo que teníamos en la memoria
			GlobalVars.operingOne = GlobalVars.operingOne - GlobalVars.operingTwo;
			break;
		case MULTIPLICATION:
			//Multiplicamos el valor a lo que teníamos en la memoria
			GlobalVars.operingOne = GlobalVars.operingOne * GlobalVars.operingTwo;
			break;
		case DIVISION:
			//Dividimos el valor a lo que teníamos en la memoria
			GlobalVars.operingOne = GlobalVars.operingOne / GlobalVars.operingTwo;
			break;
		case RESULT:
			//Ya no quedan operaciones pendientes, así que quitamos de la memoria los últimos
			GlobalVars.lastOperation = null;
			GlobalVars.operingTwo = null;
			break;
		case PERCENTAJE:
			//Dividimos el valor a lo que teníamos en la memoria
			GlobalVars.operingOne /= GlobalVars.operingTwo;

			break;
		default:
			break;
		}

	}
}