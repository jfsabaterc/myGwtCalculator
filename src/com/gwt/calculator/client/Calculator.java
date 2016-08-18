package com.gwt.calculator.client;

import com.gwt.calculator.client.handlers.BtnOperationClickHandler;
import com.gwt.calculator.client.handlers.CBtnClickHandler;
import com.gwt.calculator.client.handlers.CEBtnClickHandler;
import com.gwt.calculator.client.handlers.NumericBtnClickHandler;
import com.gwt.calculator.client.handlers.SignChangeClickHandler;
import com.gwt.calculator.shared.FieldVerifier;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.calculator.client.GlobalVars.operation;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Calculator implements EntryPoint {

	private TextField inputField;

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void createCalculator() {
		inputField = new TextField();
		RootPanel.get("inputFieldContainer").add(inputField);
		addNumericButtons();
		addFirstLineButtons();
		addOperationalButtons();

	}

	/**
	 * Añade los botones de la primera fila del formulario, es decir C y CE
	 */
	public void addFirstLineButtons() {
		//Creamos los botones con el texto que debe aparecer

		final TextButton btnC = new TextButton("C");
		final TextButton btnCE = new TextButton("CE");

		//Los asignamos al html
		RootPanel.get("firstLineButtonContainer").add(btnC);
		RootPanel.get("firstLineButtonContainer").add(btnCE);
		//RootPanel.get("firstLineButtonContainer").add(btnNuevoButton);

		//Añadimos un manejador del evento click
		btnC.addSelectHandler(new CBtnClickHandler(inputField));
		btnCE.addSelectHandler(new CEBtnClickHandler(inputField));

		GlobalVars.operingOne = 0.0;

	}

	public void addOperationalButtons() {
		//Creamos los botones con el texto que debe aparecer

		final TextButton btnSignChange = new TextButton("+/-");
		final TextButton btnPercentaje = new TextButton("%");
		final TextButton btnAdd = new TextButton("+");
		final TextButton btnSubstract = new TextButton("-");
		final TextButton btnMultiply = new TextButton("*");
		final TextButton btnDivide = new TextButton("/");

		final TextButton btnResult = new TextButton("=");

		//Los asignamos al html
		RootPanel.get("secondLineButtonContainer").add(btnSignChange);
		RootPanel.get("secondLineButtonContainer").add(btnPercentaje);

		RootPanel.get("thirdLineButtonContainer").add(btnAdd);
		RootPanel.get("thirdLineButtonContainer").add(btnSubstract);

		RootPanel.get("fourthLineButtonContainer").add(btnMultiply);
		RootPanel.get("fourthLineButtonContainer").add(btnDivide);

		RootPanel.get("fithLineButtonContainer").add(btnResult);

		//RootPanel.get("firstLineButtonContainer").add(btnNuevoButton);

		//Añadimos un manejador del evento click
		btnSignChange.addSelectHandler(new SignChangeClickHandler(inputField));
		//
		btnPercentaje.addSelectHandler(new BtnOperationClickHandler(inputField, operation.PERCENTAJE));
		btnAdd.addSelectHandler(new BtnOperationClickHandler(inputField, operation.ADD));
		btnSubstract.addSelectHandler(new BtnOperationClickHandler(inputField, operation.SUBTRACT));
		btnMultiply.addSelectHandler(new BtnOperationClickHandler(inputField, operation.MULTIPLICATION));
		btnDivide.addSelectHandler(new BtnOperationClickHandler(inputField, operation.DIVISION));
		btnResult.addSelectHandler(new BtnOperationClickHandler(inputField, operation.RESULT));

	}

	/**
	 * Añade los botones numéricos al formulario
	 */
	public void addNumericButtons() {
		//Creamos los botones con el texto que debe aparecer

		final TextButton btnOne = new TextButton("1");
		final TextButton btnTwo = new TextButton("2");
		final TextButton btnThree = new TextButton("3");
		final TextButton btnFour = new TextButton("4");
		final TextButton btnFive = new TextButton("5");
		final TextButton btnSix = new TextButton("6");
		final TextButton btnSeven = new TextButton("7");
		final TextButton btnEight = new TextButton("8");
		final TextButton btnNine = new TextButton("9");
		final TextButton btnZero = new TextButton("0");
		final TextButton btnDecimalPoint = new TextButton(".");

		//Los asignamos al html

		RootPanel.get("secondLineButtonContainer").add(btnOne);
		RootPanel.get("secondLineButtonContainer").add(btnTwo);
		RootPanel.get("secondLineButtonContainer").add(btnThree);
		RootPanel.get("thirdLineButtonContainer").add(btnFour);
		RootPanel.get("thirdLineButtonContainer").add(btnFive);
		RootPanel.get("thirdLineButtonContainer").add(btnSix);
		RootPanel.get("fourthLineButtonContainer").add(btnSeven);
		RootPanel.get("fourthLineButtonContainer").add(btnEight);
		RootPanel.get("fourthLineButtonContainer").add(btnNine);
		RootPanel.get("fithLineButtonContainer").add(btnZero);
		RootPanel.get("fithLineButtonContainer").add(btnDecimalPoint);

		//Añadimos un manejador del evento click
		btnOne.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnTwo.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnThree.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnFour.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnFive.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnSix.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnSeven.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnEight.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnNine.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnZero.addSelectHandler(new NumericBtnClickHandler(inputField));
		btnDecimalPoint.addSelectHandler(new NumericBtnClickHandler(inputField));
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		createCalculator();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}

}