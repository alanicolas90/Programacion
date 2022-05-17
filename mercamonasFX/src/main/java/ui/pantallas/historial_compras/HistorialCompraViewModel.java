package ui.pantallas.historial_compras;

import domain.modelo.Cromo;
import domain.usecases.LoadCromosUseCase;
import jakarta.inject.Inject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;

public class HistorialCompraViewModel {


    private LoadCromosUseCase loginUseCase;

    @Inject
    public HistorialCompraViewModel(LoadCromosUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;

        HistorialCompraState ls = null;
        List<Cromo> cromos = loginUseCase.loadCromos();
        if (cromos==null)
            ls = new HistorialCompraState(null,"no se han podido cargar cromos");
        else
            ls = new HistorialCompraState(cromos,null);

        _state = new SimpleObjectProperty<>(new HistorialCompraState(null,null));
    }

    private final ObjectProperty<HistorialCompraState> _state;
    public ReadOnlyObjectProperty<HistorialCompraState> getState() {
        return _state;
    }

    public void loadCromos()
    {
        HistorialCompraState ls = null;
        List<Cromo> cromos = loginUseCase.loadCromos();
        if (cromos==null)
            ls = new HistorialCompraState(null,"no se han podido cargar cromos");
        else
            ls = new HistorialCompraState(cromos,null);
        _state.setValue(ls);
    }

}
