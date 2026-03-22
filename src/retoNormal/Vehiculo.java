package retoNormal;

/**
 * Representa un vehículo disponible para alquilar.
 * Gestiona los datos del vehículo y calcula los costes del alquiler.
 *
 * @author Alvaro Vizuete
 * @version 1.0
 */
public class Vehiculo {

    // Atributos de instancia — siempre private
    private String matricula;
    private String modelo;
    private double precioBasePorDia;
    private double porcentajeRecargoPremium; // 0 - 25
    private int diasAlquilados;

    // Atributo estático: compartido por todos los vehículos
    private static double precioSeguroDiario = 3.0;

    // ── Constructor ──────────────────────────────────────────────────────────

    /**
     * Crea un vehículo con sus datos básicos.
     *
     * @param matricula              Matrícula única del vehículo
     * @param modelo                 Nombre comercial del vehículo
     * @param precioBasePorDia       Precio base de alquiler por día
     * @param porcentajeRecargo      Porcentaje de recargo premium (0-25)
     */
    public Vehiculo(String matricula, String modelo,
                    double precioBasePorDia, double porcentajeRecargo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.precioBasePorDia = precioBasePorDia;
        this.porcentajeRecargoPremium = porcentajeRecargo;
        this.diasAlquilados = 0;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public String getMatricula()            { return matricula; }
    public String getModelo()               { return modelo; }
    public double getPrecioBasePorDia()     { return precioBasePorDia; }
    public double getPorcentajeRecargo()    { return porcentajeRecargoPremium; }
    public int getDiasAlquilados()          { return diasAlquilados; }
    public static double getPrecioSeguroDiario() { return precioSeguroDiario; }

    // ── Setters ───────────────────────────────────────────────────────────────

    public void setDiasAlquilados(int dias) {
        this.diasAlquilados = dias;
    }

    /**
     * Modifica el porcentaje de recargo premium.
     *
     * @param porcentaje Nuevo porcentaje (debe estar entre 0 y 25)
     */
    public void setPorcentajeRecargo(double porcentaje) {
        this.porcentajeRecargoPremium = porcentaje;
    }

    /**
     * Cambia el precio del seguro diario para TODOS los vehículos.
     *
     * @param precio Nuevo precio del seguro diario
     */
    public static void setPrecioSeguroDiario(double precio) {
        precioSeguroDiario = precio;
    }

    // ── Métodos de negocio ────────────────────────────────────────────────────

    /**
     * Calcula el importe del recargo premium.
     *
     * @return Importe del recargo: precioBase × porcentaje / 100
     */
    public double getImporteRecargoPremium() {
        return precioBasePorDia * porcentajeRecargoPremium / 100;
    }

    /**
     * Calcula el importe total del seguro del alquiler.
     *
     * @return días alquilados × precio seguro diario
     */
    public double getImporteTotalSeguro() {
        return diasAlquilados * precioSeguroDiario;
    }

    /**
     * Calcula el ingreso total generado por este vehículo.
     *
     * @return precioBase + recargoPremium + seguroTotal
     */
    public double getIngresoTotal() {
        return precioBasePorDia + getImporteRecargoPremium() + getImporteTotalSeguro();
    }

    /**
     * Indica si el vehículo tiene un recargo premium superior al 12%.
     *
     * @return true si porcentaje > 12
     */
    public boolean esPremium() {
        return porcentajeRecargoPremium > 12;
    }

    // ── equals ────────────────────────────────────────────────────────────────

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehiculo)) return false;
        Vehiculo otro = (Vehiculo) obj;
        return this.matricula.equals(otro.matricula);
    }

    // ── toString ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return matricula + " - " + modelo + "\n" +
               "Precio Base/Día: " + precioBasePorDia +
               " | Recargo Premium: " + getImporteRecargoPremium() +
               " (" + porcentajeRecargoPremium + "%)" + "\n" +
               "Días alquilado: " + diasAlquilados +
               " | Total generado: " + getIngresoTotal();
    }
}
