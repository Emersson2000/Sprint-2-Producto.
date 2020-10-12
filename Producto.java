package Consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Producto {
    
    private String nombreP;
    private double precioP;
    private int cantidadP;
    private int idCategoriaP;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public Producto(String nombreP, double precioP, int cantidadP, int idCategoriaP) {
        this.nombreP = nombreP;
        this.precioP = precioP;
        this.cantidadP = cantidadP;
        this.idCategoriaP = idCategoriaP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public double getPrecioP() {
        return precioP;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public int getIdCategoriaP() {
        return idCategoriaP;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void  mostrarProductos(Connection con) {
        Connection Connection = null;
        try {
            String SQL = "SELECT * FROM producto";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println("--PRODUCTOS--");

            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
                System.out.println("");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setInsertarProducto(Connection con) {
        try {

            PreparedStatement insertar = con.prepareStatement("INSERT INTO producto(nombre, precio, cantidad, idCategoria) VALUES (?, ?, ?, ?)");

            insertar.setString(1, nombreP);
            insertar.setDouble(2, precioP);
            insertar.setInt(3, cantidadP);
            insertar.setInt(4, idCategoriaP);
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    
    
    
    
 
