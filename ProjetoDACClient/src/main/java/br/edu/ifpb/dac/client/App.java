package br.edu.ifpb.dac.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import br.edu.ifpb.dac.ejb.services.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.AutenticacaoService;
import br.edu.ifpb.dac.ejb.services.CalculadoraControllerRemote;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws NamingException
    {
    	
        InitialContext ic = new InitialContext();
        CalculadoraControllerRemote calculadoraController = (CalculadoraControllerRemote) ic.
        		lookup("java:global/ProjetoDACEAR/ProjetoDACWeb-0.0.1-SNAPSHOT/CalculadoraController!br.edu.ifpb.dac.ejb.sessionbeans.CalculadoraControllerRemote");
        
        System.out.println("SOMA = "+ calculadoraController.soma(5, 5));
        System.out.println("SUBTRACAO = "+ calculadoraController.subtrai(500, 90));
       
        AutenticacaoService autenticacaoService = (AutenticacaoService) ic.
        		lookup("java:global/ProjetoDACEAR/ProjetoDACWeb-0.0.1-SNAPSHOT/AutenticacaoService!br.edu.ifpb.dac.ejb.sessionbeans.AutenticacaoService");
        
        try {
			String login = JOptionPane.showInputDialog("Digite o login");
			String senha = JOptionPane.showInputDialog("Digite a senha");
			autenticacaoService.login(login, senha);
			JOptionPane.showMessageDialog(null, "Parabéns! Você está logado!");
		} catch (AutenticacaoExcecao e) {
			JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
		}
        
    }
}
