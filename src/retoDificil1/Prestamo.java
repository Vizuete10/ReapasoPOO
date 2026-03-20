package retoDificil1;

import java.time.LocalDate;

/**
 * Representa la relación entre un socio y un libro en un préstamo.
 * Registra las fechas de préstamo y devolución.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class Prestamo {

    private Socio socio;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;  // null = todavía no devuelto

    public Prestamo(Socio socio, Libro libro) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public Socio getSocio() { return socio; }
    public Libro getLibro() { return libro; }

    /**
     * @return true si el préstamo sigue activo (no devuelto)
     */
    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    /**
     * Registra la devolución con la fecha actual.
     */
    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
    }

    @Override
    public String toString() {
        String estado = estaActivo()
            ? "ACTIVO"
            : "Devuelto el " + fechaDevolucion;
        return socio.getNombre() + " → " + libro.getTitulo()
             + " | Prestado: " + fechaPrestamo + " | " + estado;
    }
}