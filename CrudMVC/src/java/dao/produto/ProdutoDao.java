/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;


import conexao.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;

/**
 *
 * @author profe
 */
public class ProdutoDao implements IProdutodao {

    private static final String SELECT_ALL = "SELECT * FROM produto where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO produto(descricao) values(?);";
    private static final String DELETE = "DELETE FROM produto where id=?";
    private static final String BUSCAR = "SELECT * FROM produto WHERE id=?;";
    private static final String UPDATE = "UPDATE produto set descricao=? WHERE id=?";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Produto> listar(Produto produto) {

        //cria uma array de obJ Produto
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            
            pstmt.setString(1, "%" + produto.getDescricao() + "%");
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                Produto novoProduto = new Produto();
                novoProduto.setId(rs.getInt("id"));
                novoProduto.setDescricao(rs.getString("descricao"));

                //add na lista
                listaProduto.add(novoProduto);
            }
            return listaProduto;

        } catch (Exception ex) {
            
            return listaProduto;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void buscar(Produto produto) {

        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, produto.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            produto.setDescricao(rs.getString("descricao"));
         

        } catch (Exception e) {

            //
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean alterar(Produto produto) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }

    @Override
    public boolean excluir(Produto produto) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, produto.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        
    }

    @Override
    public boolean cadastrar(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, produto.getDescricao());

            pstmt.execute();
            
            return true;

        } catch (Exception ex) {

            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
