package modelo;

public class Monedero {

    private String name;
    private double money;

    public Monedero(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Monedero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
