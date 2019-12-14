package br.edu.ifpb.dac.ejb.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.ifpb.dac.ejb.services.CalculadoraControllerLocal;
import br.edu.ifpb.dac.ejb.services.CalculadoraControllerRemote;

@Stateless
@Local(CalculadoraControllerLocal.class)
@Remote(CalculadoraControllerRemote.class)
public class CalculadoraController implements CalculadoraControllerLocal, CalculadoraControllerRemote {

	public double soma(double n1, double n2) {
		return n1+n2;
	}
	
	public double subtrai(double n1, double n2) {
		return n1-n2;
	}

	public double multiplica(double n1, double n2) {
		return n1*n2;
	}
	
	public double divide(double n1, double n2) {
		return n1/n2;
	}
	
}
