package ui.admin;

import common.Common;
import constantes.Constantes;
import jakarta.inject.Inject;
import domain.modelo.producto.Ingrediente;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoCaducable;
import domain.modelo.producto.ProductoNormal;
import servicios.ServicioProductos;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UIMenuAdminProduct {

  private final ServicioProductos servicioProductos;
  private final Scanner sc;

  @Inject
  public UIMenuAdminProduct(ServicioProductos servicioProductos,Scanner sc) {
    this.servicioProductos = servicioProductos;
    this.sc = sc;
  }

  public void getOption() {
    Common common = new Common();
    int optionMenuProducts;

    do {
      System.out.println(Constantes.OPTIONS_PRODUCTS);
      optionMenuProducts = common.giveInt();

      switch (optionMenuProducts) {
        case 1:
          addNewProduct(sc);
          break;
        case 2:
          addProductoCaducable(sc);
          break;
        case 3:
          deleteProduct(sc);
          break;
        case 4:
          changeNameProduct(sc);
          break;
        case 5:
          changePriceProduct(sc);
          break;
        case 6:
          changeStockProduct(sc);
          break;
        case 7:
          agregarIngredienteAUnProducto(sc);
          break;
        case 8:
          showProductList();
          break;
        case 9:
          showAllProductosSortedName();
          break;
        case 10:
          showAllProductsSortedCatidadComprada();
          break;
        case 11:
          showAllProductsConIngrediente();
          break;
        case 0:
          System.out.println(Constantes.BYE_BYE);
          break;
        default:
          System.out.println(Constantes.ERROR);
      }
    } while (optionMenuProducts != 0);
  }

  private void showAllProductsSortedCatidadComprada() {
    System.out.println(servicioProductos.showAllProductsSortedCantidadComprada());
  }

  private void showAllProductsConIngrediente() {
    System.out.println(servicioProductos.showAllProductsConIngredientes());
  }

  private void showAllProductosSortedName() {
    System.out.println(servicioProductos.showAllProductsOrdenadosName());
  }

  private void agregarIngredienteAUnProducto(Scanner sc) {
    System.out.println(servicioProductos.showAllProducts());

    System.out.println(Constantes.A_QUE_PRODUCTO_LE_QUIERES_INCLUIR_INGREDIENTE);
    String nombreDelProducto = sc.nextLine();

    System.out.println(Constantes.QUE_INGREDIENTE_LE_QUIERE_INTRODUCIR);
    String ingredienteIntroducido = sc.nextLine();

    Ingrediente nuevoIngrediente = new Ingrediente(ingredienteIntroducido);

    if (servicioProductos.addIngredienteAlProducto(nombreDelProducto, nuevoIngrediente)) {
      System.out.println(Constantes.SE_HA_AGREGADO_CON_EXITO);
    } else {
      System.out.println(Constantes.ERROR);
    }

    System.out.println(servicioProductos.showAllProducts());
  }

  private void addProductoCaducable(Scanner sc) {
    Common common = new Common();

    System.out.println(Constantes.DIME_EL_NOMBRE_DEL_PRODUCTO);
    String nameProduct = sc.nextLine();

    System.out.println(Constantes.DIME_EL_PRECIO_DE + nameProduct);
    double priceProductCaducable = common.giveDouble();

    System.out.println(Constantes.DIME_AHORA_LA_CANTIDAD_DEL_STOCK);
    int stockProductoCaducable = common.giveInt();

    System.out.println(Constantes.DIME_LA_FECHA_DE_CADUCIDAD_YYYY_MM_DD_THH_MM_SS);
    LocalDateTime fechaCaducidad = LocalDateTime.parse(sc.nextLine());


    ProductoCaducable productoCaducable = new ProductoCaducable(nameProduct, priceProductCaducable,
        stockProductoCaducable, fechaCaducidad);
    if (servicioProductos.addProductCaducable(productoCaducable)) {
      System.out.println(Constantes.SE_HA_ANADIDO_CORRECTAMENTE);
    } else {
      System.out.println(Constantes.ERROR);
    }
  }

  private void showProductList() {
    System.out.println(servicioProductos.showAllProducts());
  }


  private void changeStockProduct(Scanner sc) {
    Common common = new Common();
    String nombreProducto;
    System.out.print(Constantes.A_QUE_PRODUCTO_DESEA_CAMBIARLE_EL_STOCK);
    nombreProducto = sc.nextLine();

    System.out.print(Constantes.CUAL_ES_EL_NUEVO_STOCK_DEL_PRODUCTO);
    int newStockProducto = common.giveInt();

    if (servicioProductos.updateStockProduct(nombreProducto, newStockProducto)) {
      System.out.println(Constantes.STOCK_CHANGE_SUCCESS);
    } else {
      System.out.println(Constantes.ERROR_TRY_AGAIN);
    }
  }

  private void changePriceProduct(Scanner sc) {
    Common common = new Common();

    System.out.print(Constantes.A_QUE_PRODUCTO_DESEA_CAMBIARLE_EL_PRECIO);
    String nombreProducto = sc.nextLine();

    System.out.print(Constantes.CUAL_ES_EL_NUEVO_PRECIO_DEL_PRODUCTO);
    double newPriceProducto = common.giveDouble();

    if (servicioProductos.updatePriceProduct(nombreProducto, newPriceProducto)) {
      System.out.println(Constantes.PRICE_SUCCESS_CHANGE);
    } else {
      System.out.println(Constantes.ERROR_TRY_AGAIN);
    }
  }

  private void changeNameProduct(Scanner sc) {
    System.out.print(Constantes.A_QUE_PRODUCTO_DESEA_CAMBIARLE_EL_NOMBRE);
    String nombreProducto = sc.nextLine();

    System.out.print(Constantes.CUAL_ES_EL_NUEVO_NOMBRE_DEL_PRODUCTO);
    String newNombreProducto = sc.nextLine();

    if (servicioProductos.updateNameProduct(nombreProducto, newNombreProducto)) {
      System.out.println(Constantes.NAME_CHANGE_SUCCESS);
    } else {
      System.out.println(Constantes.ERROR_TRY_AGAIN);
    }
  }

  private void deleteProduct(Scanner sc) {
    System.out.println(servicioProductos.showAllProducts());

    System.out.print(Constantes.QUE_PRODUCTO_DESEA_ELIMINAR);
    String nombreProducto = sc.nextLine();

    if (servicioProductos.removeProduct(nombreProducto)) {
      System.out.println(Constantes.SUCCESS_DELETE);
    } else {
      System.out.println(Constantes.ERROR_TRY_AGAIN);
    }
  }

  private void addNewProduct(Scanner sc) {
    Common common = new Common();

    System.out.print(Constantes.COMO_QUIERES_QUE_SE_LLAME_EL_NUEVO_PRODUCTO);
    String nombreProducto = sc.nextLine();

    System.out.print(Constantes.DIME_EL_PRECIO_DEL_PRODUCTO);
    double priceProducto = common.giveDouble();

    System.out.print(Constantes.CUANTO_STOCK_TIENES_DEL_PRODUCTO);
    int stockProducto = common.giveInt();

    Producto newProduct = new ProductoNormal(nombreProducto, priceProducto, stockProducto);

    if (servicioProductos.addProduct(newProduct)) {
      System.out.println(Constantes.PRODUCT_ADD_SUCCESS);
    } else {
      System.out.println(Constantes.ERROR_TRY_AGAIN);
    }
  }

}


