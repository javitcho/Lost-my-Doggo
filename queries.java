package com.progra.grupo.lostmydoggo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//contiene los métodos para realizar queries UPDATE INSERT SELECT y DELETE
public class queries {
    
    static final String bd="jdbc:mysql://216.105.171.83:3306/2005003246";
    static final String usuario="2005003246";
    static final String contraseña="EV1nt3rn@";
    //EV1nt3rn@
    
    //Método agregar
    //parámetros: @campos, @tabla, @valores
    //@campos indica los campos que se van a insertar
    //@tabla indica la tabla a la que se van a insertar los valores
    //@valores indica los valores que se le van a asignar a los campos determinados
    //la función agregar agrega un registro nuevo a una tabla en la base de datos. Utiliza un query INSERT.
    public static void agregar(String campos, String tabla, String valores) {

        Statement stQuery;
        ResultSet rsRecords;

        ConeccionBD BD = null;
        try {
            BD = new ConeccionBD(bd, usuario, contraseña);
            BD.getNewConnection();

            String queryInsert = "INSERT INTO " + tabla + " (" + campos + ")  VALUES (" + valores + ") ";
            try {
                stQuery = BD.getCurrentConnection().createStatement();
                stQuery.executeUpdate(queryInsert);
                BD.closeConnection();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e0) {
            e0.printStackTrace();
        }
        BD.closeConnection();
    }

    //Método modificar
    //parámetros: @tabla, @condicion
    //@tabla indica la tabla en donde se van a modificar los datos
    //@condicion indica la coincidencia para modificar los registros, por ejemplo ISBN = 001
    //función modificar modifica la fecha y hora de devolución en las tablas alquileralumnos o alquilermaestros. 
    //Utiliza un UPDATE, con la tabla de parámetro; pone la fecha de devolución como la actual NOW() en la condición 
    //WHERE pala actualizar solamente el registro seleccionado.
    public static void modificar(String tabla, String condicion, String campo) {

        Statement stQuery;
        ResultSet rsRecords;

        ConeccionBD BD = null;
        try {
            BD = new ConeccionBD(bd, usuario, contraseña);
            BD.getNewConnection();

            String queryUpdate = "UPDATE " + tabla + " SET "+ campo +" = NOW() WHERE " + condicion;
            try {
                stQuery = BD.getCurrentConnection().createStatement();
                stQuery.executeUpdate(queryUpdate);
                BD.closeConnection();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e0) {
            e0.printStackTrace();
        }
    }

    //método eliminar
    //parámetros: @tabla, @where
    //@tabla indica la tabla en la que se va a eliminar el registro
    //@where indica la condicion para la que se elimina el registro. Por ejemplo: WHERE carnet = 2005000000
    //funcion eliminar elimina el registro seleccionado en una tabla. Utiliza un DELETE.
    public static void eliminar(String tabla, String where) {

        Statement stQuery;
        ResultSet rsRecords;

        ConeccionBD BD = null;
        try {
            BD = new ConeccionBD(bd, usuario, contraseña);
            BD.getNewConnection();

            String queryUpdate = "DELETE FROM " + tabla + " WHERE " + where + " ";

            try {
                stQuery = BD.getCurrentConnection().createStatement();
                stQuery.executeUpdate(queryUpdate);
                BD.closeConnection();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e0) {
            e0.printStackTrace();
        }

    }

    //ResultSet consultar
    //parámetros: @campos, @tabla, @condicion
    //@campos indica los campos que se quieren consultar
    //@tabla indica la tabla a la que se va a acceder
    //@condicion indica la condicion o WHERE del query. Por ejemplo: WHERE nombre = juan perez
    //salida: ResultSet @consultar del query SELECT que se ha realizado
    //La funcion devuelve un ResultSet de un query SELECT que se corre según los parámetros.
    public static ResultSet consultar(String campos, String tabla, String condicion) {

        Statement stQuery;
        ResultSet rsRecords = null;

        ConeccionBD BD = null;
        try {
            BD = new ConeccionBD(bd, usuario, contraseña);
            BD.getNewConnection();

            String query = "SELECT " + campos + " FROM " + tabla + " WHERE " + condicion;
            try {
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery(query);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e0) {
            e0.printStackTrace();
        }
        return rsRecords;
    }
}
