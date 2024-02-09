import java.util.LinkedList;
import java.util.Scanner;

public class Cajero {

    private static Scanner scanner = new Scanner( System.in );
    private User currentUser;
    private LinkedList<User> users = new LinkedList<User>() {{
        add( new User( 100, "01234", "Zein" ) );
        add( new User( 200, "5678", "Adrian" ) );
    }};

    public Cajero( User user ) {
        users.add( user );
    }

    public Cajero() {
    }

    public User getCurrentUser( String pin ){
        
        for(User user: users){
            if( pin .equals( user.getPin() )){
                currentUser = user;
            }
        }
        return currentUser;
    }

    public void retiroPersonalizado() {
        System.out.print( "Ingrese el monto a retirar: $" );
        try {            
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            hacerRetiro( cantidad );   
        } catch (Exception e) {
            operacionInvalida();
            retiroPersonalizado();
        }
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

        try {
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            currentUser.setMoney(currentUser.getMoney()+cantidad);
            System.out.println("Depósito exitoso. Su saldo actual es: $" + currentUser.getMoney());
        } catch (Exception e) {
            operacionInvalida();
            hacerDeposito();
        }
        
    }

    private void operacionInvalida(){
        System.out.println("Operacion Invalida. Vuelva a intentarlo");
        scanner.next();
    }

}