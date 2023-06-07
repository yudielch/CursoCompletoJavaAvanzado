package cursocompletojavaavanzado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
//        Download WEBs
        String link="https://www.bbc.com";
        URL url = new URL(link);
        HttpURLConnection conn= (HttpURLConnection)url.openConnection();
        String encoding = conn.getContentEncoding();
        
        InputStream input=conn.getInputStream();
        String result= new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining());
    }


}
