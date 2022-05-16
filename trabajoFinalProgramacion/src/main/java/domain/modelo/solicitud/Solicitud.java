package domain.modelo.solicitud;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Solicitud {

    private String mensaje;
    private Boolean aceptado;

    public Solicitud(String mensaje) {
        this();
        this.mensaje = mensaje;
    }

    public Solicitud() {
        aceptado = false;
    }
}
