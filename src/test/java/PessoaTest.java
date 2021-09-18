import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void deveInstanciarPessoa() {
        Pessoa pessoa = new Pessoa("Raphael");

        assertEquals("Raphael", pessoa.getNome());
    }

    @Test
    void deveRetornarNomeNuloConstrutor() {
        try {
            Pessoa pessoa = new Pessoa(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeVazioConstrutor() {
        try {
            Pessoa pessoa = new Pessoa("");
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveMudarNomePessoa() {
        Pessoa pessoa = new Pessoa("Raphael");
        pessoa.setNome("Torres");

        assertEquals("Torres", pessoa.getNome());
    }

    @Test
    void deveRetornarExecaoMudarNomePessoaNulo() {
        try {
            Pessoa pessoa = new Pessoa("Raphael");
            pessoa.setNome(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExecaoMudarNomePessoaVazio() {
        try {
            Pessoa pessoa = new Pessoa("Raphael");
            pessoa.setNome("");
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

}