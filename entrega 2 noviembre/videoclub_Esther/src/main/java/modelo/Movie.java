package modelo;

import java.util.List;

public class Movie extends Documental{

  private List<String> actors;

  public Movie(String title, int quantity, String genre, MovieFormat format, String director, String duration) {
    super(title, quantity, genre, format, director, duration);
    this.actors = actors;
  }

  public List<String> getActors() {
    return actors;
  }

  @Override
  public String toString() {
    return "Movie: (" + super.toString() + ")";
  }
}
