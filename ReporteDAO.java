public package Controlador;

import Clases.Reporte;
import MySQL.BaseDatos;
import java.sql.*;

public class ReporteDAO {

    private static final String INSERTAR_REPORTE = "INSERT INTO reportes (id_empleado, fecha, minutos_atraso) VALUES (?, ?, ?)";
    // Otros SQL según sea necesario

    public static void insertarReporte(Reporte reporte) {
        try ( Connection conexion = BaseDatos.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(INSERTAR_REPORTE)) {
            statement.setInt(1, reporte.getIdEmpleado());
            statement.setDate(2, new java.sql.Date(reporte.getFecha().getTime()));
            statement.setInt(3, reporte.getMinutosAtraso());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void obtenerReportesPorFecha() {

    }
} ReporteDAO {
    
}
