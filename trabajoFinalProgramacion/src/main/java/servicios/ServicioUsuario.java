package servicios;

import domain.modelo.usuario.Usuario;

public interface ServicioUsuario {
    boolean registarUsuario(Usuario u);

    boolean existeUsuario(String user);

    boolean logIn(String user, String password);

    Usuario getUsuario(String user);

    String getNombreUsuario(String user);

    boolean tieneBilletera(String user);

    boolean changePassword(Usuario user, String newPassword);

    boolean changeName(Usuario user, String newName);

    boolean changeLastName(Usuario user, String newLastName);

    boolean changeEmail(Usuario user, String newEmail);

    boolean changeSalary(Usuario user, double newSalary);

    boolean tieneSuficienteDinero(String nombre, double monto);
}
