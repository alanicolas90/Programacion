package modelo;

import java.time.LocalDateTime;

public class Rental {
    private LocalDateTime dateRental;
    private Member member;
    private Product productRented;

    public Rental(LocalDateTime dateRental, Member member, Product productRented) {
        this.dateRental = dateRental;
        this.member = member;
        this.productRented = productRented;
    }

    public LocalDateTime getDateRental() {
        return dateRental;
    }

    public void setDateRental(LocalDateTime dateRental) {
        this.dateRental = dateRental;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Product getProductRented() {
        return productRented;
    }

    public void setProductRented(Product productRented) {
        this.productRented = productRented;
    }
}
