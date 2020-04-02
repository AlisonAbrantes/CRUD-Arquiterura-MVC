/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.produto.*;
import command.ICommand;
import dao.departamento.DepartamentoDao;
import dao.produto.ProdutoDao;
import dao.situacao.SituacaoDao;
import dao.tipo.TipoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Departamento;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;


/**
 *
 * @author alunocmc
 */
public class CadastrarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

       //Carrega a comb de situacao na sessao.
           try {
               Situacao situacao = new Situacao();
               SituacaoDao situacaodao = new SituacaoDao();
               
               ArrayList<Situacao> arrsituacao = new ArrayList<>();
               situacao.setDescricao(""); //desta forma virão todos os registros
               arrsituacao = situacaodao.listar(situacao);
               
               HttpSession session = request.getSession();
               session.setAttribute("arrsituacao", arrsituacao);
           } catch (Exception ex) {
               //nada a fazer
           }   
            // Carrega Departamento na sessao.
            try{
             Departamento depto = new Departamento();
             DepartamentoDao deptoDao =new DepartamentoDao();

             ArrayList<Departamento> arrdepto = new ArrayList<>();
             depto.setDescricao("");
            
             arrdepto = deptoDao.listar(depto);
            
             HttpSession session = request.getSession();
             session.setAttribute("arrdepto", arrdepto);
             
             
             
             }catch (Exception ex){
            
            }
            
        try {
            Produto produto = new Produto();
            produto.setDescricao(request.getParameter("txtdescricao"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
            
            Situacao situacao = new Situacao(); // Precisamos criar um objeto situacao que será agregado ao produto
            situacao.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
            
             produto.setSituacao(situacao);//aqui acontece a agregação
             
            Departamento depto = new Departamento();
            depto.setId(Integer.parseInt(request.getParameter("cmbdepartamento")));
            produto.setDepartamento(depto);
            
           

            if (produto.getDescricao().length() == 0) {
                return "/cadastros/produto/cadastrar_produto.jsp";
            } else {
                
            
            /** Carrega a comb tipo na sessao. 
            try{
                Tipo tipo = new Tipo();
                TipoDao tipoDao =new TipoDao();

                ArrayList<Tipo> arrtipo = new ArrayList<>();
                tipo.setDescricao("");

                arrtipo = tipoDao.listar(tipo);

                HttpSession session = request.getSession();
                session.setAttribute("arrtipo", arrtipo);
                
               tipo.setId(Integer.parseInt(request.getParameter("cmbtipo"))); 
               produto.setTipo(tipo);

            }catch (Exception ex){
                
            }**/
                ProdutoDao produtodao = new ProdutoDao();
                produtodao.cadastrar(produto);

                return "/cadastros/produto/sucesso.jsp";
            }
        } catch (Exception ex) {
            return "/cadastros/produto/cadastrar_produto.jsp";

        }

    }

}
