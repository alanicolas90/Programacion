package modelo;

public class Videogame extends Product {

    private String producer;

    public Videogame(String title, int quantity, String genre, String producer) {
        super(title, quantity, genre);
        this.producer = producer;
    }

    @Override
    public String toString() {
        return
                "Videogame: (" + super.toString() +
        ", producer='" + producer + ")";
    }
}
