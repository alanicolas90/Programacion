package dao;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;

import java.util.List;

public interface DaoUsuario {
    boolean registrarUsuario(Usuario user);

    boolean existeUsuario(String username);

    boolean logIn(String user, String password);

    Usuario verPerfil(String user);

    String getNombreUsuario(String user);

    boolean addBilletera(Usuario user, BilleteraFamiliar billetera);

    boolean tieneBilletera(String user);

    boolean changePassword(Usuario user, String newPassword);

    boolean changeName(Usuario user, String newName);

    boolean changeLastName(Usuario user, String newLastName);

    boolean changeEmail(Usuario user, String newEmail);

    boolean changeSalary(Usuario user, double newSalary);

    boolean tieneSuficienteDinero(String nombre, double monto);

    boolean doLogin(Usuario user);

    boolean existeCorreo(String correo);

    List<BilleteraFamiliar> getBilleteras(Usuario user);

    boolean updateUsuario(Usuario usuarioActualizado);

    List<Solicitud> getSolicitudes(BilleteraFamiliar billetera, Usuario user);

}
