package servicios;

import dao.DaoClientesAdmin;
import modelo.Cliente;

import java.util.List;

public class ServicioClients {

    public boolean addClient(Cliente newClient) {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        boolean canBeAdded = !daoClientesAdmin.existClient(newClient.getDni());
        if (canBeAdded) {
            daoClientesAdmin.addClient(newClient);
        }
        return canBeAdded;
    }

    public boolean removeClient(String dniClient) {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        boolean exists = daoClientesAdmin.existClient(dniClient);

        if (exists) {
            daoClientesAdmin.removeClient(dniClient);
        }
        return exists;
    }

    public boolean swapNameClient(String dniClient, String nuevoNombreCliente) {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapNameClient(dniClient, nuevoNombreCliente);
        }
        return exists;
    }

    public boolean swapSurnameClient(String dniClient, String newSurnameClient) {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapSurnameClient(dniClient, newSurnameClient);
        }
        return exists;
    }

    public boolean swapDni(String dniClient, String nuevoDniCliente) {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapDni(dniClient, nuevoDniCliente);
        }
        return exists;
    }

    public List<Cliente> showListClients() {
        DaoClientesAdmin daoClientesAdmin = new DaoClientesAdmin();
        return daoClientesAdmin.verListaClientes();
    }
}
