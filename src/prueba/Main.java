package prueba;

import java.util.Scanner;

import retoNormal.ListaVehiculos;

public class Main {
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ListaVehiculos lista = new ListaVehiculos();
    int opcion;

    do {
        System.out.println("\n====== GESTIÓN DE ALQUILER DE VEHÍCULOS ======");
        System.out.println("1. Añadir vehículo");
        System.out.println("2. Listar vehículos");
        System.out.println("3. Buscar vehículo por matrícula");
        System.out.println("4. Modificar días alquilados");
        System.out.println("5. Modificar recargo premium");
        System.out.println("6. Modificar precio seguro diario");
        System.out.println("7. Eliminar vehículo");
        System.out.println("8. Ver estadísticas");
        System.out.println("9. Salir");
        System.out.print("Opción: ");

        opcion=sc.nextInt();
        sc.nextInt();
        
        switch (opcion) {
        
        case 1 :
        	System.out.println("Introduce la matrícula: ");
        	String matricula =  sc.nextLine().trim().toUpperCase();
        }
        
    }while (opcion != 9);
        
}
}
