package br.com.guilherme.forum.repository;

import br.com.guilherme.forum.model.Curso;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    public void deveRetornarONomeDoCurso(){

        Curso curso = new Curso();
        curso.setNome("Spring Boot");
        curso.setCategoria("Programação");
        em.persist(curso);

        String nomeCurso = "Spring Boot";
        Curso cursoSpring = cursoRepository.findByNome(nomeCurso);
        Assert.assertNotNull(cursoSpring);
        Assert.assertEquals(nomeCurso, cursoSpring.getNome());
    }

    @Test
    public void deveRetornarNull(){
        String nomeCurso = "Java";
        Curso curso = cursoRepository.findByNome(nomeCurso);
        Assert.assertNull(curso);
    }
}
