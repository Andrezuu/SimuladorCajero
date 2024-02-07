public class Main {
    public static void main(String[] args) {

        User user1 = new User( 1222, 1334, "Andres" );
        Menu menu = new Menu( user1 ); 
        menu.iniciarSesion();
        
    }
}
