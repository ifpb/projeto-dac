package br.edu.ifpb.dac.ejb;

import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
@RunWith(Arquillian.class)
public class AppTest {

	@Test
	public void test() {
		assertTrue(1==1);
	}

	//	@Inject
//	AlunoDao alunoDao;
//
//	@Inject
//	ProfessorDao professorDao;
//
//	@Inject
//	PreProjetoDao preProjetoDao;
//
//	@Inject
//	PeriodoDao periodoDao;
//
//	@Inject
//	CriterioAvaliacaoDao criterioAvaliacaoDao;
//
//	@Inject
//	TemaDao temaDao;
//
//	@Inject
//	InscricaoDao inscricaoDao;
//
//	@Inject
//	AvaliacaoDao avaliacaoDao;
//
//
//	@PersistenceContext(unitName = "dac")
//	EntityManager em;
//
//	@Deployment
//	public static JavaArchive criarArquivoTeste() {
//		return ShrinkWrap.create(JavaArchive.class)
//				.addPackage(AlunoDao.class.getPackage())
//				.addPackage(Aluno.class.getPackage())
//				.addAsResource("META-INF/persistence.xml");
//	}
//
//
//	@Test
//	public void testeSalvarAluno() {
//		Aluno aluno = new Aluno();
//		aluno.setNome("Tiringa");
//		aluno.setEmail("tiringa@gmail.com");
//		aluno.setMatricula("202022022020");
//		aluno.setSenha("tiringa123");
//		aluno.setCurso(Pessoa.Curso.ADS);
//		alunoDao.salvar(aluno);
//	}
//
//	@Test
//	public void testeSalvarProfesssor() {
//		Professor professor = new Professor();
//		professor.setNome("lopim");
//		professor.setEmail("lopim@gmail.com");
//		professor.setMatricula("12345678");
//		professor.setSenha("lopim123");
//		professor.setCurso(Pessoa.Curso.ADS);
//		professorDao.salvar(professor);
//
//	}
//
//	@Test
//	public void testeSalvarPreProjeto(){
//		PreProjeto preProjeto = new PreProjeto();
//		preProjeto.setArquivo("arquivoPreProjeto");
//		preProjeto.setDataEnvio(new Date());
//		preProjetoDao.salvar(preProjeto);
//	}
//
//	@Test
//	public void testeSalvarPeriodo(){
//		Periodo periodo = new Periodo();
//		periodo.setDataInicio(new Date());
//		periodo.setDataFim(new Date());
//		periodo.setPeriodoLetivo("2020.1");
//		periodoDao.salvar(periodo);
//	}
//
//	@Test
//	public void testeSalvarCriterioAvaliacao(){
//		CriterioAvaliacao criterioAvaliacao = new CriterioAvaliacao();
//		criterioAvaliacao.setCriterio("criterio");
//		criterioAvaliacao.setNota(1.4f);
//		criterioAvaliacaoDao.salvar(criterioAvaliacao);
//
//	}
//
//	@Test
//	public void testeSalvarTema(){
//		Tema tema = new Tema();
//		tema.setTitulo("titulotema");
//		tema.setDescricao("DescricaoTema");
//		tema.setDisponivel(true);
//
//		Professor professor = new Professor();
//		professor.setNome("professorTema");
//		professor.setEmail("professorTema@gmail.com");
//		professor.setMatricula("18294762");
//		professor.setSenha("professorTema123");
//		professor.setCurso(Pessoa.Curso.ENGENHARIA_AUTOMACAO);
//		tema.setProfessor(professor);
//
//		temaDao.salvar(tema);
//
//	}
//
//	@Test
//	public void testeSalvarAvaliacao(){
//		Avaliacao avaliacao = new Avaliacao();
//
//		Professor professor = new Professor();
//		professor.setNome("professorAvaliador");
//		professor.setEmail("professorAvaliador@gmail.com");
//		professor.setMatricula("18294762");
//		professor.setSenha("professorAvaliador123");
//		professor.setCurso(Pessoa.Curso.ADS);
//		avaliacao.setAvaliador(professor);
//
//		avaliacao.setNotaGeral(7.0f);
//
//		CriterioAvaliacao criterioAvaliacao1 = new CriterioAvaliacao();
//		criterioAvaliacao1.setCriterio("criterioAvaliacao");
//		criterioAvaliacao1.setNota(1.8f);
//
//		avaliacao.setCriteriosAvaliacao(Arrays.asList(criterioAvaliacao1));
//
//		avaliacaoDao.salvar(avaliacao);
//
//
//
//
//	}
//
//	@Test
//	public void testeSalvarInscricao(){
//		Inscricao inscricao = new Inscricao();
//
//		Aluno aluno = new Aluno();
//		aluno.setNome("AlunoInscricao");
//		aluno.setEmail("AlunoInscricao@gmail.com");
//		aluno.setMatricula("202022022040");
//		aluno.setSenha("AlunoInscricao123");
//		aluno.setCurso(Pessoa.Curso.ADS);
//
//
//		Professor professor = new Professor();
//		professor.setNome("professorInscricao");
//		professor.setEmail("professorInscricao@gmail.com");
//		professor.setMatricula("02837493");
//		professor.setSenha("professorInscricao123");
//		professor.setCurso(Pessoa.Curso.ADS);
//
//		Tema tema = new Tema();
//		tema.setTitulo("titulotemaInscricao");
//		tema.setDescricao("DescricaotemaInscricao");
//		tema.setDisponivel(true);
//		tema.setProfessor(professor);
//
//
//		inscricao.setDataInscricao(new Date());
//
//		Periodo periodo = new Periodo();
//		periodo.setDataInicio(new Date());
//		periodo.setDataFim(new Date());
//		periodo.setPeriodoLetivo("2020.1");
//
//
//		PreProjeto preProjeto = new PreProjeto();
//		preProjeto.setArquivo("inscricaoPreProjeto");
//		preProjeto.setDataEnvio(new Date());
//
//		inscricao.setNotaFinal(6.0f);
//
//
//		Avaliacao avaliacaoInscricao = new Avaliacao();
//		avaliacaoInscricao.setAvaliador(professor);
//		avaliacaoInscricao.setNotaGeral(7.0f);
//		CriterioAvaliacao criterioAvaliacao1 = new CriterioAvaliacao();
//		criterioAvaliacao1.setCriterio("criterioAvaliacao");
//		criterioAvaliacao1.setNota(1.8f);
//		avaliacaoInscricao.setCriteriosAvaliacao(Arrays.asList(criterioAvaliacao1));
//
//		inscricao.setStatus(Inscricao.Status.CONTEMPLADO);
//
//		inscricaoDao.salvar(inscricao);
//
//	}


}