package br.edu.ifpb.dac.web;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("acaoMB")
@ViewScoped
public class AcaoMB implements Serializable {

    private String acao = "CADASTRO";

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
