package src;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

public class APITAKE {

    public Moneda monedaEnApi(String tasaInicio, String tasaCambio, Double cantidad) throws UnsupportedEncodingException {

        String tasaInicioEncoded = URLEncoder.encode(tasaInicio, "UTF-8");
        String tasaCambioEncoded = URLEncoder.encode(tasaCambio, "UTF-8");

        String url = "https://v6.exchangerate-api.com/v6/0fb43c50a6e6ef7c14ec4f45/pair/" + tasaInicioEncoded + "/" + tasaCambioEncoded + "/" + cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Moneda tasa = gson.fromJson(response.body(), Moneda.class);
            return tasa;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Eleccion Invalida");
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa Moneda, Vuelve a intentarlo");
        }

    }
}
