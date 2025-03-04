package biblioteca;

import java.util.Scanner;

/**
 *
 * @author Blanca
 */
public class obj_libro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Libro[] libros = new Libro[10];
        String[] nuevalib = {"libro1;autor1;libro1;8;2",
            "libro2;autor2;libro2;10;5",
            "libro3;autor3;libro3;15;3"};
        generarejemplos(libros);
        int opcion = 0;
        while (opcion != 10) {
            opcion = menu(in1);
            if (opcion == 1) {
                llenar(libros, in, in1);
            } else if (opcion == 2) {
                eliminar(libros, in);
            } else if (opcion == 3) {
                mostrar(libros);
            } else if (opcion == 4) {
                editar(libros, in, in1);
            } else if (opcion == 5) {
                precioIvaS(libros, in);
            } else if (opcion == 6) {
                double iva = 1.21;
                Libro libro = obtener_obj(libros, in);
                libro.precioIva(iva);
            } else if (opcion == 7) {
                precioIvaSP(libros, in, in1);
            } else if (opcion == 8) {
                Libro libro = obtener_obj(libros, in);
                System.out.println("Inrtroduce el porcentaje de subida: ");
                double porcentaje = in1.nextDouble();
                libro.precioIvaP(porcentaje);
            } else if (opcion == 9) {
                guardarArray(libros, in, in, nuevalib);
            } else if (opcion == 10) {
                System.out.println("Se finaliza el programa.");
            } else {
                System.out.println("Elegir opcion correcta.");
            }
        }
    }

    public static void generarejemplos(Libro[] libros) {
        libros[0] = new Libro("hola", "hola", "hola", 25, 1);
        libros[1] = new Libro("hola2", "hola2", "hola2", 2, 2);
        libros[2] = new Libro("hola3", "hola3", "hola3", 3, 3);
        libros[3] = new Libro("hola4", "hola4", "hola4", 4, 4);
        libros[4] = new Libro("hola5", "hola5", "hola5", 5, 5);
    }

    public static int menu(Scanner in1) {
        System.out.println("Seleccione las sgtes opciones: ");
        System.out.println("1. Añadir libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Mostrar libros");
        System.out.println("4. Editar libros");
        System.out.println("5. Mostrar precio con iva static");
        System.out.println("6. Mostrar precio con iva no static");
        System.out.println("7. Mostrar precio con iva static con porcentaje");
        System.out.println("8. Mostrar precio con iva no static con porcentaje");
        System.out.println("9. Guardar nuevas adquisiciones");
        System.out.println("10. Salir");
        int opcion = in1.nextInt();
        return opcion;
    }

    public static void llenar(Libro[] libros, Scanner in, Scanner in1) {
        Libro libro1;
        boolean lleno = true;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libro1 = new Libro();
                System.out.println("Introduce el nombre del libro: ");
                libro1.setTitulo(in.nextLine());
                System.out.println("Introduce el autor del libro: ");
                libro1.setAutor(in.nextLine());
                System.out.println("Introduce el ISBN del libro: ");
                libro1.setISBN(in.nextLine());
                System.out.println("Introduce el precio del libro: ");
                libro1.setPrecio(in1.nextDouble());
                System.out.println("Introduce la cantidad del libro: ");
                libro1.setCantidad(in1.nextInt());
                System.out.println("Se ha añadido el libro en la posicion " + i);
                libros[i] = libro1;
                i = libros.length;
                lleno = false;
            } else {
                System.out.println("En la posicion " + i + " ya existe un objeto");
            }
        }
        if (lleno) {
            System.out.println("El array de libros esta lleno, no se ha guardado este libro");
        }
    }

    public static void mostrar(Libro[] libros) {
        double valor_total = 0;
        double valor;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                valor_total += (libros[i].getCantidad() * libros[i].getPrecio());
                valor = (libros[i].getCantidad() * libros[i].getPrecio());
                System.out.println(libros[i].toString() + ", valor total: " + valor + "}");
            }
        }
        System.out.println("El valor total de toda la biblioteca es: " + valor_total);
    }

    public static void eliminar(Libro[] libros, Scanner in) {
        int num_libro = obtener(libros, in);
        if (num_libro >= 0) {
            libros[num_libro] = null;
            System.out.println("Se ha eliminado el libro");
        } else {
            System.out.println("No existe el ISBN");
        }
    }

    public static void editar(Libro[] libros, Scanner in, Scanner in1) {
        //int num_libro = obtener(libros, in);
        Libro edit = obtener_obj(libros, in);
        boolean editar = false;
        int opcion = 0;
        if (edit != null) {
            while (opcion != 5) {
                System.out.println("Indique que requiere editar: ");
                System.out.println("1. Autor");
                System.out.println("2. Titulo");
                System.out.println("3. Precio");
                System.out.println("4. Cantidad");
                System.out.println("5. Salir");
                opcion = in1.nextInt();
                if (opcion == 1) {
                    System.out.println("Introduce el autor del libro: ");
                    edit.setAutor(in.nextLine());
                    editar = true;
                } else if (opcion == 2) {
                    System.out.println("Introduce el nombre del libro: ");
                    //libros[num_libro].setTitulo(in.nextLine());
                    edit.setTitulo(in.nextLine());
                    editar = true;
                } else if (opcion == 3) {
                    System.out.println("Introduce el precio del libro: ");
                    edit.setPrecio(in1.nextDouble());
                    editar = true;
                } else if (opcion == 4) {
                    System.out.println("Introduce la cantidad del libro: ");
                    edit.setCantidad(in1.nextInt());
                    editar = true;
                } else if (opcion == 5) {
                    System.out.println("Se finaliza la edicion.");
                } else {
                    System.out.println("Indique una opcion valida.");
                }
            }
        } else {
            System.out.println("No existe el ISBN.");
        }
        if (editar) {
            System.out.println("Se ha editado el libro");
        }
    }

    public static int obtener(Libro[] libros, Scanner in) {
        int num_libro = 0;
        System.out.println("Indique el ISBN para hacer operacion: ");
        String isbn = in.nextLine();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if (libros[i].getISBN().equals(isbn)) {
                    num_libro = i;
                    i = libros.length;
                }
            } else {
                num_libro = -1;
            }
        }
        return num_libro;
    }

    public static Libro obtener_obj(Libro[] libros, Scanner in) {
        System.out.println("Indique el ISBN para hacer operacion: ");
        String isbn = in.nextLine();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if (libros[i].getISBN().equals(isbn)) {
                    return libros[i];
                }
            }
        }
        return null;
    }

    public static void precioIvaS(Libro[] libros, Scanner in) {
        double iva = 1.21;
        Libro libro = obtener_obj(libros, in);
        System.out.println("El precio del libro es: " + (libro.getPrecio() * iva));
    }

    public static void precioIvaSP(Libro[] libros, Scanner in, Scanner in1) {
        Libro libro = obtener_obj(libros, in);
        System.out.println("Inrtroduce el porcentaje de subida: ");
        double porcentaje = in1.nextDouble();
        if (libro.getPrecio() >= 20) {
            System.out.println("El nuevo precio del libro es: " + (libro.getPrecio() + (libro.getPrecio() * (porcentaje / 100))));
            libro.setPrecio(libro.getPrecio() + (libro.getPrecio() * (porcentaje / 100)));
        } else {
            System.out.println("El nuevo precio del libro es: " + (libro.getPrecio() + ((libro.getPrecio() * (porcentaje / 100)) / 2)));
            libro.setPrecio(libro.getPrecio() + ((libro.getPrecio() * (porcentaje / 100)) / 2));
        }

    }

    public static void guardarArray(Libro[] libros, Scanner in, Scanner in1, String[] nuevalib) {
        Libro libro1;
        boolean lleno;
        for (int i = 0; i < nuevalib.length; i++) {
            String[] libro = nuevalib[i].split(";");
            lleno = true;
            for (int j = 0; j < libros.length; j++) {
                if (libros[j] == null) {
                    libro1 = new Libro();
                    libro1.setTitulo(libro[0]);
                    libro1.setAutor(libro[1]);
                    libro1.setISBN(libro[2]);
                    libro1.setPrecio(Double.parseDouble(libro[3]));
                    libro1.setCantidad(Integer.parseInt(libro[4]));
                    System.out.println("Se ha añadido el libro en la posicion " + j);
                    libros[j] = libro1;
                    j = libros.length;
                    lleno = false;
                }
            }
            if (lleno) {
                System.out.println("El array de libros esta lleno, no se ha guardado este libro");
            }

        }
    }
}
