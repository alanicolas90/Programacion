package principal;


import javafx.collections.ObservableList;
import lombok.Data;
import modelo.Cliente;

@Data
public class PrincipalState {

    private final ObservableList<Cliente> personas;
//    public ObservableList<Persona> getPersonas()
//    {
//        return FXCollections.unmodifiableObservableList(personas);
//    }

    private final String error;

}
