package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente implements Clone {


  private String nombre;

  @Override
  public Ingrediente clone() {
    return new Ingrediente(this.nombre);
  }
}
