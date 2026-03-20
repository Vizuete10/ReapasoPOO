package retoDificil1;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase gestora central del sistema de biblioteca.
 * Contiene todas las colecciones y aplica las reglas de negocio.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class GestorBiblioteca {

    private HashMap<String, Libro>  libros;
    private HashMap<String, Socio>  socios;
    private ArrayList<Prestamo>     prestamos;

    public GestorBiblioteca() {
        libros    = new HashMap<>();
        socios    = new HashMap<>();
        prestamos = new ArrayList<>();
    }

    // ─── LIBROS ──────────────────────────────────────────────────────────────

    /**
     * Da de alta un libro si el ISBN no existe ya.
     * @return true si se añadió correctamente
     */
    public boolean altaLibro(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            System.out.println("ERROR: Ya existe un libro con el ISBN " + libro.getIsbn());
            return false;
        }
        libros.put(libro.getIsbn(), libro);
        System.out.println("Libro añadido correctamente.");
        return true;
    }

    /** Elimina un libro por ISBN. */
    public boolean eliminarLibro(String isbn) {
        if (libros.remove(isbn) != null) {
            System.out.println("Libro eliminado.");
            return true;
        }
        System.out.println("ERROR: Libro no encontrado.");
        return false;
    }

    /** Modifica el título y autor de un libro existente. */
    public boolean modificarLibro(String isbn, String nuevoTitulo, String nuevoAutor) {
        Libro libro = libros.get(isbn);
        if (libro == null) { System.out.println("ERROR: Libro no encontrado."); return false; }
        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        System.out.println("Libro actualizado.");
        return true;
    }

    /** Muestra todos los libros registrados. */
    public void listarLibros() {
        if (libros.isEmpty()) { System.out.println("No hay libros registrados."); return; }
        libros.values().forEach(System.out::println);
    }

    /** Muestra solo los libros con ejemplares disponibles. */
    public void listarLibrosDisponibles() {
        boolean hayAlguno = false;
        for (Libro l : libros.values()) {
            if (l.estaDisponible()) { System.out.println(l); hayAlguno = true; }
        }
        if (!hayAlguno) System.out.println("No hay libros disponibles.");
    }

    /** Muestra la información de un libro concreto. */
    public void mostrarLibro(String isbn) {
        Libro l = libros.get(isbn);
        if (l != null) System.out.println(l);
        else System.out.println("Libro no encontrado.");
    }

    // ─── SOCIOS ──────────────────────────────────────────────────────────────

    /** Da de alta un socio si el ID no existe ya. */
    public boolean altaSocio(Socio socio) {
        if (socios.containsKey(socio.getId())) {
            System.out.println("ERROR: Ya existe un socio con el ID " + socio.getId());
            return false;
        }
        socios.put(socio.getId(), socio);
        System.out.println("Socio registrado correctamente.");
        return true;
    }

    /** Elimina un socio por ID. */
    public boolean eliminarSocio(String id) {
        if (socios.remove(id) != null) { System.out.println("Socio eliminado."); return true; }
        System.out.println("ERROR: Socio no encontrado.");
        return false;
    }

    /** Modifica nombre y email de un socio. */
    public boolean modificarSocio(String id, String nuevoNombre, String nuevoEmail) {
        Socio socio = socios.get(id);
        if (socio == null) { System.out.println("ERROR: Socio no encontrado."); return false; }
        socio.setNombre(nuevoNombre);
        socio.setEmail(nuevoEmail);
        System.out.println("Socio actualizado.");
        return true;
    }

    /** Muestra todos los socios. */
    public void listarSocios() {
        if (socios.isEmpty()) { System.out.println("No hay socios registrados."); return; }
        socios.values().forEach(System.out::println);
    }

    /** Muestra la información de un socio concreto. */
    public void mostrarSocio(String id) {
        Socio s = socios.get(id);
        if (s != null) System.out.println(s);
        else System.out.println("Socio no encontrado.");
    }

    // ─── PRÉSTAMOS ───────────────────────────────────────────────────────────

    /**
     * Registra un préstamo aplicando todas las validaciones del sistema.
     * @return true si el préstamo se realizó correctamente
     */
    public boolean registrarPrestamo(String isbn, String idSocio) {
        Libro libro = libros.get(isbn);
        Socio socio = socios.get(idSocio);

        if (libro == null) { System.out.println("ERROR: Libro no encontrado."); return false; }
        if (socio == null) { System.out.println("ERROR: Socio no encontrado."); return false; }
        if (!libro.estaDisponible()) {
            System.out.println("ERROR: No hay ejemplares disponibles de ese libro.");
            return false;
        }
        if (!socio.puedePrestar()) {
            System.out.println("ERROR: El socio ha alcanzado el límite de préstamos.");
            return false;
        }

        libro.prestar();
        socio.incrementarPrestamos();
        prestamos.add(new Prestamo(socio, libro));
        System.out.println("Préstamo registrado correctamente.");
        return true;
    }

    /**
     * Registra la devolución del libro de un socio concreto.
     */
    public boolean registrarDevolucion(String isbn, String idSocio) {
        for (Prestamo p : prestamos) {
            if (p.estaActivo()
                && p.getLibro().getIsbn().equals(isbn)
                && p.getSocio().getId().equals(idSocio)) {
                p.registrarDevolucion();
                p.getLibro().devolver();
                p.getSocio().decrementarPrestamos();
                System.out.println("Devolución registrada correctamente.");
                return true;
            }
        }
        System.out.println("ERROR: No se encontró un préstamo activo para ese libro y socio.");
        return false;
    }

    /** Muestra todos los préstamos (activos e históricos). */
    public void listarPrestamos() {
        if (prestamos.isEmpty()) { System.out.println("No hay préstamos registrados."); return; }
        prestamos.forEach(System.out::println);
    }

    /** Muestra solo los préstamos activos. */
    public void listarPrestamosActivos() {
        boolean hay = false;
        for (Prestamo p : prestamos) {
            if (p.estaActivo()) { System.out.println(p); hay = true; }
        }
        if (!hay) System.out.println("No hay préstamos activos.");
    }
}