package br.edu.ifpb.dac.ejb.sessionbeans;

import br.edu.ifpb.dac.ejb.entidades.Notificacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class NotificacoesController {

    @PersistenceContext(unitName = "dac")
    private EntityManager entityManager;

    public void salvaNotificacao(String mensagem) {
        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem(mensagem);
        notificacao.setDataCriacao(new Date());

        entityManager.persist(notificacao);
    }

}
