import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi busqueda = new ConsultaApi();
        ConvertirMoneda convertir = new ConvertirMoneda();

        int opcion = 0;
        while (opcion != 10) {
            System.out.println("""
                    *****************************************
                    Bienvenidos al conversor de monedas
                    Ingrese la conversion que deseas realizar:
                    1. Dollar a peso argentino
                    2. Peso argentino a dolar
                    3. Dolar a Real braseleño
                    4. Real brasileño a dolar
                    5. Dolar a peso colombiano
                    6. Peso colombiano a dolar
                    7. Dollar australiano a dolar
                    8. Dolar barbados a peso argenito
                    9. Chinese Renbinbi a peso chileno
                    10. Salir""");
            opcion = lectura.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese la cantidad a convertir: ");
                double cantidad = lectura.nextDouble();

                String base = "", destino = "";
                switch (opcion) {
                    case 1:
                        base = "USD";
                        destino = "ARS";
                        break;
                    case 2:
                        base = "ARS";
                        destino = "USD";
                        break;
                    case 3:
                        base = "USD";
                        destino = "BRL";
                        break;
                    case 4:
                        base = "BRL";
                        destino = "USD";
                        break;
                    case 5:
                        base = "USD";
                        destino = "COP";
                        break;
                    case 6:
                        base = "COP";
                        destino = "USD";
                        break;
                    case 7:
                        base = "AUD";
                        destino = "USD";
                        break;
                    case 8:
                        destino = "BBD";
                        base = "ARS";
                    case 9:
                        destino = "CNY";
                        base = "CLP";
                }
                try {
                    Moneda moneda = busqueda.busquedaMoneda(base);
                    double tasaConversion = moneda.conversion_rates().get(destino);
                    double resultado = convertir.convertir(cantidad, tasaConversion);
                    System.out.println("Resultado " + resultado + " " + destino);
                } catch (Exception e) {
                    System.out.println("Error al realizar la conversion: " + e.getMessage());
                }
            }
        }
        System.out.println("Gracias por usar el conversor");
    }
}
