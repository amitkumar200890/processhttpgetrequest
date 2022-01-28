package com.apiprocess.utility;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.net.URI;

public class utilityThread implements Runnable{
    private String uniqueId;

    public utilityThread(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public void run() {
        callApi(uniqueId);
    }

    private void callApi(String uniqueId) {
        // Base64encoding for Authorisation
        String encoded = new String(Base64.getEncoder().encode(uniqueId.getBytes()));

        // Create authorization header
        String authorizationHeader = "Authorization: " + encoded;

        // create http client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP request object
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://challenges.qluv.io/items/"+uniqueId))
                .GET()
                .header("Authorization", encoded)
                .header("Content-Type", "application/text")
                .build();

        // Send HTTP request
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // update value in HashMap for output
            System.out.println("response.statusCode(): "+response.statusCode());
            if(response.statusCode() == 200)
                ProcessApiRequest.hMap.put(uniqueId, response.body());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
