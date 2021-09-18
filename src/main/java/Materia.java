public class Materia {

    private Conteudo conteudo;
    private Funcionario funcionario;

    public Materia(Conteudo conteudo){
        if (conteudo == null) {
            throw new NullPointerException("Conteudo obrigatorio");
        }
        this.conteudo = conteudo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;

    }

    public String getNomeFuncionario() {
        if (funcionario == null) {
            return "Materia sem Funcionario";
        }
        return funcionario.getNome();
    }

    public Conteudo getConteudo() {

        return conteudo;
    }

    public String getDescricaoConteudo() {
        return this.conteudo.getDescricao();
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

}