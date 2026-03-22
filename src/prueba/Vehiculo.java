package prueba;


public class Vehiculo {

	private String matricula;
	private String modelo;
	private double precioBasePorDia;
    private double porcentajeRecargoPremium; // 0 - 25
    private int diasAlquilados;
    
    
    private static double precioSeguroDiario = 3.0;
    
    // Constructor
    
	public Vehiculo(String matricula, String modelo, double precioBasePorDia, double porcentajeRecargo,
			int diasAlquilados) {
		
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioBasePorDia = precioBasePorDia;
		this.porcentajeRecargoPremium = porcentajeRecargo;
		this.diasAlquilados = 0;
	}


	// Getters 
	
    public String getMatricula()            { return matricula; }
    public String getModelo()               { return modelo; }
    public double getPrecioBasePorDia()     { return precioBasePorDia; }
    public double getPorcentajeRecargo()    { return porcentajeRecargoPremium; }
    public int getDiasAlquilados()          { return diasAlquilados; }
    public static double getPrecioSeguroDiario() { return precioSeguroDiario; }
    
    // Setters
    
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

   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehiculo)) return false;
        Vehiculo otro = (Vehiculo) obj;
        return this.matricula.equals(otro.matricula);
    }
	

	 @Override
	 public String toString() {
		return matricula + " - " + modelo +"\n" +
	 "Precio Base/Dia: " + getPrecioBasePorDia() + " | " + "Recargo Premium : " + getImporteRecargoPremium() + " (" + porcentajeRecargoPremium +"%) " + "\n"+
	 "Dias Alquilados : " + getDiasAlquilados() + " | " + "Total Generado : " + getIngresoTotal() ;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
