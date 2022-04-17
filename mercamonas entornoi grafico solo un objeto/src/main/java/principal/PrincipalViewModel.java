package principal;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import lombok.Getter;
import modelo.Cliente;
import servicios.ServicioClients;

@Getter
public class PrincipalViewModel {

    private ServicioClients serviciosPersonas;

    public PrincipalViewModel() {
        _state = new SimpleObjectProperty<>(new PrincipalState(FXCollections.observableArrayList(new Cliente("kk","88")),null));
    }


    public PrincipalViewModel(ServicioClients serviciosPersonas) {
        this();
        this.serviciosPersonas = serviciosPersonas;
    }

    private ObjectProperty<PrincipalState> _state;
    public ReadOnlyObjectProperty<PrincipalState> getState() {
        return _state;
    }

    public void addPersona(Cliente persona){
        serviciosPersonas.addClient(persona);
//        _state.get().getPersonas().add(persona);
        _state.get().getPersonas().clear();
        _state.get().getPersonas().addAll(serviciosPersonas.showListClients());

    }

    public void updatePersona(Cliente persona) {
        _state.get().getPersonas().remove(persona);
        _state.get().getPersonas().add(persona);
    }

}
