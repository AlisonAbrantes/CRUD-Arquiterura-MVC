package modelo;

/**
 *
 * @author Alsion
 */
public class Produto extends Objeto {
    
    private String descricao;
    private int quantidade;
    private Situacao situacao;
    private Tipo tipo;
    private Departamento departamento;

    

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Produto(String descricao, int quantidade, Situacao situacao, int id) {
        super(id);
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }

    public Produto(String descricao, int quantidade, Situacao situacao) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }
    
    public Produto(String descricao, int quantidade,Situacao situacao, Tipo tipo, Departamento departamento) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao= situacao;
        this.tipo = tipo;
        this.departamento = departamento;
    }   
    public Produto() {
    }
    
    
}
