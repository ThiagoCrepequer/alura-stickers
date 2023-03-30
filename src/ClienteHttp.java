import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String buscaDados(String url) {
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            return client.send(request, BodyHandlers.ofString()).body();
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
