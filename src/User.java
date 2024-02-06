public class User {
    
    private double money;
    private int pin;
    private String nombreCliente="Andres";

    public User(int money, int pin){
        this.money = money;
        this.pin = pin;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public double getMoney() {
        return money;
    }

    public int getPin() {
        return pin;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}