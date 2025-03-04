package biblioteca;

import java.util.Scanner;

/**
 *
 * @author Blanca
 */
public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private double precio;
    private int cantidad;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISBN, double precio, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo = " + titulo + ", autor = " + autor + ", precio = " + precio + ", cantidad = " + cantidad;
    }

    public void precioIva(double iva) {
        System.out.println("El precio del libro es: " + (this.precio * iva));
    }

    public void precioIvaP(double porcentaje) {
        if (this.precio >= 20) {
            System.out.println("El nuevo precio del libro es: " + (this.precio + (this.precio * (porcentaje / 100))));
            this.precio = this.precio + (this.precio * (porcentaje / 100));
        } else {
            System.out.println("El nuevo precio del libro es: " + (this.precio + ((this.precio * (porcentaje / 100)) / 2)));
            this.precio = this.precio + ((this.precio * (porcentaje / 100)) / 2);
        }
    }

}
