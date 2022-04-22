package di;

import com.google.gson.*;
import gsonutils.RuntimeTypeAdapterFactory;
import jakarta.enterprise.inject.Produces;
import modelo.cliente.Cliente;
import modelo.cliente.ClienteDescuento;
import modelo.cliente.ClienteNormal;
import modelo.producto.Producto;
import modelo.producto.ProductoCaducable;
import modelo.producto.ProductoNormal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonProducer {



    @Produces
    public Gson getGson() {
        RuntimeTypeAdapterFactory<Cliente> adapterClient =
                RuntimeTypeAdapterFactory
                        .of(Cliente.class, "type", true)
                        .registerSubtype(ClienteNormal.class)
                        .registerSubtype(ClienteDescuento.class);

        RuntimeTypeAdapterFactory<Producto> adapterProduct =
                RuntimeTypeAdapterFactory
                        .of(Producto.class, "type", true)
                        .registerSubtype(ProductoNormal.class)
                        .registerSubtype(ProductoCaducable.class);


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
                .registerTypeAdapterFactory(adapterClient)
                .registerTypeAdapterFactory(adapterProduct)
                .create();

    }

}
