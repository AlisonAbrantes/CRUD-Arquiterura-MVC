/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.situacao;

import java.util.ArrayList;
import modelo.Situacao;

/**
 *
 * @author profe
 */
public interface ISituacaoDao {
     public ArrayList<Situacao> listar(Situacao situacao);

    public void buscar(Situacao situacao);
 }
