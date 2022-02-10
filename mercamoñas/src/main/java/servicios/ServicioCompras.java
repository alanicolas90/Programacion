package servicios;

import dao.DaoCompras;
import modelo.LineaCompra;

import java.util.List;

public class ServicioCompras {

    public List<List<LineaCompra>> showBuyHistory() {
        DaoCompras daoCompras = new DaoCompras();
        return daoCompras.showBuyHistory();
    }
}
