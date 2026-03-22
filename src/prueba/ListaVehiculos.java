package prueba;

import java.util.ArrayList;

import retoNormal.Vehiculo;

public class ListaVehiculos {

	private ArrayList<Vehiculo> vehiculos;

	/**
	 * Genera una lista vacia de vehiculos
	 */
	public ListaVehiculos() {
		vehiculos = new ArrayList<>();

	}

	/**
	 * 
	 * @param vehiculoAñadido
	 * @return
	 */
	public boolean añadirVehiculo(Vehiculo vehiculoAñadido) {
		if (buscarPorMatricula(vehiculoAñadido.getMatricula()) != null) {
			return false;
		}
		vehiculos.add(vehiculoAñadido);
		return true;
	}

	/**
	 * 
	 */
	public void listarTodos() {
		if (vehiculos.isEmpty()) {
			System.out.println("No hay vehículos registrados.");
			return;
		}
		for (Vehiculo vehiculoAñadido : vehiculos) {
			System.out.println(vehiculoAñadido);
			System.out.println("-----------------------------");
		}
	}

	/**
	 * 
	 * @param matricula
	 * @return
	 */
	public Vehiculo buscarPorMatricula(String matricula) {
		for (Vehiculo vehiculoAñadido : vehiculos) {
			if (vehiculoAñadido.getMatricula().equalsIgnoreCase(matricula))
				return vehiculoAñadido;
		}
		return null;
	}

	/**
	 * 
	 * @param matricula
	 * @param dias
	 * @return
	 */
	public boolean modificarDiasAlquilados(String matricula, int dias) {
		Vehiculo vehiculoAñadido = buscarPorMatricula(matricula);
		if (vehiculoAñadido == null)
			return false;
		vehiculoAñadido.setDiasAlquilados(dias);
		return true;
	}
	
	

	
}
