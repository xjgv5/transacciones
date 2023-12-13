package com.xjgv.javaJDBC;

import com.xjgv.javaJDBC.modelo.Categoria;
import com.xjgv.javaJDBC.modelo.Producto;
import com.xjgv.javaJDBC.repositorio.ProductoRepositorioImpl;
import com.xjgv.javaJDBC.repositorio.Repositorio;
import com.xjgv.javaJDBC.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {

        try(Connection conection = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("********************** Listar **********************");
            repositorio.listar().forEach(System.out::println);


            System.out.println("********************** Obtener por ID **********************");
            System.out.println(repositorio.porId(1L));

            System.out.println("********************** Crear objeto ID **********************");
            Producto producto = new Producto();
            //producto.setId(5L);
            producto.setNombre("Teclado Red Dragon mecanico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            //repositorio.guardar(producto);

            repositorio.listar().forEach(System.out::println);
            
        } catch (SQLException e) {
            e.getMessage();
        }

    }
}
