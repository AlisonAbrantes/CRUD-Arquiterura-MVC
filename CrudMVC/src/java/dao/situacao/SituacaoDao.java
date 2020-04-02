/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.situacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Situacao;
import conexao.ConectaBanco;
/**
 *
 * @author profe
 */
public class SituacaoDao implements ISituacaoDao {

    private static final String SELECT_ALL = "SELECT * FROM situacao where descricao ilike ?;";
    private static final String BUSCAR = "SELECT * FROM situacao WHERE id=?;";

    private Object pstmt;
    private Connection conexao = null;
        

    @Override
    public ArrayList<Situacao> listar(Situacao situacao) {

        //cria uma array de obJ Situacao
        ArrayList<Situacao> listaSituacao = new ArrayList<>();

        try {

            //Conexao
            conexao=ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            
            pstmt.setString(1, "%" + situacao.getDescricao() + "%");
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                Situacao novoSituacao = new Situacao();
                novoSituacao.setId(rs.getInt("id"));
                novoSituacao.setDescricao(rs.getString("descricao"));

                //add na lista
                listaSituacao.add(novoSituacao);
            }
            return listaSituacao;

        } catch (Exception ex) {
            
            return listaSituacao;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void buscar(Situacao situacao) {

        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, situacao.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            situacao.setDescricao(rs.getString("descricao"));
         

        } catch (Exception e) {

            //
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
