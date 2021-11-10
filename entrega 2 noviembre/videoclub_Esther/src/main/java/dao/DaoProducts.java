package dao;

import modelo.Documental;
import modelo.Movie;
import modelo.Product;
import modelo.Videogame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProducts {


    private static List<Product> products = new ArrayList<>();

    public boolean addProducto(Product product) {
        boolean addedProduct = false;
        if (!products.contains(product)) {
            products.add(product);
            addedProduct = true;
        }
        return addedProduct;
    }

    public boolean deletedProduct(Product product) {
        boolean deletedProduct = false;
        return deletedProduct = products.remove(product);
    }


    public List<Movie> getAllMovies() {
        return products.stream()
                .filter(producto -> producto instanceof Movie)
                .map(producto -> (Movie) producto)
                .collect(Collectors.toList());
    }

    public List<Videogame> getAllVideogames() {
        return products.stream()
                .filter(producto -> producto instanceof Videogame)
                .map(producto -> (Videogame) producto)
                .collect(Collectors.toList());
    }

    public List<Documental> getAllDocumentals() {
        return products.stream()
                .filter(product -> !(product instanceof Movie)
                        && (product instanceof Documental))
                .map(product -> (Documental) product)
                .collect(Collectors.toList());
    }


}
