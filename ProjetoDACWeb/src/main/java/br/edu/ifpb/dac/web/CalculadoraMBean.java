package br.edu.ifpb.dac.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.ifpb.dac.ejb.services.CalculadoraControllerLocal;

@Named
@RequestScoped
public class CalculadoraMBean {


	private double numero1;
	private double numero2;
	
	private double resultado;
	
	private String operacao;

	@EJB
	private CalculadoraControllerLocal calculadora;

	public void calcular() {
		switch(operacao) {
		case "soma":
			resultado = calculadora.soma(numero1, numero2);
			break;
		case "subtracao":
			resultado = calculadora.subtrai(numero1, numero2);
			break;
		case "multiplicacao":
			resultado = calculadora.multiplica(numero1, numero2);
			break;
		case "divisao":
			resultado = calculadora.divide(numero1, numero2);
			break;
		default:
			FacesMessage msg = new FacesMessage("Operacao desconhecida");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public double getNumero1() {
		return numero1;
	}

	public void setNumero1(double numero1) {
		this.numero1 = numero1;
	}

	public double getNumero2() {
		return numero2;
	}

	public void setNumero2(double numero2) {
		this.numero2 = numero2;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	
}
