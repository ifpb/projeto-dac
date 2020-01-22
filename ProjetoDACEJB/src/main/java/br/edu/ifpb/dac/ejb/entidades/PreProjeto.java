package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PreProjeto {

    @Id
    @GeneratedValue
    private long id;

    private String arquivo;

    @Temporal(TemporalType.DATE)
    private Date dataEnvio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
