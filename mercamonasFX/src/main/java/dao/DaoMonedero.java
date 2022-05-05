package dao;

import domain.modelo.cliente.Monedero;

import java.util.Set;

public interface DaoMonedero {
    boolean monederoExists(String nombreMonedero, String dniClient);

    boolean addMonedero(Monedero monedero, String dniClient);

    boolean addMoneyMonedero(String dniCliente, String nombreMonedero, double quantity);

    boolean removeMonedero(String dniClient, String nombreMonedero);

    Set<Monedero> showTarjetasCliente(String dniClient);
}
