package modelo;

/**
 *
 * @author Alison
 */
public class Departamento extends Objeto{
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Departamento(String descricao) {
        this.descricao = descricao;
    }

    public Departamento(String descricao, int id) {
        super(id);
        this.descricao = descricao;
    }

    public Departamento() {
    }
    
}
