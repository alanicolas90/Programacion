package dao;

import modelo.Rental;

import java.util.HashMap;
import java.util.Map;

public class DaoRental {


    // el nif como clave primaria
    private static Map<String, Rental> rental = new HashMap<>();

    public boolean addAlquiler(Rental rental) {
        boolean rented = false;
        if (DaoRental.rental.get(rental.getMember().getNif()) == null) {
            DaoRental.rental.put(rental.getMember().getNif(), rental);
            rented = true;
        }
        return rented;
    }

    public boolean borrarAlquiler(Rental rental) {
        boolean returned = false;
        if (DaoRental.rental.remove(rental.getMember().getNif()) != null) {
            returned = true;
        }
        return returned;
    }

    public Rental memberRental(String nif) {
        if (rental.size() == 0) {
            return null;
        } else {
            return rental.get(nif);
        }
    }
}
