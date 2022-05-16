package domain.modelo.solicitud;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Solicitud implements Comparable<Solicitud> {

    private String solicitante;
    private String mensaje;
    private Boolean aceptado;

    public Solicitud(String solicitante,String mensaje) {
        this();
        this.solicitante = solicitante;
        this.mensaje = mensaje;
    }

    public Solicitud() {
        aceptado = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return solicitante.equals(solicitud.solicitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitante);
    }

    @Override
    public int compareTo(Solicitud o) {
        return solicitante.compareTo(o.solicitante);
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "solicitante='" + solicitante + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", aceptado=" + aceptado +
                '}';
    }
}
