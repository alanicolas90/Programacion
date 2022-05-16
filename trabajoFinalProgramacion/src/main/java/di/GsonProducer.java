package di;

import com.google.gson.*;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import gsonutils.RuntimeTypeAdapterFactory;
import jakarta.enterprise.inject.Produces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonProducer {



    @Produces
    public Gson getGson() {
        RuntimeTypeAdapterFactory<Usuario> adapterUser =
                RuntimeTypeAdapterFactory
                        .of(Usuario.class, "Usuario")
                        .registerSubtype(Usuario.class, "Usuario");

        RuntimeTypeAdapterFactory<BilleteraFamiliar> adapterProduct =
                RuntimeTypeAdapterFactory
                        .of(BilleteraFamiliar.class, "BilleteraFamiliar")
                        .registerSubtype(BilleteraFamiliar.class, "BilleteraFamiliar");


        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                                LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonSerializer<LocalDate>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .registerTypeAdapterFactory(adapterUser)
                .registerTypeAdapterFactory(adapterProduct)
                .create();

    }

}
