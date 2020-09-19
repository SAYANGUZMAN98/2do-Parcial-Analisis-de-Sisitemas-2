/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.AccesoDAO;
import DTO.AccesoDTO;
import Genericos.Conexion;
import Genericos.Mierror;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ManuXpy
 */
public class AccesoDAOIMPL implements AccesoDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;

    @Override
    public boolean verificarUsuario(AccesoDTO accesoDTO) throws Mierror {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT usuario, pass FROM t_usuarios where usuario=? and pass=?;";

            //System.out.println(sintaxiSql);
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, accesoDTO.getUsuario());
            preparedStatement.setObject(2, accesoDTO.getPass());

            resultado = preparedStatement.executeQuery();
            if (resultado.next()) {

                return true;
            }
            conexion.desConectarBD();
        } catch (SQLException ex) {
            MsmError = "Error Durante la Ejecucion del Siguiente Consulta " + sintaxiSql;
            throw new Mierror(MsmError, ex);
        }
        return false;
    }

}
