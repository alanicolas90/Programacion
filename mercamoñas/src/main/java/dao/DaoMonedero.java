package dao;

import modelo.Monedero;

import static dao.BBDD.monederos;

public class DaoMonedero {

    public boolean monederoExists(String nombreMonedero){
        return monederos.contains(new Monedero(nombreMonedero));
    }

    public void addMonedero(Monedero monedero){
        monederos.add(new Monedero(monedero.getName(), monedero.getMoney()));
    }

    public void removeMonedero(String nombreMonedero){
        monederos.remove(new Monedero(nombreMonedero));
    }

}
