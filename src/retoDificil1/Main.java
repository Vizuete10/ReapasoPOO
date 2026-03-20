package retoDificil1;

import java.util.Scanner;

/**
 * Clase principal. Contiene el menú interactivo del sistema de biblioteca.
 */
public class Main {

    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Datos de prueba para no empezar con todo vacío
        gestor.altaLibro(new Libro("978-1", "Clean Code", "Robert Martin", 3));
        gestor.altaLibro(new Libro("978-2", "El Hobbit", "Tolkien", 2));
        gestor.altaSocio(new Socio("S01", "Ana García", "ana@email.com"));
        gestor.altaSocio(new Socio("S02", "Luis López", "luis@email.com"));

        do {
            System.out.println("\n════════ BIBLIOTECA DIGITAL ════════");
            System.out.println("--- LIBROS ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Libros disponibles");
            System.out.println("4. Modificar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("--- SOCIOS ---");
            System.out.println("6. Añadir socio");
            System.out.println("7. Listar socios");
            System.out.println("8. Modificar socio");
            System.out.println("9. Eliminar socio");
            System.out.println("--- PRÉSTAMOS ---");
            System.out.println("10. Registrar préstamo");
            System.out.println("11. Registrar devolución");
            System.out.println("12. Ver todos los préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ISBN: ");        String isbn  = sc.nextLine();
                    System.out.print("Título: ");      String tit   = sc.nextLine();
                    System.out.print("Autor: ");       String aut   = sc.nextLine();
                    System.out.print("Ejemplares: ");  int ej       = sc.nextInt(); sc.nextLine();
                    gestor.altaLibro(new Libro(isbn, tit, aut, ej));
                    break;
                case 2:  gestor.listarLibros(); break;
                case 3:  gestor.listarLibrosDisponibles(); break;
                case 4:
                    System.out.print("ISBN a modificar: ");  String isbnM = sc.nextLine();
                    System.out.print("Nuevo título: ");      String titM  = sc.nextLine();
                    System.out.print("Nuevo autor: ");       String autM  = sc.nextLine();
                    gestor.modificarLibro(isbnM, titM, autM);
                    break;
                case 5:
                    System.out.print("ISBN a eliminar: ");
                    gestor.eliminarLibro(sc.nextLine());
                    break;
                case 6:
                    System.out.print("ID socio: ");    String id   = sc.nextLine();
                    System.out.print("Nombre: ");      String nom  = sc.nextLine();
                    System.out.print("Email: ");       String mail = sc.nextLine();
                    gestor.altaSocio(new Socio(id, nom, mail));
                    break;
                case 7:  gestor.listarSocios(); break;
                case 8:
                    System.out.print("ID a modificar: ");  String idM  = sc.nextLine();
                    System.out.print("Nuevo nombre: ");    String nomM = sc.nextLine();
                    System.out.print("Nuevo email: ");     String maiM = sc.nextLine();
                    gestor.modificarSocio(idM, nomM, maiM);
                    break;
                case 9:
                    System.out.print("ID a eliminar: ");
                    gestor.eliminarSocio(sc.nextLine());
                    break;
                case 10:
                    System.out.print("ISBN del libro: ");  String isbnP = sc.nextLine();
                    System.out.print("ID del socio: ");    String idP   = sc.nextLine();
                    gestor.registrarPrestamo(isbnP, idP);
                    break;
                case 11:
                    System.out.print("ISBN del libro: ");  String isbnD = sc.nextLine();
                    System.out.print("ID del socio: ");    String idD   = sc.nextLine();
                    gestor.registrarDevolucion(isbnD, idD);
                    break;
                case 12: gestor.listarPrestamos(); break;
                case 0:  System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}