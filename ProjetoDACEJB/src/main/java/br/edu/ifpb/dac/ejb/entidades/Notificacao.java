package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue
    private Long id;

    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
