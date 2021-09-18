import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    @Test
    public void deveInstanciarGrupo() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);

        assertEquals(materia, grupo.getMateria());
    }

    @Test
    void deveAdicionarCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);
        Cliente cliente = new Cliente("Raphael");

        grupo.adicionarCliente(cliente);

        assertEquals(1, grupo.getNumeroClientes());
    }

    @Test
    void deveRemoverCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);
        Cliente cliente = new Cliente("Raphael");

        grupo.removerClientes(cliente);

        assertEquals(0, grupo.getNumeroClientes());
    }

    @Test
    void deveVerificarCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);
        Cliente cliente = new Cliente("Raphael");
        grupo.adicionarCliente(cliente);

        assertTrue(grupo.verificarCliente(cliente));
    }

    @Test
    void naoDeveVerificarCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);
        Cliente cliente = new Cliente("Raphael");

        assertFalse(grupo.verificarCliente(cliente));
    }

    @Test
    void deveRetornarNomeClientes() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Materia relacionada a Hacking");
        Materia materia = new Materia(conteudo);
        Grupo grupo = new Grupo(materia);
        Cliente cliente1 = new Cliente("Raphael");
        Cliente cliente2 = new Cliente("Cleber");

        grupo.adicionarCliente(cliente1);
        grupo.adicionarCliente(cliente2);

        assertTrue(grupo.getNomesClientes().contains(cliente1.getNome()));
        assertTrue(grupo.getNomesClientes().contains(cliente2.getNome()));
    }


    @Test
    void deveRetornarExcecaoNomeClientes() {
        try{
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Materia relacionada a Hacking");
            Materia materia = new Materia(conteudo);
            Grupo grupo = new Grupo(materia);
            grupo.getNomesClientes();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Grupo sem clientes", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeClientesMock() {
        Materia materia = createMock(Materia.class);
        Grupo grupo = new Grupo(materia);

        Cliente cliente = createMock(Cliente.class);
        expect(cliente.getNome()).andReturn("Raphael");
        replay(cliente);

        grupo.adicionarCliente(cliente);

        assertTrue(grupo.getNomesClientes().contains("Raphael"));
    }

    @Test
    void deveVerificarClienteMock() {
        Materia materia = createMock(Materia.class);
        replay(materia);

        Grupo grupo = new Grupo(materia);
        Cliente cliente = new Cliente("Raphael");
        grupo.adicionarCliente(cliente);

        assertTrue(grupo.verificarCliente(cliente));
    }

}