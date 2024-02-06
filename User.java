public class User {
    
    private int money;
    private int pin;

    public User(int money, int pin){
        this.money = money;
        this.pin = pin;
    }


    public int getMoney() {
        return money;
    }

    public int getPin() {
        return pin;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
