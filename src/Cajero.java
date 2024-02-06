import java.util.Scanner;

public class Cajero {
    private static final String PIN_CORRECTO = "1235";
    private static final int INTENTOS_MAXIMOS = 3;
    private static Scanner scanner = new Scanner(System.in);
    private String nombreCliente;
    private double saldo;

    public Cajero(String nombreCliente, double saldoInicial) {
        this.nombreCliente = nombreCliente;
        this.saldo = saldoInicial;
    }

    public void iniciarSesion() {
        for (int intento = 0; intento < INTENTOS_MAXIMOS; intento++) {
            System.out.print("Por favor, introduzca su PIN: ");
            String pinUsuario = scanner.nextLine();

            if (pinUsuario.equals(PIN_CORRECTO)) {
                mostrarMenu();
                return;
            } else {
                int intentosRestantes = INTENTOS_MAXIMOS - intento - 1;
                if (intentosRestantes > 0) {
                    System.out.println("PIN incorrecto. Le quedan " + intentosRestantes + " intentos.");
                } else {
                    System.out.println("Ha agotado todos los intentos. Acceso denegado.");
                    return;
                }
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Bienvenido, " + nombreCliente + ".");
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver saldo");
            System.out.println("2. Hacer un retiro");
            System.out.println("3. Hacer un depósito");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    verSaldo();
                    break;
                case 2:
                    menuRetiro();
                    break;
                case 3:
                    hacerDeposito();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestros servicios. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    private void verSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }

    private void menuRetiro() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Retirar cantidad predefinida");
        System.out.println("2. Ingresar un monto personalizado");
        System.out.println("3. Cancelar transacción");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (opcion) {
            case 1:
                retiroPredefinido();
                break;
            case 2:
                retiroPersonalizado();
                break;
            case 3:
                System.out.println("Transacción cancelada.");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    private void retiroPredefinido() {
        System.out.println("Seleccione el monto de retiro:");
        System.out.println("1. $20");
        System.out.println("2. $40");
        System.out.println("3. $60");
        System.out.println("4. $100");
        System.out.println("5. $200");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (opcion) {
            case 1:
                hacerRetiro(20);
                break;
            case 2:
                hacerRetiro(40);
                break;
            case 3:
                hacerRetiro(60);
                break;
            case 4:
                hacerRetiro(100);
                break;
            case 5:
                hacerRetiro(200);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    private void retiroPersonalizado() {
        System.out.print("Ingrese el monto a retirar: $");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        hacerRetiro(cantidad);
    }

    private void hacerRetiro(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Fondos insuficientes. No se puede realizar el retiro.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Su saldo actual es: $" + saldo);
        }
    }

    private void hacerDeposito() {
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        saldo += cantidad;
        System.out.println("Depósito exitoso. Su saldo actual es: $" + saldo);
    }

    public static void main(String[] args) {
        Cajero cajero = new Cajero("John Doe", 1000.0); // Crear un nuevo objeto Cajero
        cajero.iniciarSesion(); // Iniciar sesión del cajero
    }
}