package transcripts;

import com.google.gson.Gson;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) throws Exception {
        transcripts.Transcript transcript = new transcripts.Transcript();
        transcript.setAudio_url("https://bit.ly/3yxKEIY");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", "5e57e570a5584b5685b1d488d8a9a574")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());
        transcript = gson.fromJson(postResponse.body(), transcripts.Transcript.class);
        System.out.println(transcript.getId());

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", "5e57e570a5584b5685b1d488d8a9a574")
                .build();
        while (true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getResponse.body(), transcripts.Transcript.class);
            System.out.println(transcript.getStatus());
            if("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())){
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("Transcription completed!");
        System.out.println(transcript.getText());

        }

    }

