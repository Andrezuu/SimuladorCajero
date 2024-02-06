import java.util.Scanner;

public class MenuPIN {


    static User[] users = {
                new User(100, 1234),  // Example user with $100 and PIN 1234
                new User(200, 5678)   // Example user with $200 and PIN 5678
            };
    
    public static User getCurrentUser(int pin){
        User currentUser = null;
        for(User user: users){
            if(pin == user.getPin()){
                currentUser = user;
            }
        }
        return currentUser;
    }

    public static void main(String[] args) {
 
        
 
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú:");
            System.out.println("1. Introducir PIN");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca su PIN: ");
                    int pin = scanner.nextInt();
                    // Aquí podrías validar el PIN o realizar alguna acción con él

                    User currentUser = getCurrentUser(pin);

                    if(currentUser!=null){
                    
                        // mandar al otro menu 
                        // el usuario esta en currentUser
                        System.out.println("Ingreso!!!! "+ currentUser.getPin() +" "+ currentUser.getMoney());
        
                    }
                    else{
                        System.out.println("No existe el usuario");
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 2);
        
        scanner.close();
    }
}
