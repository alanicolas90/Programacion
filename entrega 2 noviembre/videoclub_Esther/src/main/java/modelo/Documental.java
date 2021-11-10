package modelo;

public class Documental extends Product {

  private MovieFormat format;
  private String director;
  private String duration;

  public Documental(String title, int quantity, String genre, MovieFormat format, String director, String duration) {
    super(title, quantity, genre);
    this.format = format;
    this.director = director;
    this.duration = duration;
  }

  public MovieFormat getFormat() {
    return format;
  }

  public void setFormat(MovieFormat format) {
   this.format = format;
  }

  @Override
  public String toString() {
    return "Documental: (" + super.toString() +
            ", format=" + format +
            ", director='" + director +
            ", duration='" + duration + ")";
  }
}
