package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.AvaliacaoDao;
import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
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

    public void salvar(Avaliacao avaliacao){

    }

}
