package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;
import br.edu.ifpb.dac.ejb.services.impl.PeriodoService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RequestScoped
@Named
public class PeriodoController implements Serializable {

    private Periodo periodo;

    private String dataIni;

    private String dataFim;

    private String periodoLetivo;

    @Inject
    private PeriodoService periodoService;

    public List<Periodo> buscarTodosOsPeriodos(){
        return periodoService.buscarTodos();
    }

    public String salvar(){
        this.periodo = new Periodo();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dIni = format.parse(dataIni);
            Date dFim = format.parse(dataFim);
            periodo.setDataInicio(dIni);
            periodo.setDataFim(dFim);
            periodo.setPeriodoLetivo(periodoLetivo);
            if(periodoService.definirPeriodo(periodo)){
                return "/restricted/indexadmin?faces-redirect=true";
            }else{
                FacesMessage facesMessage = new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        "Data definida inválida!",
                        "Detalhe");
                FacesContext.getCurrentInstance().addMessage("msg", facesMessage);
                return null;
            }
        } catch (ParseException e) {
            FacesMessage facesMessage = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Algum campo foi preenchido de forma inválida!",
                    "Detalhe");
            FacesContext.getCurrentInstance().addMessage("msg", facesMessage);
            return null;
        }
    }

    public String goToDefinirPeriodo(){
        return "/restricted/definirPeriodoAdmin?faces-redirect=true";
    }

    /*
    public String remover(Periodo periodo){
        this.periodoDAO.remover(periodo);
        return null;
    }
     */

    public String atualizar(Periodo periodo){
        this.periodoService.atualizar(periodo);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarPeriodo(Long id){
        this.periodoService.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
