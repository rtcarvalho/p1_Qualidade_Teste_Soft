import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConteudoTest {

    @Test
    public void deveMudarDescricaoConteudo() {
        Conteudo conteudo = new Conteudo();

        conteudo.setDescricao("Materia relacionada a Hacking");
        assertEquals("Materia relacionada a Hacking", conteudo.getDescricao());
    }

}