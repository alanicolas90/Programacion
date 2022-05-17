package ui.pantallas.historial_compras;

import domain.modelo.Cromo;
import lombok.Data;

import java.util.List;

@Data
public class HistorialCompraState {

    private final List<Cromo> cromos;
    private final String error;
}
