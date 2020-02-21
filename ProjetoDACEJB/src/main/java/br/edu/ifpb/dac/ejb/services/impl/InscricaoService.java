package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class InscricaoService {

    @Inject
    private InscricaoDao inscricaoDao;

    @Inject
    private PeriodoDao periodoDao;

    public boolean validaPeriodo(){
        if(!periodoDao.buscarPorData(new Date()).equals(null)){
            return true;
        }
        return false;
    }


    public void salvar(Inscricao inscricao){
        if (validaPeriodo()){
            inscricaoDao.salvar(inscricao);
        }
    }

    public void atualizar(Inscricao inscricao){
        if (validaPeriodo()){
            inscricaoDao.atualizar(inscricao);
        }
    }

    public List <Inscricao> buscarInscricaoProfessor(Long id){
        return inscricaoDao.listarInscritosProfessor(id);
    }

    public Inscricao buscar(Long id){
        return inscricaoDao.buscar(id);
    }

    public void remover(Inscricao inscricao){
        inscricaoDao.remover(inscricao);
    }

    public List<Inscricao> buscarTodos(){
        return inscricaoDao.buscarTodos();
    }
}
