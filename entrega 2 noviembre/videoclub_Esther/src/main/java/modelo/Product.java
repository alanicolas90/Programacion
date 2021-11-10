package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {

    private String title;
    private List<Survey> surveys;
    private int quantity;
    private int rentedQuantity;
    private String genre;
    private double averageRating;

    public Product(String title, int quantity, String genre) {
        this();
        this.title = title;
        this.quantity = quantity;
        this.genre = genre;
    }

    public Product() {
        surveys = new ArrayList<>();
        this.rentedQuantity = 0;
        this.averageRating = 0;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", quantity=" + quantity +
                ", rentedQuantity=" + rentedQuantity +
                ", quantityLeft=" + (quantity - rentedQuantity) +
                ", genre='" + genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Survey> getEncuestas() {
        return surveys;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public int getRentedQuantity() {
        return rentedQuantity;
    }

    public void setRentedQuantity(int rentedQuantity) {
        this.rentedQuantity = rentedQuantity;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
