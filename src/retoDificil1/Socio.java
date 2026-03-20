package retoDificil1;

/**
 * Representa un socio registrado en la biblioteca.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class Socio {

    private String id;
    private String nombre;
    private String email;
    private int numPrestamos;
    private static final int LIMITE_PRESTAMOS = 3;

    public Socio(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.numPrestamos = 0;
    }

    public String getId()     { return id; }
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }
    public int getNumPrestamos() { return numPrestamos; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email)   { this.email = email; }

    /**
     * Comprueba si el socio puede realizar un nuevo préstamo.
     * @return true si no ha alcanzado el límite
     */
    public boolean puedePrestar() {
        return numPrestamos < LIMITE_PRESTAMOS;
    }

    /** Incrementa el contador de préstamos activos. */
    public void incrementarPrestamos() { numPrestamos++; }

    /** Decrementa el contador de préstamos activos al devolver. */
    public void decrementarPrestamos() {
        if (numPrestamos > 0) numPrestamos--;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Email: " + email
             + " | Préstamos activos: " + numPrestamos + "/" + LIMITE_PRESTAMOS;
    }
}