/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.AccesoADAO;
import DTO.AlumnoDTO;
import Genericos.Conexion;
import Genericos.Mierror;
import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ManuXpy
 */
public class AccesoADAOIMPL implements AccesoADAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;

    @Override
    public boolean verificarUsuario(AlumnoDTO alumnoDTO) throws Mierror {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT ci_alumno, fecha_nac_alumno FROM t_alumnos where ci_alumno=? AND fecha_nac_alumno=?::date";
            //System.out.println(sintaxiSql);
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, alumnoDTO.getCi_alumno());
            preparedStatement.setObject(2, alumnoDTO.getFecha_nac_alumno());

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

    @Override
    public String getAlumno(Integer idFiltro) throws Mierror {
        ResultSet rs;
        ArrayList<AlumnoDTO> alumno = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT nombres_alumno, ci_alumno FROM t_alumnos where  ci_alumno=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                alumno.add(new AlumnoDTO(rs.getInt("ci_alumno"),
                        rs.getString("nombres_alumno")));
            } else {
                return null;
            }
            conexion.desConectarBD();
        } catch (SQLException ex) {
            MsmError = "MI mensaje propio";
            throw new Mierror(MsmError, ex);
        }
        return new Gson().toJson(alumno);
    }

}
