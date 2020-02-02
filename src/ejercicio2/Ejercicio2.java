package ejercicio2;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

import static keyboard.Keyboard.*;

public class Ejercicio2 {
    public static void main(String[] args){
        String tableName;

        //Load driver and configure connection with database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Horario", "root", "Libertas11?");
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet name, pKey, fKey = null;

            System.out.println("Escribe el nombre de la tabla: ");
            tableName = readString();

            name = dbmd.getTables(null, "Horario", tableName, null);

            while(name.next()){
                System.out.printf("Nombre: %s%n", name.getString("TABLE_NAME"));

                //Obtenemos la clave primaria
                pKey = dbmd.getPrimaryKeys(null, null, tableName);
                System.out.println("\nClave primaria: ");
                while(pKey.next()){
                    System.out.printf("     %s%n", pKey.getString("COLUMN_NAME"));
                }

                //Obtenemos las claves ajenas
                fKey = dbmd.getImportedKeys(null, null, tableName);
                System.out.println("\nClave ajena: ");
                while(fKey.next()){
                    System.out.printf("     %s%n", fKey.getString("FKCOLUMN_NAME"));
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
