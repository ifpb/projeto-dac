package br.edu.ifpb.dac.ejb;

import static org.junit.Assert.assertTrue;

import br.edu.ifpb.dac.ejb.dao.AlunoDao;
import br.edu.ifpb.dac.ejb.dao.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Professor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import org.junit.Test;

import javax.inject.Inject;

/**
 * Unit test for simple App.
 */
@RunWith(Arquillian.class)
public class AppTest {

	@Test
	public void test() {
		assertTrue(1==1);
	}

	@Inject
	AlunoDao prfessorDAO;

	@Inject
	ProfessorDao ProfessorDAO;

	@Deployment
	public static JavaArchive criarArquivoTeste() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(AlunoDao.class.getPackage())
				.addPackage(Aluno.class.getPackage())
				.addAsResource("META-INF/persistence.xml");
	}

	@Test
	@InSequence(1)
	public void testeSalvarAluno() {

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Antônio Alves");
		aluno1.setMatricula("201612050570");
		aluno1.setEmail("antonio@gmail.com");
		aluno1.setCurso("ADS");
		aluno1.setSenha("123");

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Jhonatan Leite");
		aluno2.setMatricula("201612040430");
		aluno2.setEmail("jhonatan@gmail.com");
		aluno2.setCurso("ADS");
		aluno2.setSenha("123");


		Aluno aluno3 = new Aluno();
		aluno3.setNome("Santiago Henrique");
		aluno3.setMatricula("201612070760");
		aluno3.setEmail("santiago@gmail.com");
		aluno3.setCurso("ADS");
		aluno3.setSenha("123");

		prfessorDAO.salvar(aluno1);
		prfessorDAO.salvar(aluno2);
		prfessorDAO.salvar(aluno3);

	}
}