public class User {
    
    private double money;
    private int pin;
    private String nombreCliente;

    public User(int money, int pin, String nombreCliente ){
        this.money = money;
        this.pin = pin;
        this.nombreCliente = nombreCliente;
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