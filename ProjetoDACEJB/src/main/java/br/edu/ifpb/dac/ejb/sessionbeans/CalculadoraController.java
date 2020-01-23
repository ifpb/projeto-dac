package br.edu.ifpb.dac.ejb.sessionbeans;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.*;

import br.edu.ifpb.dac.ejb.services.CalculadoraControllerLocal;
import br.edu.ifpb.dac.ejb.services.CalculadoraControllerRemote;

@Stateless
@Local(CalculadoraControllerLocal.class)
@Remote(CalculadoraControllerRemote.class)
public class CalculadoraController implements CalculadoraControllerLocal, CalculadoraControllerRemote {

	@Resource(mappedName = "jms/ifpbcz")
	private Queue queue;

	@Resource(mappedName = "jms/connectionFactory")
	private ConnectionFactory connectionFactory;

	private void enviarMensagem(String msg) throws JMSException {
		Session session = connectionFactory.createConnection().createSession();
		MessageProducer producer = session.createProducer(queue);
		TextMessage textMessage = session.createTextMessage(msg);
		textMessage.setStringProperty("tipo", "clima");
		producer.send(textMessage);
	}

	public double soma(double n1, double n2) {
		double soma = n1+n2;
		try {
			enviarMensagem(String.format("A soma de %f com %f é %f", n1, n2, soma));
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return soma;
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
