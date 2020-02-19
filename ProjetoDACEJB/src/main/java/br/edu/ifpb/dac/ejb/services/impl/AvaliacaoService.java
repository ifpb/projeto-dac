package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.AvaliacaoDao;
import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class AvaliacaoService {

    @Inject
    private AvaliacaoDao avaliacaoDao;

    @Inject
    private PeriodoDao periodoDao;


    public boolean validaPeriodo(Avaliacao a){

        try{
            if(periodoDao.buscarPorData(a.getInscricao().getDataInscricao()).getDataFim().after(new Date())){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            return false;
        }
    }

    public void salvar(Avaliacao avaliacao){
        if(validaPeriodo(avaliacao)){
            avaliacaoDao.salvar(avaliacao);
        }
    }

    public void atualizar(Avaliacao avaliacao){
        if (validaPeriodo(avaliacao)){
            avaliacaoDao.salvar(avaliacao);
        }
    }

    public void remover(Avaliacao avaliacao){
        if (validaPeriodo(avaliacao)){
            avaliacaoDao.remover(avaliacao);
        }
    }

    public List<Avaliacao> buscarTodos(){
        return avaliacaoDao.buscarTodos();
    }

    public Avaliacao buscarId(Long id){
        return avaliacaoDao.buscar(id);
    }

}
