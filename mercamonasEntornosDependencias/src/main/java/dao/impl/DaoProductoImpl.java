package dao.impl;

import dao.BBDD;
import dao.DaoProducto;
import jakarta.inject.Inject;
import modelo.cliente.Cliente;
import modelo.cliente.LineaCompra;
import modelo.producto.Ingrediente;
import modelo.producto.Producto;
import modelo.producto.ProductoCaducable;
import modelo.producto.ProductoNormal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class DaoProductoImpl implements DaoProducto {

    private final BBDD db;

    @Inject
    public DaoProductoImpl(BBDD db) {
        this.db = db;
    }

    //GET SET Y MODIFICAR DE LO QUE SEA
    //-------------------------------------------------------------------------------------------------

    @Override
    public boolean addProducto(Producto newProducto) {
        List<Producto> productos = db.loadProducto();

        if (productos == null) {
            productos = new ArrayList<>();
        }
        productos.add(newProducto);
        return db.saveProducto(productos);
    }

    @Override
    public boolean removeProducto(String nombreProducto) {
        boolean ok = false;
        List<Producto> productos = db.loadProducto();

        Producto productoBorrar = productos.stream()
                .filter(producto -> producto.getName().equals(nombreProducto))
                .findFirst()
                .orElse(null);

        if (productoBorrar != null) {
            productos.remove(productoBorrar);
            ok = db.saveProducto(productos);
        }

        return ok;
    }

    @Override
    public boolean updateNameProducto(String nombreProducto, String newNombreProducto) {
        List<Producto> productos = db.loadProducto();

        int index = productos.indexOf(new ProductoNormal(nombreProducto));
        productos.get(index).setName(newNombreProducto);

        return db.saveProducto(productos);
    }

    @Override
    public boolean updatePriceProducto(String nombreProducto, double newPriceProducto) {
        boolean ok = false;
        List<Producto> productos = db.loadProducto();

        Producto productoCambiarDatos = productos.stream()
                .filter(producto -> producto.getName().equals(nombreProducto))
                .findFirst()
                .orElse(null);

        if (productoCambiarDatos != null) {
            productoCambiarDatos.setPrice(newPriceProducto);
            ok = db.saveProducto(productos);
        }

        return ok;
    }

    @Override
    public boolean updateStockProducto(String nombreProducto, int newStockProducto) {
        boolean ok = false;
        List<Producto> productos = db.loadProducto();

        Producto productoCambiarDatos = productos.stream()
                .filter(producto -> producto.getName().equals(nombreProducto))
                .findFirst()
                .orElse(null);

        if (productoCambiarDatos != null) {
            productoCambiarDatos.setStock(newStockProducto);
            ok = db.saveProducto(productos);
        }
        return ok;
    }

    @Override
    public Producto getProductoLista(String productoParaMeterCarrito) {
        List<Producto> productos = db.loadProducto();
//
        return productos.stream()
                .filter(producto -> producto.getName().equals(productoParaMeterCarrito))
                .findFirst()
                .orElse(null);
    }

    @Override
    public double getPriceProducto(String nameProduct) {
        double precioProductoQueBusco = 0;
        List<Producto> productos = db.loadProducto();

        Producto productoQueBusco = productos.stream()
                .filter(producto -> producto.getName().equals(nameProduct))
                .findFirst()
                .orElse(null);

        if (productoQueBusco != null) {
            precioProductoQueBusco = productoQueBusco.getPrice();
        }
        return precioProductoQueBusco;
    }

    @Override
    public int getStockProduct(String nombreProduct) {
        int stockDelProductoPedido = 0;
        List<Producto> productos = db.loadProducto();

        Producto productoQueBuscamos = productos.stream()
                .filter(producto -> producto.getName().equals(nombreProduct))
                .findFirst()
                .orElse(null);

        if (productoQueBuscamos != null)
            stockDelProductoPedido = productoQueBuscamos.getStock();

        return stockDelProductoPedido;
    }

    @Override
    public boolean addIngredienteAlProducto(Ingrediente nuevoIngrediente, String nombreDelProducto) {
        boolean ok = false;
        List<Producto> productos = db.loadProducto();

        Producto productoQueBuscamos = productos.stream()
                .filter(producto -> producto.getName().equals(nombreDelProducto))
                .findFirst()
                .orElse(null);

        if (productoQueBuscamos != null) {
            productoQueBuscamos.getIngredientes().add(nuevoIngrediente);
            ok = db.saveProducto(productos);
        }
        return ok;
    }


    //COMPROBACIONES
    //-------------------------------------------------------------------------------------------------

    @Override
    public boolean productExists(String nombreProducto) {
        boolean existe = false;
        List<Producto> productos = db.loadProducto();

        if(productos!= null) {
            Producto productoQueBuscamos = productos.stream()
                    .filter(producto -> producto.getName().equals(nombreProducto))
                    .findFirst()
                    .orElse(null);


            if (productoQueBuscamos != null)
                existe = true;
        }
        return existe;
    }

    @Override
    public boolean ingredienteExisteEnProducto(Ingrediente nuevoIngrediente, String nombreProducto) {
        List<Producto> productos = db.loadProducto();

        Producto productoQueBuscamos = productos.stream()
                .filter(producto -> producto.getName().equals(nombreProducto))
                .findFirst()
                .orElse(null);

        if (productoQueBuscamos != null) {
            Ingrediente ingredienteQuebuscamosDentroDelProducto = productoQueBuscamos
                    .getIngredientes()
                    .stream()
                    .filter(ingrediente -> ingrediente.equals(nuevoIngrediente))
                    .findFirst()
                    .orElse(null);
            return ingredienteQuebuscamosDentroDelProducto != null;
        }

        return false;
    }

    // VER PRODUCTOS
    // ---------------------------------------------------------------------------------------------------

    @Override
    public List<Producto> showAllProducts() {
        List<Producto> productos = db.loadProducto();
        return productos.stream().filter(producto -> producto.getStock()!=0)
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Producto> showAllProductosSinCaducables() {
        List<Producto> productos = db.loadProducto();
        return productos.stream()
                .filter(producto -> !(producto instanceof ProductoCaducable) || ((ProductoCaducable) producto).getCaducidad().isAfter(LocalDateTime.now()))
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Producto> showAllProductsSortedName() {
        List<Producto> productos = db.loadProducto();
        return productos.stream()
                .sorted(Comparator.comparing(Producto::getName))
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Producto> showAllProductsConIngrediente() {
        List<Producto> productos = db.loadProducto();
        return productos.stream()
                .filter(producto -> !producto.getIngredientes().isEmpty())
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Producto> showAllProductsSinAlergiasCliente(String dniClient) {
        List<Producto> productos = db.loadProducto();
        Map<String, Cliente> clientes = db.loadClientes();

        return productos.stream()
                .filter(
                        producto -> !producto.getIngredientes().equals(clientes.get(dniClient).getAlergenos()))
                .collect(Collectors.toUnmodifiableList());

    }

    @Override
    public List<String> showCantidadProductosOrdenadaPorLaMasComprada() {
        Map<String, Cliente> clientes = db.loadClientes();

        Map<String, Double> map = clientes.values().stream()
                .flatMap(cliente -> cliente.getBuyHistory().stream())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(lineaCompra -> lineaCompra.getProducto().getName(), Collectors.summingDouble(LineaCompra::getQuantity)));

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(stringDoubleEntry -> stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue())
                .collect(Collectors.toUnmodifiableList());
    }


    // index de un producto por su nombre
    //**************************************************************************************************

    @Override
    public int indexProduct(String nameProduct) {
        List<Producto> productos = db.loadProducto();
        return productos.indexOf(new ProductoNormal(nameProduct));
    }
}
