package retoNormal;

import java.util.ArrayList;

/**
 * Gestiona la colección de vehículos de la empresa de alquiler.
 * Permite añadir, buscar, modificar y eliminar vehículos.
 *
 * @author Alumno
 * @version 1.0
 */
public class ListaVehiculos {

    private ArrayList<Vehiculo> vehiculos;

    /** Crea una lista vacía de vehículos. */
    public ListaVehiculos() {
        vehiculos = new ArrayList<>();
    }

    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Añade un vehículo si su matrícula no existe ya.
     *
     * @param v Vehículo a añadir
     * @return true si se añadió, false si la matrícula ya estaba
     */
    public boolean anadirVehiculo(Vehiculo v) {
        if (buscarPorMatricula(v.getMatricula()) != null) {
            return false;
        }
        vehiculos.add(v);
        return true;
    }

    /** Muestra todos los vehículos con su información completa. */
    public void listarTodos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
            System.out.println("-----------------------------");
        }
    }

    /**
     * Busca un vehículo por su matrícula.
     *
     * @param matricula Matrícula a buscar
     * @return El vehículo encontrado, o null si no existe
     */
    public Vehiculo buscarPorMatricula(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) return v;
        }
        return null;
    }

    /**
     * Modifica los días alquilados de un vehículo.
     *
     * @param matricula Matrícula del vehículo
     * @param dias      Nuevo número de días
     * @return true si se modificó, false si no se encontró
     */
    public boolean modificarDiasAlquilados(String matricula, int dias) {
        Vehiculo v = buscarPorMatricula(matricula);
        if (v == null) return false;
        v.setDiasAlquilados(dias);
        return true;
    }

    /**
     * Modifica el porcentaje de recargo premium de un vehículo.
     *
     * @param matricula  Matrícula del vehículo
     * @param porcentaje Nuevo porcentaje (0-25)
     * @return true si se modificó, false si no se encontró
     */
    public boolean modificarRecargoPremium(String matricula, double porcentaje) {
        Vehiculo v = buscarPorMatricula(matricula);
        if (v == null) return false;
        v.setPorcentajeRecargo(porcentaje);
        return true;
    }

    /**
     * Elimina el vehículo con la matrícula indicada.
     *
     * @param matricula Matrícula a eliminar
     * @return true si se eliminó, false si no existía
     */
    public boolean eliminarPorMatricula(String matricula) {
        Vehiculo v = buscarPorMatricula(matricula);
        if (v == null) return false;
        vehiculos.remove(v);
        return true;
    }

    /**
     * Calcula la suma total de todos los recargos premium.
     *
     * @return Suma de importes de recargo de todos los vehículos
     */
    public double calcularIngresoTotalRecargos() {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.getImporteRecargoPremium();
        }
        return total;
    }

    /** Muestra los vehículos cuyo recargo premium supera el 12%. */
    public void listarVehiculosPremium() {
        boolean hayPremium = false;
        for (Vehiculo v : vehiculos) {
            if (v.esPremium()) {
                System.out.println(v);
                System.out.println("-----------------------------");
                hayPremium = true;
            }
        }
        if (!hayPremium) {
            System.out.println("No hay vehículos premium.");
        }
    }
}
