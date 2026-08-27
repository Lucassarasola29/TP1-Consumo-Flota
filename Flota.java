import java.util.Scanner; 

public class Flota {
    public static final int CANTIDAD_CAMIONES = 6;
    public static final double CONSUMO_MAX_ECONOMICO = 30.0;
    public static final double CONSUMO_MAX_NORMAL = 40.0;

    // C.1: Carga de datos
    public static void cargarDatos(Scanner scanner, String[] patentes, double[] kmRecorridos, double[] litrosConsumidos) {
        System.out.println("=== INGRESO DE DATOS DE FLOTA ===");
        for (int i = 0; i < CANTIDAD_CAMIONES; i++) {
            System.out.println("\nCamión " + (i + 1) + ":");
            System.out.print("Patente: ");
            patentes[i] = scanner.next();

            do {
                System.out.print("Kilómetros recorridos: ");
                kmRecorridos[i] = scanner.nextDouble();
            } while (kmRecorridos[i] <= 0);

            do {
                System.out.print("Litros consumidosa: ");
                litrosConsumidos[i] = scanner.nextDouble();
            } while (litrosConsumidos[i] < 0);
        }    
    }

    // C.2: Métodos de cálculo
    public static double calcularTotalKm(double[] kmRecorridos) {
        double total = 0;
        for (double km : kmRecorridos) {
            total += km;
        }
        return total;
    }

    public static double calcularTotalLitros(double[] litrosConsumidos) {
        double total = 0;
        for (double litros : litrosConsumidos) {
            total += litros;
        }
        return total; 
    }
    
    
    public static int indiceMasRecorrio(double[] kmRecorridos) {
        int indiceMax = 0;
        for (int i = 1; i < kmRecorridos.length; i++) {
            if (kmRecorridos[i] > kmRecorridos[indiceMax]) {
                indiceMax = i;
            }
        }
        return indiceMax; 
    }

    public static int indiceMenosRecorrio(double[] kmRecorridos) {
        int indiceMin = 0;
        for (int i = 1; i < kmRecorridos.length; i++) {
            if (kmRecorridos[i] < kmRecorridos[indiceMin]) {
                indiceMin = i;
            }
        }
        return indiceMin;
    }   

    public static double calcularPromedioKm(double[] kmRecorridos) {
        double totalKm = calcularTotalKm(kmRecorridos);
        return totalKm / kmRecorridos.length;
    }

    // C.3: Cálculo de consumo 
    public static double calcularConsumo(double km, double litros) {
        if (km <= 0) {
            return 0.0;
        }
        return (litros / km) * 100.0;
    }

    // C.4: Clasificación de consumo (retorna el String)
    public static String obtenerClasificacion(double consumo) {
        String condicion;
        if (consumo < CONSUMO_MAX_ECONOMICO) {
            condicion = "Económico";
        } else if (consumo <= CONSUMO_MAX_NORMAL) {
            condicion = "Normal";
        } else {
            condicion = "Alto consumo";
        }
        return condicion;
    }   

    // Mostrar informe flota
    public static void mostrarInformeFlota(String[] patentes, double[] kmRecorridos, double[] litrosConsumidos) {
        
        // Reporte C.2
        System.out.printf("%n==================================================%n");
        System.out.println("            INFORME GENERAL DE LA FLOTA           ");
        System.out.printf("==================================================%n");
        System.out.printf("Total de kilómetros recorridos:  %12.2f km%n", calcularTotalKm(kmRecorridos));
        System.out.printf("Total de litros consumidos:      %12.2f L%n", calcularTotalLitros(litrosConsumidos));
        System.out.printf("Promedio de km por camión:       %12.2f km%n", calcularPromedioKm(kmRecorridos));
        System.out.printf("Camión que MÁS recorrió:         %s (%.2f km)%n", patentes[indiceMasRecorrio(kmRecorridos)], kmRecorridos[indiceMasRecorrio(kmRecorridos)]);
        System.out.printf("Camión que MENOS recorrió:       %s (%.2f km)%n", patentes[indiceMenosRecorrio(kmRecorridos)], kmRecorridos[indiceMenosRecorrio(kmRecorridos)]);
        System.out.printf("Consumo promedio de la flota:    %12.2f L/100km%n", calcularConsumo(calcularTotalKm(kmRecorridos), calcularTotalLitros(litrosConsumidos)));

        // Reporte C.4 (Tabla individual)
        System.out.printf("%n--------------------------------------------------%n");
        System.out.println("             CLASIFICACIÓN POR CAMIÓN             ");
        System.out.printf("--------------------------------------------------%n");

        for (int i = 0; i < CANTIDAD_CAMIONES; i++) {
            double consumoIndividual = calcularConsumo(kmRecorridos[i], litrosConsumidos[i]);

            System.out.printf("Patente: %-8s | Consumo: %6.2f L/100km | Clasificación: %s%n",
                    patentes[i], consumoIndividual, obtenerClasificacion(consumoIndividual));
        }
        System.out.printf("==================================================%n");
    }

    // Main para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] patentes = new String[CANTIDAD_CAMIONES];
        double[] kmRecorridos = new double[CANTIDAD_CAMIONES];
        double[] litrosConsumidos = new double[CANTIDAD_CAMIONES];

        cargarDatos(scanner, patentes, kmRecorridos, litrosConsumidos);
        mostrarInformeFlota(patentes, kmRecorridos, litrosConsumidos);

        scanner.close();
    }
}
/// fin programa flota, flota.java