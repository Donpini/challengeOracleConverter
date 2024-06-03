package src;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrearFile {

    public void guardarJson(Object jsonArray) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("CoinExchange.json");
        escritura.write(gson.toJson(jsonArray));
        escritura.close();
    }

    public void AgregarDatosAJsonGlobal(ArrayList<String> jsonArray) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("CoinExchange.json");
        escritura.write(gson.toJson(jsonArray));
        escritura.close();

    }

}
