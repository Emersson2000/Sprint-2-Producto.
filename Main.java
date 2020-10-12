

package Consultas;

import static Consultas.Conexion_BD_Principal.con;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Main {
    
    static Scanner entrada = new Scanner(System.in);
    static Proveedor proveedor;
    static Producto producto;
    static Categoria categoriaC;
    static Cliente cliente;
    
    public static void main(String[] args) {
        Conexion_BD_Principal llamar = new Conexion_BD_Principal();
        llamar.conectar();
        menu();
    }
    
    public static void menu() {
        int opcion, categoria;
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("\t.:MENU:."
                    + "\n*1. Agregar Proveedor"
                    + "\n*2. Agregar Categoria"
                    + "\n*3. Agregar Producto"
                    + "\n*4. Mostrar Proveedores"
                    + "\n*5. Mostrar Categorias"
                    + "\n*6. Mostrar Productos"
                    + "\n*7. Realizar Factura"
                    + "\n*8. Salir"));

//        
            switch (opcion) {
                case 1:
                    System.out.println("");
                    insertarProveedor(con);
                    break;
                case 2:
                    System.out.println("");
                    insertarCategoria(con);
                    break;
                case 3:
                    System.out.println("");
                    insertarProducto(con);
                    break;
                case 4:
                    System.out.println("");
                    proveedor.mostrarProveedor(con);
                    break;
                case 5:
                    System.out.println("");
                    categoriaC.mostrarCategoria(con);
                    break;
                case 6:
                    System.out.println("");
                    producto.mostrarProductos(con);
                    break;
                case 7:
                    System.out.println("");
                    categoriaC.mostrarCategoria(con);
                    System.out.print("Opción: ");
                    categoria = entrada.nextInt();
                    break;
            }
        } while (opcion != 8);
        
    }
    
    public static void insertarProveedor(Connection con) {
        String nombreP, apellidoP, empresaP, numCelularP;
        int idCategoriaP;
        
        nombreP = JOptionPane.showInputDialog("Ingrese el nombre");
        apellidoP = JOptionPane.showInputDialog("Ingese el apellido");
        empresaP = JOptionPane.showInputDialog("Ingrese el nombre de la empresa");
        numCelularP = JOptionPane.showInputDialog("Ingrese el número de celular");
        categoriaC.mostrarCategoria(con);
        do {
            idCategoriaP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria"));
        } while (idCategoriaP < 0 || idCategoriaP > 8);
        proveedor = new Proveedor(nombreP, apellidoP, empresaP, numCelularP, idCategoriaP);
        proveedor.setInsertarProveedor(con);
    }
    
    public static void insertarProducto(Connection con) {
        String nombreP;
        double precioP;
        int cantidadP, idCategoriaP;
        
        nombreP = JOptionPane.showInputDialog("Ingrese el nombre del Producto");
        precioP = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto"));
        cantidadP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del Producto"));
        categoriaC.mostrarCategoria(con);
        do {
            
            idCategoriaP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el la categoria del Producto"));
            
        } while (idCategoriaP < 0 || idCategoriaP > 8);

        producto = new Producto(nombreP, precioP, cantidadP, idCategoriaP);
        producto.setInsertarProducto(con);
        
    }
    
    public static void insertarCategoria(Connection con) {
        String nombreP;
        nombreP = JOptionPane.showInputDialog("Ingrese el nombre de la categoria");
        categoriaC = new Categoria(nombreP);
        categoriaC.setInsertarCategoria(con);
        
    }
}
