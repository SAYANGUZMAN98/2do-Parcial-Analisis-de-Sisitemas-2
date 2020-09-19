/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.ConsultaDAO;
import DTO.V_CalificacionesDTO;
import Genericos.Conexion;
import com.google.gson.Gson;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author !mX
 */
public class ConsultaDAOIMPL implements ConsultaDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;
    private int filasAfectadas;

    @Override
    public String CarrerasFiltroCI(Integer idFiltro) {
        ResultSet rs;
        ArrayList<V_CalificacionesDTO> allcarreras = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT distinct ci_alumno , id_carrera, nombre_carrera FROM public.v_calificaciones WHERE ci_alumno=?::varchar";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allcarreras.add(new V_CalificacionesDTO(rs.getString("ci_alumno"),
                        rs.getInt("id_carrera"),
                        rs.getString("nombre_carrera")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(allcarreras);
    }

}
