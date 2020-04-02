package dao.departamento;

import java.util.ArrayList;
import modelo.Departamento;

/**
 *
 * @author Alison
 */
interface IDepartamentoDao {
     public ArrayList<Departamento> listar(Departamento departamento);
     
     public void buscar(Departamento departamento);

}
