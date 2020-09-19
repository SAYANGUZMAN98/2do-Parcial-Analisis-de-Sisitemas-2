/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.MateriasDAO;
import DTO.CarrerasDTO;
import DTO.MateriasDTO;
import DTO.V_materiasDTO;
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
public class MateriasDAOIMPL implements MateriasDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;
    private int filasAfectadas;

    @Override
    public boolean insertar(MateriasDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "INSERT INTO public.t_asignatura(id_asignatura, nombre_asignatura, t_carreras_id_carrera) VALUES (?, ?, ?);";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getId_asignatura());
            preparedStatement.setObject(2, dto.getNombre_asignatura());
            preparedStatement.setObject(3, dto.getT_carreras_id_carrera());

            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el insert se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el insert tuvo un fallo");
                return false;

            }

        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;
        }

    }

    @Override
    public boolean modificar(MateriasDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "UPDATE public.t_asignatura SET id_asignatura=?, nombre_asignatura=?, t_carreras_id_carrera=? WHERE id_asignatura=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getId_asignatura());
            preparedStatement.setObject(2, dto.getNombre_asignatura());
            preparedStatement.setObject(3, dto.getT_carreras_id_carrera());
            preparedStatement.setObject(4, dto.getId_asignatura());
            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el UPDATE se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el UPDATE tuvo un fallo");
                return false;
            }

        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;

        }
    }

    @Override
    public boolean eliminar(Integer idDto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "DELETE FROM public.t_asignatura WHERE id_asignatura=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, idDto);
            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el Delete se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el Delete tuvo un fallo");
                return false;
            }

        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;

        }
    }

    @Override
    public String allSeleccion() {
        ResultSet rs;
        ArrayList<V_materiasDTO> Allmaterias = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_asignatura, nombre_asignatura, nombre_carrera, id_carrera  FROM public.v_materias ORDER BY id_carrera;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Allmaterias.add(new V_materiasDTO(rs.getInt("id_asignatura"),
                        rs.getString("nombre_asignatura"),
                        rs.getString("nombre_carrera"),
                        rs.getInt("id_carrera")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(Allmaterias);
    }

    @Override
    public String allFiltroSeleccion(Integer idFiltro) {
        ResultSet rs;
        ArrayList<MateriasDTO> materias = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_asignatura, nombre_asignatura, t_carreras_id_carrera FROM public.t_asignatura WHERE id_asignatura=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                materias.add(new MateriasDTO(rs.getInt("id_asignatura"),
                        rs.getString("nombre_asignatura"),
                        rs.getInt("t_carreras_id_carrera")));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(materias);
    }

    @Override
    public Integer getUltimoCodigo() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_asignatura),0 )+ 1 as codigo  FROM t_asignatura;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return 0;
    }

    @Override
    public String ComboCarreras() {
        ResultSet rs;
        ArrayList<CarrerasDTO> ComboCarreras = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_carrera, nombre_carrera FROM public.t_carreras ORDER BY id_carrera;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ComboCarreras.add(new CarrerasDTO(rs.getInt("id_carrera"),
                        rs.getString("nombre_carrera")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(ComboCarreras);
    }

}
