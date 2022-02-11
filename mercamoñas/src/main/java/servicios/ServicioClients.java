package servicios;

import dao.DaoClientes;
import dao.DaoMonedero;
import modelo.Cliente;
import modelo.Monedero;

import java.util.List;


public class ServicioClients {

    public boolean addClient(Cliente newClient) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        boolean canBeAdded = !daoClientesAdmin.existClient(newClient.getDni());
        if (canBeAdded) {
            daoClientesAdmin.addClient(newClient);
        }
        return canBeAdded;
    }

    public boolean removeClient(String dniClient) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        boolean exists = daoClientesAdmin.existClient(dniClient);

        if (exists) {
            daoClientesAdmin.removeClient(dniClient);
        }
        return exists;
    }

    public boolean swapNameClient(String dniClient, String nuevoNombreCliente) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapNameClient(dniClient, nuevoNombreCliente);
        }
        return exists;
    }

    public boolean swapSurnameClient(String dniClient, String newSurnameClient) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapSurnameClient(dniClient, newSurnameClient);
        }
        return exists;
    }

    public boolean swapDni(String dniClient, String nuevoDniCliente) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        boolean exists = daoClientesAdmin.existClient(dniClient);
        if (exists) {
            daoClientesAdmin.swapDni(dniClient, nuevoDniCliente);
        }
        return exists;
    }

    public boolean existeCliente(String dniClient) {
        DaoClientes daoClientesAdmin = new DaoClientes();
        return daoClientesAdmin.existClient(dniClient);
    }

    public List<Cliente> showListClients() {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.verListaClientes();
    }

    public boolean addMoney(String dniCliente, String nombreTarjeta, double dineroAgregar) {
        DaoClientes daoClientes = new DaoClientes();
        DaoMonedero daoMonedero = new DaoMonedero();
        boolean exists = daoMonedero.monederoExists(nombreTarjeta);
        if (exists)
            daoClientes.addMoney(dniCliente, nombreTarjeta, dineroAgregar);
        return exists;
    }

    public boolean addMonedero(Monedero monedero) {
        DaoMonedero daoMonedero = new DaoMonedero();
        boolean canBeAdded = !daoMonedero.monederoExists(monedero.getName());
        if (canBeAdded) {
            daoMonedero.addMonedero(monedero);
        }
        return canBeAdded;
    }

    public List<Cliente> showSpecificClient(String dniClient) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.seeSpecificClient(dniClient);
    }

    public boolean removeMonedero(String nombreMonedero) {
        DaoMonedero daoMonedero = new DaoMonedero();
        boolean exists = daoMonedero.monederoExists(nombreMonedero);
        if (exists) {
            daoMonedero.removeMonedero(nombreMonedero);
        }
        return exists;
    }
}
