package domain.modelo.billetera;

import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class BilleteraFamiliar implements Comparable<BilleteraFamiliar> {

    private String nombreGrupoFamiliar;
    private String lider;
    public String type;
    private List<Usuario> integrantes;
    private List<Solicitud> solicitudes;
    private Double dineroBilletera;
    private List<Gasto> gastos;

    public BilleteraFamiliar(String nombreGrupoFamiliar, String lider, List<Usuario> integrantes, List<Solicitud> solicitudes, List<Gasto> gastos, Double dineroBilletera) {
        this.nombreGrupoFamiliar = nombreGrupoFamiliar;
        this.lider = lider;
        type = "BilleteraFamiliar";
        this.integrantes = integrantes;
        this.solicitudes = solicitudes;
        this.gastos = gastos;
        this.dineroBilletera = dineroBilletera;
    }

    public BilleteraFamiliar(String nombreGrupoFamiliar, String lider) {
        this();
        this.nombreGrupoFamiliar = nombreGrupoFamiliar;
        this.lider = lider;
    }

    public BilleteraFamiliar() {
        integrantes = new ArrayList<>();
        solicitudes = new ArrayList<>();
        gastos = new ArrayList<>();
        type = "BilleteraFamiliar";
        dineroBilletera = 0.0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BilleteraFamiliar that = (BilleteraFamiliar) o;
        return nombreGrupoFamiliar.equalsIgnoreCase(that.nombreGrupoFamiliar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreGrupoFamiliar);
    }

    @Override
    public String toString() {
        return "BilleteraFamiliar{\n" +
                "nombreGrupoFamiliar = " + nombreGrupoFamiliar + "\n" +
                "lider = " + lider + "\n" +
                "integrantes = " + integrantes + "\n" +
                "solicitudes = " + solicitudes + "\n" +
                '}';
    }

    @Override
    public int compareTo(BilleteraFamiliar billetera) {
        return this.getNombreGrupoFamiliar().toLowerCase().compareTo(billetera.getNombreGrupoFamiliar().toLowerCase());
    }
}
