package ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio4 {
    public static void main(String[] args) {
        DbUtils dbUtils = new DbUtils();

        //INSERT PROFESORES
        dbUtils.insertProfesor("DAS", "Daniel", "Ayala Soriano", null);

        //INSERT CURSOS
        dbUtils.insertCurso("FPB", "1A", "DAS");

        //INSERT ASIGNATURAS
        dbUtils.insertAsignatura("OACE",
                "Operaciones auxiliares para la configuración y la explotación",
                7, 245);
        dbUtils.insertAsignatura("MMSC",
                "Montaje y mantenimiento de sistemas y componentes informáticos",
                9, 315);
    }
}
