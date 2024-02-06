import java.util.Scanner;

public class Cajero {
    private static final int INTENTOS_MAXIMOS = 3;
    private static Scanner scanner = new Scanner(System.in);
    
    public static User getCurrentUser(int pin){
        User currentUser = null;
        for(User user: users){
            if(pin == user.getPin()){
                currentUser = user;
            }
        }
        return currentUser;
    }

    public void retiroPersonalizado() {
        System.out.print("Ingrese el monto a retirar: $");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        hacerRetiro(cantidad);
    }

    public void hacerRetiro(double cantidad) {
        if (cantidad > currentUser.getMoney()) {
            System.out.println("Fondos insuficientes. No se puede realizar el retiro.");
        } else {
            currentUser.setMoney(currentUser.getMoney()-cantidad);
            System.out.println("Retiro exitoso. Su saldo actual es: $" + currentUser.getMoney());
        }
    }

    static User[] users = {
        new User(100, 1234),  // Example user with $100 and PIN 1234
        new User(200, 5678)   // Example user with $200 and PIN 5678
    };

    User currentUser; 

    public Cajero() {
    }


    public void verSaldo() {
        System.out.println("Su saldo actual es: $" + currentUser.getMoney());
    }


    public void hacerDeposito() {
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        currentUser.setMoney(currentUser.getMoney()+cantidad);
        System.out.println("Depósito exitoso. Su saldo actual es: $" + currentUser.getMoney());
    }

}