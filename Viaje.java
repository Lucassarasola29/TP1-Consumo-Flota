import java.util.Scanner;


public class Viaje {
    public static void main(String[] args) {
        // B.2 Declaraciones 
        Scanner scanner = new Scanner (System.in);
        final double PRECIO_LITRO = 1250.0;
        final double CAPACIDAD_TANQUE = 400.0;
        String patente; 
        double kminicial; 
        double kmfinal; 
        double litroscargados;
        double kmRecorridos = 0;
        double consumoLitros100Km = 0;
        double rendimientoKmLitro = 0;
        double costototal = 0;
        double costoPorKm = 0;
        double porcentajeTanque = 0;


        // B.1 
        System.out.println("Ingrese la patente del camion: ");
        patente = scanner.nextLine();

        System.out.println("Ingrese el kilometraje inicial del odometro");
        kminicial = scanner.nextDouble();

        System.out.println("Ingrese el kilometraje final del odometro");
        kmfinal = scanner.nextDouble();

        System.out.println(" Ingrese los litros de gasoil cargados");
        litroscargados = scanner.nextDouble();

        // B.3 
        kmRecorridos = kmfinal - kminicial;
        consumoLitros100Km = (litroscargados/ kmRecorridos) * 100.0;
        rendimientoKmLitro = kmRecorridos / litroscargados;
        costototal = litroscargados * PRECIO_LITRO; 
        costoPorKm = costototal / kmRecorridos;
        porcentajeTanque = (litroscargados / CAPACIDAD_TANQUE) * 100.0;

        //B.4 

        System.out.println("\n================================================");
        System.out.println("               RESUMEN DEL VIAJE                ");
        System.out.println("================================================");
        System.out.printf("%-30s %15s%n", "Patente del camión:", patente);
        System.out.printf("%-30s %15.2f%n", "Kilómetros recorridos:", kmRecorridos);
        System.out.printf("%-30s %15.2f%n", "Consumo (L/100 km):", consumoLitros100Km);
        System.out.printf("%-30s %15.2f%n", "Rendimiento (km/L):", rendimientoKmLitro);
        System.out.printf("%-30s %15.2f%n", "Costo total de combustible:", costototal);
        System.out.printf("%-30s %15.2f%n", "Costo por kilómetro:", costoPorKm);
        System.out.printf("%-30s %14.2f%%%n", "Porcentaje tanque cargado:", porcentajeTanque);
        System.out.println("================================================");
        
        scanner.close();






    }
    
} //ssssss
