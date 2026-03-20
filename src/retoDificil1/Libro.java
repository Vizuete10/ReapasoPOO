package retoDificil1;

/**
 * Representa un libro en la biblioteca digital.
 * Controla los ejemplares disponibles para préstamo.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int ejemplaresTotal;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int ejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresTotal = ejemplares;
        this.ejemplaresDisponibles = ejemplares;
    }

    // Getters
    public String getIsbn()                  { return isbn; }
    public String getTitulo()                { return titulo; }
    public String getAutor()                 { return autor; }
    public int getEjemplaresDisponibles()    { return ejemplaresDisponibles; }
    public int getEjemplaresTotal()          { return ejemplaresTotal; }

    // Setters
    public void setTitulo(String titulo)     { this.titulo = titulo; }
    public void setAutor(String autor)       { this.autor = autor; }

    /**
     * Indica si hay al menos un ejemplar disponible.
     * @return true si hay ejemplares disponibles
     */
    public boolean estaDisponible() {
        return ejemplaresDisponibles > 0;
    }

    /**
     * Reduce en uno los ejemplares disponibles al prestarse.
     */
    public void prestar() {
        if (estaDisponible()) ejemplaresDisponibles--;
    }

    /**
     * Aumenta en uno los ejemplares disponibles al devolverse.
     */
    public void devolver() {
        if (ejemplaresDisponibles < ejemplaresTotal) ejemplaresDisponibles++;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor
             + " | Disponibles: " + ejemplaresDisponibles + "/" + ejemplaresTotal;
    }
}