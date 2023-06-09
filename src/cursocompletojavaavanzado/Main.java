package cursocompletojavaavanzado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {

//        Download WEBs
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com");
        links.add("https://www.bbc.com/new/uk-61196071");
        links.add("https://www.bbc.com/sport/formula1/61192154");

        Long timeStart = System.nanoTime();
        links.stream().forEach(link -> getWebContent(link));
        Long timeEnd = System.nanoTime();
        System.out.println("Difference: " + (timeEnd - timeStart));

        timeStart = System.nanoTime();
        links.stream().parallel().forEach(link -> getWebContent(link));
        timeEnd = System.nanoTime();
        System.out.println("Difference: " + (timeEnd - timeStart));

        String link = "https://www.bbc.com";

        String result = getWebContent(link);

    }

    private static String getWebContent(String link) {

        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();
            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
            String result = lines.collect(Collectors.joining());
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
