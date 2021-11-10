package services;

import config.Configuration;
import dao.DaoRental;
import dao.DaoProducts;
import dao.DaoSocios;
import modelo.*;

import java.time.LocalDateTime;
import java.util.List;

public class VideoclubServices {

    private Object TimeUnit;

    // add socio
    public boolean addSocio(Member member) {
        DaoSocios daoSocios = new DaoSocios();
        return daoSocios.addSocio(member);
    }

    // borrarSocio
    public boolean borrarSocio(String dni) {
        DaoSocios daoSocio = new DaoSocios();
        if (daoSocio.getSocioPorNif(dni) != null) {
            return daoSocio.deleteSocio(daoSocio.getSocioPorNif(dni));
        }
        return false;
    }

    public Member getMember(String nif) {
        DaoSocios daoSocio = new DaoSocios();
        return daoSocio.getSocioPorNif(nif);
    }

    public boolean addProducto(Product product) {
        DaoProducts daoProducts = new DaoProducts();
        return daoProducts.addProducto(product);
    }

    public void updateStockProduct(Product p, int quantity) {
        p.setQuantity(p.getQuantity() + quantity);
    }

    public boolean productRefund(String nifMember, Survey e) {
        boolean refund = false;
        DaoRental daoRental = new DaoRental();
        Rental rental = daoRental.memberRental(nifMember);
        if (rental != null) {
            Product product = rental.getProductRented();
            product.setRentedQuantity(product.getRentedQuantity() - 1);
            //sancion --> comprobar si se pasa del tiempo
            int timeRented;
            if (product instanceof Documental) {
                timeRented = Configuration.getDaysRentalMovies();
            } else {
                timeRented = Configuration.getDaysRentalVideogames();
            }
            if (!daoRental.memberRental(nifMember).getDateRental().plusSeconds(timeRented).isAfter(LocalDateTime.now())) {
                daoRental.memberRental(nifMember).getMember().setSanctioned(true);
            }
            refund = daoRental.borrarAlquiler(daoRental.memberRental(nifMember));
            //añadir encuesta a producto
            product.getEncuestas().add(e);
        }
        return refund;
    }

    public String rentProduct(Product p, String nifMember) {
        String rented = null;
        double price = Configuration.getRentalPrice();
        DaoRental daoRental = new DaoRental();
        DaoSocios daoSocios = new DaoSocios();
        if(daoSocios.getSocioPorNif(nifMember) == null){
            rented = "Sorry, you are not registered yet.\n" +
                    "You should register first if you want to rent";
        } else if (daoSocios.getSocioPorNif(nifMember).isSanctioned()) {
            rented = "You are sanctione, proceed to pay your fee.\n" +
                    "THANK YOU A LOT";
        }else if (daoRental.memberRental(nifMember) != null) {
            rented = "Actually you have a rented product.\n" +
                    "Return it first, please.";
        } else if ((p.getQuantity() - p.getRentedQuantity()) < 1) {
            rented = "We actually don´t have this product right now.\n" +
                    "Sorry for the inconvenience";
        } else {
            p.setRentedQuantity(p.getRentedQuantity() + 1);
            Rental rental = new Rental(LocalDateTime.now(), daoSocios.getSocioPorNif(nifMember), p);
            if(daoRental.addAlquiler(rental)){
                rented = "Product rented correctly\n" +
                        "THANK YOU A LOT";
            }
        }
        return rented;
    }

    public List<Movie> getAllMovies() {
        DaoProducts daoProducts = new DaoProducts();
        return daoProducts.getAllMovies();
    }

    public List<Documental> getAllDocumentals() {
        DaoProducts daoProducts = new DaoProducts();
        return daoProducts.getAllDocumentals();
    }

    public List<Videogame> getAllVideogames() {
        DaoProducts daoProducts = new DaoProducts();
        return daoProducts.getAllVideogames();
    }

}
