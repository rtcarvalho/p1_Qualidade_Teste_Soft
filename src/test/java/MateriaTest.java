import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class MateriaTest {

    @Test
    public void deveIntanciarMateria(){
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");

        Materia materia = new Materia(conteudo);
        assertEquals(conteudo, materia.getConteudo());
    }

    @Test
    public void deveRetornarExcecaoConteudoNulo(){
        try {
            Materia materia = new Materia(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Materia obrigatoria!", e.getMessage());
        }
    }

    @Test
    public void deveRetornarDescricaoConteudoMateria() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");

        Materia materia = new Materia(conteudo);

        assertEquals("Materia relacionada a Hacking", materia.getDescricaoConteudo());
    }

    @Test
    public void deveRetornarFuncionario() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");

        Funcionario funcionario = new Funcionario("Raphael");

        Materia materia = new Materia(conteudo);
        materia.setMateria(materia);

        assertEquals(funcionario, materia.getFuncionario());
    }

    @Test
    public void deveRetornarNomeFuncionario() {

        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");

        Funcionario funcionario = new Funcionario("Raphael");

        Materia materia = new Materia(conteudo);
        materia.setFuncionario(funcionario);

        assertEquals("Raphael", materia.getNomeFuncionario());
    }

    @Test
    public void deveRetornarMateriaSemFuncionario() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");

        Materia materia = new Materia(conteudo);

        assertEquals("Materia sem funcionario", materia.getNomeFuncionario());
    }

    @Test
    public void deveRetornarNomeFuncionarioMock() {
        Conteudo conteudo = new Conteudo();

        Funcionario funcionario = createMock(Funcionario.class);
        expect(funcionario.getNome()).andReturn("Raphael");
        replay(funcionario);

        Materia materia = new Materia(conteudo);
        materia.setFuncionario(funcionario);

        assertEquals("Raphael", materia.getNomeFuncionario());
    }

    @Test
    public void deveRetornarDescricaoConteudoMateriaMock() {
        Conteudo conteudo = createMock(Conteudo.class);
        expect(conteudo.getDescricao()).andReturn("Materia relacionada a Hacking");
        replay(conteudo);

        Materia materia = new Materia(conteudo);

        assertEquals("Materia relacionada a Hacking", materia.getDescricaoConteudo());
    }

}