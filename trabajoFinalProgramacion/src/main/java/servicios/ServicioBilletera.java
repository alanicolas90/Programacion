package servicios;

import dao.DaoBilletera;
import dao.DaoUsuario;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.List;

public class ServicioBilletera {

    private final DaoBilletera daoBilletera;
    private final DaoUsuario daoUsuario;

    @Inject
    public ServicioBilletera(DaoBilletera daoBilletera,DaoUsuario daoUsuario) {
        this.daoBilletera = daoBilletera;
        this.daoUsuario = daoUsuario;
    }


    public void crearBilletera(Usuario user,BilleteraFamiliar billeteraFamiliar) {
        if(daoBilletera.crearBilletera(billeteraFamiliar)){
            daoUsuario.addBilletera(user, billeteraFamiliar);
        }
    }

    public boolean billeteraExiste(String nombreBilletera) {
        return daoBilletera.billeteraExiste(nombreBilletera);
    }

    public List<BilleteraFamiliar> getBilleteras(Usuario usuario) {
        return daoBilletera.getBilleteras(usuario);
    }

    public boolean billeteraExisteUsuarioSpecific(String nombreBilletera,Usuario user) {
        return daoBilletera.billeteraExisteUsuarioSpecific(nombreBilletera, user);
    }

    public boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar) {
        return daoBilletera.eliminarBilletera(usuario, billeteraFamiliar);
    }

    public BilleteraFamiliar getBilletera(String nombreBilletera) {
        return daoBilletera.getBilletera(nombreBilletera);
    }
}
