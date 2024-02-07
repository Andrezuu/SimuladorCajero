import java.util.LinkedList;
import java.util.Scanner;

public class Cajero {

    private static Scanner scanner = new Scanner( System.in );
    private User currentUser;
    private LinkedList<User> users = new LinkedList<User>() {{
        add( new User( 100, 1234, "Zein" ) );
        add( new User( 200, 5678, "Adrian" ) );
    }};

    public Cajero( User user ) {
        this.currentUser = user;
        users.add( user );
    }
    public User getCurrentUser( int pin ){
    
        for(User user: users){
            if( pin == user.getPin() ){
                currentUser = user;
            }
        }
        return currentUser;
    }

    public void retiroPersonalizado() {
        System.out.print( "Ingrese el monto a retirar: $" );
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        hacerRetiro( cantidad );
    }

    public void hacerRetiro(double cantidad) {
        if (cantidad > currentUser.getMoney()) {
            System.out.println("Fondos insuficientes. No se puede realizar el retiro.");
        } else {
            currentUser.setMoney(currentUser.getMoney()-cantidad);
            System.out.println("Retiro exitoso. Su saldo actual es: $" + currentUser.getMoney());
        }
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