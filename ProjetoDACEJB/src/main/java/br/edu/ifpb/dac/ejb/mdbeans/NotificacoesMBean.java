package br.edu.ifpb.dac.ejb.mdbeans;

import br.edu.ifpb.dac.ejb.sessionbeans.NotificacoesController;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(mappedName = "jms/notificacoes", activationConfig = {
@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "tipo = 'tempo'")})
public class NotificacoesMBean implements MessageListener {

    private static final Logger log = Logger.getLogger(NotificacoesMBean.class.getName());

    @EJB
    private NotificacoesController notificacoesController;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            notificacoesController.salvaNotificacao(textMessage.getText());
        } catch (JMSException e) {
            log.log(Level.WARNING, "Problema ao salvar notificação");
        }
    }

}
