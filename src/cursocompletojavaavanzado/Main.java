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
// 1 ns = 1x10 a la 9
// 60768452900 ns = 6,0 s
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com");
        links.add("https://www.bbc.com/new/uk-61196071");
        links.add("https://www.bbc.com/sport/formula1/61192154");

        links.stream().parallel().forEach(link -> getWebContent(link));
        String link = "https://www.bbc.com";
        String result = getWebContent(link);

    }

    private synchronized static String getWebContent(String link) {

        System.out.println("INT");
        System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();
            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
            System.out.println("END");
            String result = lines.collect(Collectors.joining());
            return result;
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
    return "";
    }

}
