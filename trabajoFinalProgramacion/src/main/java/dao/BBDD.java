package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
public class BBDD {

    private final Gson gson;

    private Configuration configuration;


    @Inject
    public BBDD(Gson gson, Configuration configuration) {
        this.gson = gson;
        this.configuration = configuration;
    }


//          USUARIO          USUARIO          USUARIO          USUARIO          USUARIO

    public Map<String, Usuario> loadUsers() {
        Type userListType = new TypeToken<LinkedHashMap<String, Usuario>>() {
        }.getType();
        LinkedHashMap<String, Usuario> usuarios = null;
        try {
            usuarios = gson.fromJson(
                    new FileReader(Configuration.getInstance().getUsuariosSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return usuarios;
    }

    public boolean saveUsers(Map<String, Usuario> usuarios) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getUsuariosSource())) {
            gson.toJson(usuarios, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

//          Billetera          Billetera          Billetera          Billetera          Billetera

    public Map<String, BilleteraFamiliar> loadBilletera() {
        Type userListType = new TypeToken<LinkedHashMap<String, BilleteraFamiliar>>() {
        }.getType();
        LinkedHashMap<String, BilleteraFamiliar> billeteras = null;
        try {
            billeteras = gson.fromJson(
                    new FileReader(Configuration.getInstance().getBilleterasSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return billeteras;
    }

    public boolean saveBilletera(Map<String, BilleteraFamiliar> billeteras) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getBilleterasSource())) {
            gson.toJson(billeteras, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
