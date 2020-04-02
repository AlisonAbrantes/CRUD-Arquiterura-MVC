/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import java.util.ArrayList;
import modelo.Objeto;
import modelo.Tipo;

/**
 *
 * @author profe
 */
public interface ITipodao {

    public ArrayList<Tipo> listar(Tipo tipo);

    public void buscar(Tipo tipo);

}
