package br.edu.ifpb.dac.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("clienteMB")
@SessionScoped
public class ClienteMB implements Serializable {

    private  static  final long serialVerstionUID = 1L;

    private String tipoPessoa = "ALUNO";


    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
