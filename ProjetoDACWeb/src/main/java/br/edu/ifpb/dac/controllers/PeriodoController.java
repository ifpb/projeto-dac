package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;
import br.edu.ifpb.dac.ejb.services.impl.PeriodoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class PeriodoController implements Serializable {

    private Periodo periodo;

    @Inject
    private PeriodoService periodoService;

    public List<Periodo> buscarTodosOsPeriodos(){
        return periodoService.buscarTodos();
    }

    public String salvar(Periodo periodo){
        periodoService.definirPeriodo(periodo);
        return null;
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
}
