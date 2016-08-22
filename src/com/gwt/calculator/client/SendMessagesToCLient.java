package com.gwt.calculator.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SendMessagesToCLient {
	public final static char CR = (char) 0x0D;
	public final static char LF = (char) 0x0A;
	public final static String CRLF = "" + CR + LF;

	public static String messageToSend;

	public static void clearMessage() {
		messageToSend = "";
	}

	/**
	 * Añade el nuevo mensaje para enviarlo luego al cliente
	 * @param message
	 */
	public static void addMessage(String message) {
		messageToSend = messageToSend + CRLF + message;

	}
	
	/**
	 * Muestra en el cliente el mensaje generado
	 */
	public static void sendMessage() {
		alertWidget(messageToSend).center();
	}

	/**
	 * Muestra una ventada en el cliente, con un header por defecto
	 * @param message
	 */
	public static void sendMessage(String message) {
		alertWidget(message).center();
	}

	/**
	 * Muestra una ventana en el cliente, con un header por defecto
	 * @param content
	 * @return
	 */
	public static DialogBox alertWidget(final String content) {

		return alertWidget("Mensaje", content);
	}

	/**
	 * Muestra una ventana en el cliente
	 * @param header
	 * @param content
	 * @return
	 */
	public static DialogBox alertWidget(final String header, final String content) {
		final DialogBox box = new DialogBox();
		final VerticalPanel panel = new VerticalPanel();
		box.setText(header);
		panel.add(new Label(content));
		final Button buttonClose = new Button("Close", new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				box.hide();
			}
		});
		// few empty labels to make widget larger
		final Label emptyLabel = new Label("");
		emptyLabel.setSize("auto", "25px");
		panel.add(emptyLabel);
		panel.add(emptyLabel);
		buttonClose.setWidth("90px");
		panel.add(buttonClose);
		panel.setCellHorizontalAlignment(buttonClose, HasAlignment.ALIGN_RIGHT);
		box.add(panel);
		box.center();
		return box;
	}

}
