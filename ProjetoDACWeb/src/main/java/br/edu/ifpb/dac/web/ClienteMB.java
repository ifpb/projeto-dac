package br.edu.ifpb.dac.web;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("clienteMB")
@ViewScoped
public class ClienteMB implements Serializable {

    private String tipoPessoa = "ALUNO";

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
