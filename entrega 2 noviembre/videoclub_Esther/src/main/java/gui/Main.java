package gui;

import com.github.javafaker.Faker;
import config.Configuration;
import modelo.*;
import services.VideoclubServices;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Faker f = new Faker();
        Scanner sc = new Scanner(System.in);
        VideoclubServices sv = new VideoclubServices();
        //menu
        int option;
        boolean keepOnGoing = true;
        do {
            do {
                System.out.println(constantes.WHAT_DO_YOU_WANT_TO_DO);
                option = sc.nextInt();
                sc.nextLine();
                if (option < 1 || option > 8) {
                    System.out.println(constantes.PLEASE_SAY_ONE_OF_THE_OPTIONS_FROM_THE_MENU_I_LL_SHOW_YOU_AGAIN);
                }
            } while (option < 1 || option > 8);
            keepOnGoing = isKeepOnGoing(f, sc, sv, option, keepOnGoing);
        } while (keepOnGoing);
    }












    private static boolean isKeepOnGoing(Faker f, Scanner sc, VideoclubServices sv, int option, boolean keepOnGoing) {
        switch (option) {
            case 1:
                //1. addSocio
                String dni = f.phoneNumber().extension();
                System.out.println(constantes.DNI + dni);
                String name = f.gameOfThrones().character();
                String address = f.gameOfThrones().city();
                String tel = f.phoneNumber().toString();
                int age = f.number().numberBetween(1, 99);
                Member member = new Member(dni, name, address, tel, age);
                if (sv.addSocio(member)) {
                    System.out.println(constantes.MEMBER_REGISTERED);
                } else {
                    System.out.println(constantes.THIS_MEMBER_ALREADY_EXISTS_ON_OUT_DATA_BASE);
                }
                break;
            case 2:
                //2. borrarSocio
                System.out.println(constantes.TO_DELETE_A_MEMBER_JUST_TYPE_THE_DNI_PLEASE);
                dni = sc.nextLine();
                if (sv.borrarSocio(dni)) {
                    System.out.println(constantes.WE_FOUND_THE_USER_AND_WE_DELETED_IT);
                } else {
                    System.out.println(constantes.THIS_USER_DOESN_T_EXISTS_IN_OUR_DATA_BASE);
                }
                break;
            case 3:
                //3. addProducto
                option = menuProduct(sc);
                switch (option) {
                    case 1:
                        Product vj = new Videogame(f.harryPotter().book(), f.number().numberBetween(1, 10), f.color().name(), f.animal().name());
                        registerProduct(vj, sv);
                        break;
                    case 2:
                        Product docu = new Documental(f.harryPotter().book(), f.number().numberBetween(1, 10), f.color().name(), MovieFormat.DVD, f.gameOfThrones().character(), "120min");
                        registerProduct(docu, sv);
                        break;
                    case 3:
                        Product peli = new Movie(f.harryPotter().book(), f.number().numberBetween(1, 10), f.color().name(), MovieFormat.DVD, f.gameOfThrones().character(), "120min");
                        registerProduct(peli, sv);
                        break;
                }
                break;
            case 4:
                //4. AddStockProducto
                option = menuProduct(sc);
                int indexProduct;
                int quantityToChange;
                switch (option) {
                    case 1:
                        if (sv.getAllVideogames().size() > 0) {
                            indexProduct = chooseVideogame(sv, sc);
                            System.out.println(constantes.TELL_ME_THE_QUANTITY_TO_MODIFY_IN_CASE_OF_STOCK_RETIREMENT_PLEASE_INDICATE_IT_NEGATIVELY);
                            quantityToChange = sc.nextInt();
                            sc.nextLine();
                            Product product = sv.getAllVideogames().get(indexProduct);
                            updateStock(quantityToChange, product, sv);
                        } else {
                            System.out.println(constantes.THIS_PRODUCT_TYPE_DOESN_T_EXIST);
                        }
                        break;
                    case 2:
                        if (sv.getAllDocumentals().size() > 0) {
                            indexProduct = chooseDocumental(sv, sc);
                            System.out.println(constantes.TELL_ME_THE_QUANTITY_TO_MODIFY_IN_CASE_OF_STOCK_RETIREMENT_PLEASE_INDICATE_IT_NEGATIVELY);
                            quantityToChange = sc.nextInt();
                            sc.nextLine();
                            Product product = sv.getAllDocumentals().get(indexProduct);
                            updateStock(quantityToChange, product, sv);
                        } else {
                            System.out.println(constantes.THIS_PRODUCT_TYPE_DOESN_T_EXIST);
                        }
                        break;
                    case 3:
                        if (sv.getAllMovies().size() > 0) {
                            indexProduct = chooseMovie(sv, sc);
                            System.out.println(constantes.TELL_ME_THE_QUANTITY_TO_MODIFY_IN_CASE_OF_STOCK_RETIREMENT_PLEASE_INDICATE_IT_NEGATIVELY);
                            quantityToChange = sc.nextInt();
                            sc.nextLine();
                            Product product = sv.getAllMovies().get(indexProduct);
                            updateStock(quantityToChange, product, sv);
                        } else {
                            System.out.println(constantes.THIS_PRODUCT_TYPE_DOESN_T_EXIST);
                        }
                        break;
                }
                break;
            case 5:
                //5. Alquilar
                //encontrar producto,
                option = menuProduct(sc);
                Product productToRent = null;
                switch (option) {
                    case 1:
                        if(sv.getAllVideogames().size() > 0) {
                            indexProduct = chooseVideogame(sv, sc);
                            productToRent = sv.getAllVideogames().get(indexProduct);
                        }else{
                            System.out.println(constantes.WE_DONT_HAVE_THIS_TYPE_ARTICLE);
                        }
                        break;
                    case 2:
                        if(sv.getAllDocumentals().size() > 0) {
                            indexProduct = chooseDocumental(sv, sc);
                            productToRent = sv.getAllDocumentals().get(indexProduct);
                        }else{
                            System.out.println(constantes.WE_DONT_HAVE_THIS_TYPE_ARTICLE);
                        }
                        break;
                    case 3:
                        if(sv.getAllMovies().size() > 0) {
                            indexProduct = chooseMovie(sv, sc);
                            productToRent = sv.getAllMovies().get(indexProduct);
                        }else{
                            System.out.println(constantes.WE_DONT_HAVE_THIS_TYPE_ARTICLE);
                        }
                        break;
                }
                //nif, comprobar: si socio alquilo, si multa, si stock producto; sumar a cantidadAlquilada
                if (productToRent != null) {
                    System.out.println(constantes.TO_PROCEED_TO_RENT_THIS_PRODUCT_I_NEED_YOUR_DNI);
                    dni = sc.nextLine();
                    String rented = sv.rentProduct(productToRent, dni);
                    System.out.println(rented);
                    if (rented.equals(constantes.PRODUCT_RENTED_CORRECTLY)) {
                        if (option == 1) {
                            System.out.println(constantes.REMINDER_YOU_HAVE + Configuration.getDaysRentalVideogames()
                                    + constantes.SECONDS_TO_RETURN_IT_WITHOUT_BEING_SANCTIONED);
                        } else {
                            System.out.println(constantes.REMINDER_YOU_HAVE + Configuration.getDaysRentalVideogames()
                                    + constantes.SECONDS_TO_RETURN_IT_WITHOUT_BEING_SANCTIONED);
                        }
                    }
                }
                break;
            case 6:
                //6. Devolver
                System.out.println(constantes.TO_PROCEED_TO_RENT_THIS_PRODUCT_I_NEED_YOUR_DNI);
                dni = sc.nextLine();
                if (sv.getMember(dni) != null) {
                    System.out.println(constantes.TO_PROCEED_WITH_THE_DEVOLUTION_WE_WOULD_LIKE_TO_KNOW);
                    int punctuation;
                    do {
                        punctuation = sc.nextInt();
                        sc.nextLine();
                    } while (punctuation < 0 || punctuation > 5);
                    System.out.println(constantes.WOULD_YOU_RENT_IT_AGAIN);
                    int answer;
                    do {
                        answer = sc.nextInt();
                        sc.nextLine();
                    } while (answer < 1 || answer > 2);
                    boolean rentAgain;
                    if (answer == 1) {
                        rentAgain = true;
                    } else {
                        rentAgain = false;
                    }
                    Survey survey = new Survey(punctuation, rentAgain);
                    //Servicios -> mirarfecha para multa,sacarAlquilerSocio, acctualizar producto cantidadAlquilada, addEncuestaAProducto
                    if (sv.productRefund(dni, survey)) {
                        System.out.println(constantes.RETURN_DONE);
                    } else {
                        System.out.println(constantes.YOU_DONT_HAVE_ANY_RENTAL_WITH_US);
                    }
                    if (sv.getMember(dni).isSanctioned()) {
                        System.out.println(constantes.YOU_HAVE_BEEN_SANCTIONED_BECAUSE_YOU_RETURNED_LATE_THE_PRODUCT);
                    }
                } else {
                    System.out.println(constantes.YOU_ARE_NOT_REGISTERED_YOU_CANT_HAVE_RENTALS_WITH_US);
                }
                break;
            case 7:
                //7. pagarMulta
                System.out.println(constantes.TELL_ME_YOUR_DNI);
                dni = sc.nextLine();
                if (sv.getMember(dni) != null) {
                    member = sv.getMember(dni);
                    if (member.isSanctioned()) {
                        System.out.println(constantes.YOUR_FEE_HAS_BEEN_PAID);
                        member.setSanctioned(false);
                    } else {
                        System.out.println(constantes.THIS_USER_DOESNT_HAVE_ANY_FEE);
                    }
                } else {
                    System.out.println(constantes.THIS_USER_IS_NOT_REGISTERED);
                }
                break;
            case 8:
                System.out.println(constantes.THANKS_FOR_YOUR_VISIT);
                keepOnGoing = false;
                break;
        }
        return keepOnGoing;
    }

    private static void updateStock(int quantityToChange, Product product, VideoclubServices sv) {
        if (quantityToChange < 0) {
            if ((quantityToChange * (-1)) > product.getQuantity()) {
                System.out.println(constantes.WE_DONT_HAVE_SO_MANY_UNITS_OF_THIS_PRODUCT);
            } else {
                sv.updateStockProduct(product, quantityToChange);
            }
        } else {
            sv.updateStockProduct(product, quantityToChange);
            System.out.println(constantes.STOCK_UPDATED);
        }
        System.out.println(constantes.THE_QUANTITY_NOW_IS + product.getQuantity());
    }

    private static void registerProduct(Product p, VideoclubServices sv) {
        if (sv.addProducto(p)) {
            System.out.println(constantes.PRODUCT_ADDED_CORRECTLY);
        } else {
            System.out.println(constantes.THIS_PRODUCT_CAN_T_BE_ADDED_AGAIN);
        }
    }

    private static int chooseProduct(Scanner sc, int size) {
        System.out.println(constantes.CHOOSE_THE_PRODUCT_YOU_WISH_FROM_THE_LIST);
        int option = 0;
        do {
            option = sc.nextInt();
            sc.nextLine();
            if (option < 1 || option > size) {
                System.out.println(constantes.PLEASE_CHOOSE_ONE_OF_THE_OPTIONS_AVAILABLE);
            }
        } while (option < 1 || option > size);
        return option - 1;
    }

    private static int menuProduct(Scanner sc) {
        int option;
        do {
            System.out.println(constantes.CHOOSE_THE_PRODUCT_TYPE);
            option = sc.nextInt();
            sc.nextLine();
            if (option < 1 || option > 3) {
                System.out.println(constantes.WE_ONLY_HAVE_3_TYPES_OF_PRODUCTS_TYPE_1_2_OR_3_PLEASE);
            }
        } while (option < 1 || option > 3);
        return option;
    }

    private static int chooseVideogame(VideoclubServices sv, Scanner sc) {
        for (Videogame vj : sv.getAllVideogames()) {
            System.out.println((sv.getAllVideogames().indexOf(vj) + 1) + " " + vj.toString());
        }
        return chooseProduct(sc, sv.getAllVideogames().size());
    }

    private static int chooseDocumental(VideoclubServices sv, Scanner sc) {
        for (Documental docu : sv.getAllDocumentals()) {
            System.out.println((sv.getAllDocumentals().indexOf(docu) + 1) + " " + docu.toString());
        }
        return chooseProduct(sc, sv.getAllDocumentals().size());
    }

    private static int chooseMovie(VideoclubServices sv, Scanner sc) {
        for (Movie peli : sv.getAllMovies()) {
            System.out.println((sv.getAllMovies().indexOf(peli) + 1) + " " + peli.toString());
        }
        return chooseProduct(sc, sv.getAllMovies().size());
    }

}
