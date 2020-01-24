package br.edu.ifpb.dac.ejb.sessionbeans;

import br.edu.ifpb.dac.ejb.dao.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;

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
    private PeriodoDao periodoDAO;

    public List<Periodo> buscarTodosOsPeriodos(){
        return periodoDAO.buscarTodos();
    }

    public String salvar(Periodo periodo){
        periodoDAO.salvar(periodo);
        return null;
    }

    /*
    public String remover(Periodo periodo){
        this.periodoDAO.remover(periodo);
        return null;
    }
     */

    public String atualizar(Periodo periodo){
        this.periodoDAO.atualizar(periodo);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarPeriodo(Long id){
        this.periodoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
