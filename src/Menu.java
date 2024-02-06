import java.util.Scanner;

public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    private Cajero cajero = new Cajero();

    public void iniciarSesion() {
        for (int intento = 0; intento < INTENTOS_MAXIMOS; intento++) {
            System.out.print("Por favor, introduzca su PIN: ");
            int pinUsuario = scanner.nextInt();

            currentUser = getCurrentUser(pinUsuario);

            if (currentUser != null) {
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
                cajero.retiroPersonalizado();
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
                cajero.hacerRetiro(20);
                break;
            case 2:
                cajero.hacerRetiro(40);
                break;
            case 3:
                cajero.hacerRetiro(60);
                break;
            case 4:
                cajero.hacerRetiro(100);
                break;
            case 5:
                cajero.hacerRetiro(200);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    private void mostrarMenu() {
        System.out.println("Bienvenido, " + currentUser.getNombreCliente() + ".");
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
                    cajero.verSaldo();
                    break;
                case 2:
                    menuRetiro();
                    break;
                case 3:
                    cajero.hacerDeposito();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestros servicios. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }
}
