
package live.switchly.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestApi {

    public static void main(String[] args) throws Exception {

        String projectId =
                "c248bd16-86f5-4ebc-848a-845ba1910cc8";

        String fakeFlagId =
                "11111111-1111-1111-1111-111111111111";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/api/projects/"
                                + projectId + "/flags/"
                                + fakeFlagId + "?enabled=true"))
                .method("PATCH", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status: " + response.statusCode());
        System.out.println(response.body());
    }
}
