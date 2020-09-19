/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.PuntajesDAO;
import DTO.AlumnoDTO;
import DTO.AnhoDTO;
import DTO.CarrerasDTO;
import DTO.MateriasDTO;
import DTO.PuntajesDTO;
import DTO.UsuariosDTO;
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
public class PuntajesDAOIMPL implements PuntajesDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;
    private int filasAfectadas;

    @Override
    public boolean insertar(PuntajesDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "INSERT INTO public.t_puntajes(t_asignatura_id_asignatura, t_alumnos_id_alumno, id_puntajes, t_anho_id_anho, puntaje_tp, puntaje_ep, puntaje_ef, puntaje_total, id_usuario)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getT_asignatura_id_asignatura());
            preparedStatement.setObject(2, dto.getT_alumnos_id_alumno());
            preparedStatement.setObject(3, dto.getId_puntajes());
            preparedStatement.setObject(4, dto.getT_anho_id_anho());
            preparedStatement.setObject(5, dto.getPuntaje_tp());
            preparedStatement.setObject(6, dto.getPuntaje_ep());
            preparedStatement.setObject(7, dto.getPuntaje_ef());
            preparedStatement.setObject(8, dto.getPuntaje_total());
            preparedStatement.setObject(9, dto.getId_usuario());

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
    public boolean modificar(PuntajesDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "UPDATE public.t_puntajes SET t_asignatura_id_asignatura=?, t_alumnos_id_alumno=?, t_anho_id_anho=?, puntaje_tp=?, puntaje_ep=?, puntaje_ef=?, puntaje_total=?, id_usuario=? \n"
                    + "WHERE id_puntajes=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getT_asignatura_id_asignatura());
            preparedStatement.setObject(2, dto.getT_alumnos_id_alumno());
            preparedStatement.setObject(3, dto.getT_anho_id_anho());
            preparedStatement.setObject(4, dto.getPuntaje_tp());
            preparedStatement.setObject(5, dto.getPuntaje_ep());
            preparedStatement.setObject(6, dto.getPuntaje_ef());
            preparedStatement.setObject(7, dto.getPuntaje_total());
            preparedStatement.setObject(8, dto.getId_usuario());
            preparedStatement.setObject(9, dto.getId_puntajes());

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
            sintaxiSql = "DELETE FROM public.t_puntajes WHERE id_puntajes=?;";
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
        ArrayList<PuntajesDTO> allPuntajes = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT t_asignatura_id_asignatura, t_alumnos_id_alumno, id_puntajes FROM public.t_puntajes ORDER BY id_puntajes;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allPuntajes.add(new PuntajesDTO(rs.getInt("t_asignatura_id_asignatura"),
                        rs.getInt("t_alumnos_id_alumno"),
                        rs.getInt("id_puntajes")));

            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(allPuntajes);
    }

    @Override
    public String allFiltroSeleccion(Integer idFiltro) {
        ResultSet rs;
        ArrayList<V_CalificacionesDTO> puntajes = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_puntajes, id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, \n"
                    + "       ci_alumno, id_carrera, id_asignatura, t_anho_id_anho, puntaje_tp, puntaje_ep, puntaje_ef\n"
                    + "  FROM public.v_calificaciones WHERE id_puntajes=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                puntajes.add(new V_CalificacionesDTO(rs.getInt("id_puntajes"),
                        rs.getInt("id_alumno"),
                        rs.getInt("cod_alumno"),
                        rs.getString("nombres_alumno"),
                        rs.getString("apellidos_alumno"),
                        rs.getString("ci_alumno"),
                        rs.getInt("id_carrera"),
                        rs.getInt("id_asignatura"),
                        rs.getInt("t_anho_id_anho"),
                        rs.getInt("puntaje_tp"),
                        rs.getInt("puntaje_ep"),
                        rs.getInt("puntaje_ef")));

            } else {
                return null;
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(puntajes);
    }

    @Override
    public String FiltroID(Integer idFiltro) {
        ResultSet rs;
        ArrayList<AlumnoDTO> puntajes = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno FROM public.t_alumnos WHERE cod_alumno=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                puntajes.add(new AlumnoDTO(rs.getInt("id_alumno"),
                        rs.getInt("cod_alumno"),
                        rs.getString("nombres_alumno"),
                        rs.getString("apellidos_alumno"),
                        rs.getString("ci_alumno")));

            } else {
                return null;
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(puntajes);
    }

    @Override
    public Integer getUltimoCodigo() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_puntajes),0 )+ 1 as codigo  FROM t_puntajes;";
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

    @Override
    public String ComboMaterias() {
        ResultSet rs;
        ArrayList<MateriasDTO> ComboMaterias = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_asignatura, nombre_asignatura, id_carrera FROM public.v_materias";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ComboMaterias.add(new MateriasDTO(rs.getInt("id_asignatura"),
                        rs.getString("nombre_asignatura")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(ComboMaterias);
    }

    @Override
    public String ComboAno() {
        ResultSet rs;
        ArrayList<AnhoDTO> ComboAnhos = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_anho, descrip_anho FROM public.t_anho ORDER BY id_anho;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ComboAnhos.add(new AnhoDTO(rs.getInt("id_anho"),
                        rs.getString("descrip_anho")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(ComboAnhos);
    }

    @Override
    public String ComboUsuario() {
        ResultSet rs;
        ArrayList<UsuariosDTO> ComboUsuario = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_usuario, usuario FROM public.t_usuarios ORDER BY id_usuario;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ComboUsuario.add(new UsuariosDTO(rs.getInt("id_usuario"),
                        rs.getString("usuario")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(ComboUsuario);
    }

}
