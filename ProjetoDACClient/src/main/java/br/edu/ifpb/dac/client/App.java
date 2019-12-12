package br.edu.ifpb.dac.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifpb.dac.ejb.sessionbeans.CalculadoraControllerRemote;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws NamingException
    {
    	
        System.out.println("Bem-vindos à Calculadora");
    	
        InitialContext ic = new InitialContext();
        CalculadoraControllerRemote calculadoraController = (CalculadoraControllerRemote) ic.
        		lookup("java:global/ProjetoDACEAR/ProjetoDACWeb-0.0.1-SNAPSHOT/CalculadoraController!br.edu.ifpb.dac.ejb.sessionbeans.CalculadoraControllerRemote");
        
        System.out.println("SOMA = "+ calculadoraController.soma(5, 5));
        System.out.println("SUBTRACAO = "+ calculadoraController.subtrai(500, 90));
        
    }
}
