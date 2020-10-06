package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VueController {

	private Double drap;
	private String operateur ="";
	private Double calcul;
	private boolean acalculer = false;
	
	@FXML
	private Label resultat;
	
	@FXML
	private Button num0;
	
	@FXML
	private Button num1;
	
	@FXML
	private Button num2;
	
	@FXML
	private Button num3;
	
	@FXML
	private Button num4;
	
	@FXML
	private Button num5;
	
	@FXML
	private Button num6;
	
	@FXML
	private Button num7;
	
	@FXML
	private Button num8;
	
	@FXML
	private Button num9;
	
	@FXML
	private Button additionner;
	
	@FXML
	private Button soustraire;
	
	@FXML
	private Button multiplie;
	
	@FXML
	private Button diviser;
	
	@FXML
	private Button point;
	
	@FXML
	private Button egal;
	

	public void clickButton(ActionEvent e) {
		String btn = e.getSource().toString();
		String num = btn.substring(btn.length()-2,btn.length()-1);
		this.searchBut(num);
	}
	
	public Double calculer(double ch1,double ch2,String operateur) {
		switch(operateur) {
		case "/":
			calcul = (double) (ch1 / ch2);
		break;
		case "*":
			calcul = (double) (ch1 * ch2);
		break;
		case "+":
			calcul = (double) (ch1 + ch2);
		break;
		case "-":
			calcul = (double) (ch1 - ch2);
		break;
		}
		return calcul;
	}
	
	public void searchBut(String id) {
		switch(id) {
		case "/":
			String Num1 = resultat.getText();
			drap = Double.parseDouble(Num1);
			operateur = "/";
			acalculer= true;
		break;
		case "x":
			String Num2 = resultat.getText();
			drap = Double.parseDouble(Num2);
			operateur = "*";
			acalculer= true;
		break;
		case "+":
			String Num3 = resultat.getText();
			drap = Double.parseDouble(Num3);
			operateur = "+";
			acalculer= true;
		break;
		case "=":
			String Num4 = resultat.getText();
			Double calcul = this.calculer(drap, Double.parseDouble(Num4),operateur);
			DecimalFormat df = new DecimalFormat("0.00"); // import java.text.DecimalFormat;
			resultat.setText(df.format(calcul).toString());
			acalculer= true;
		break;
		case "-":
			String Num5 = resultat.getText();
			drap = Double.parseDouble(Num5);
			operateur = "-";
		break;
		default:
			if (resultat.getText().equals("0")) {
				resultat.setText("");
				resultat.setText(id);
			}else {
				if (acalculer == false) {
					resultat.setText(resultat.getText() + id);
					
				}else {
					resultat.setText("");
					resultat.setText(id);
					acalculer = false;
				}
			}
		break;
		}
	}

}
