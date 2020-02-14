package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Stateless
public class PeriodoService {

    @Inject
    private PeriodoDao periodoDao;

    public boolean definirPeriodo(Periodo periodo){
        if(periodo.getDataInicio().before(new Date()) || periodo.getDataFim().before(new Date())){
            return false;
        }else{
            periodoDao.salvar(periodo);
            return true;
        }
    }

    public List<Periodo> buscarTodos(){
        return periodoDao.buscarTodos();
    }

    public boolean atualizar(Periodo periodo){
        if(periodo.getDataInicio().before(new Date()) || periodo.getDataFim().before(new Date())){
            return false;
        }else{
            periodoDao.atualizar(periodo);
            return true;
        }
    }

    public Periodo buscar(Long id) {
        return periodoDao.buscar(id);
    }
}
