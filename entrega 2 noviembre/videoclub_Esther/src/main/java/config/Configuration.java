package config;

public class Configuration {

  private static double rentalPrice = 3;
  private static int daysRentalVideogames = 50;
  private static int daysRentalMovies = 50;

  public static double getRentalPrice() {
    return rentalPrice;
  }

  public static void setRentalPrice(double rentalPrice) {
    // si soy el gerente lo puedo cambiar
    Configuration.rentalPrice = rentalPrice;
  }

  public static int getDaysRentalVideogames() {
    return daysRentalVideogames;
  }

  public static void setDaysRentalVideogames(int daysRentalVideogames) {
    Configuration.daysRentalVideogames = daysRentalVideogames;
  }

  public static int getDaysRentalMovies() {
    return daysRentalMovies;
  }

  public static void setDaysRentalMovies(int daysRentalMovies) {
    Configuration.daysRentalMovies = daysRentalMovies;
  }
}
