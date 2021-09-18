import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Cliente> clientes;
    private Materia materia;

    public Grupo(Materia materia){
        if (materia == null) {
            throw new NullPointerException("Materia brigatorio");
        }
        this.materia = materia;
        this.clientes = new ArrayList<Cliente>();
    }

    public Materia getMateria() {

        return materia;
    }

    public void setMateria(Materia materia) {

        this.materia = materia;
    }

    public int getNumeroClientes() {

        return this.clientes.size();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);}

    public void removerClientes(Cliente cliente) {

        this.clientes.remove(cliente);
    }

    public boolean verificarCliente(Cliente cliente) {

        return this.clientes.contains(cliente);
    }

    public List getNomesClientes() {
        if (this.clientes.size() == 0) {
            throw new NullPointerException("Grupo sem Clientes");
        }
        List<String> nomes = new ArrayList<String>();
        for (Cliente cliente : this.clientes) {
            nomes.add(cliente.getNome());
        }
        return nomes;
    }
}