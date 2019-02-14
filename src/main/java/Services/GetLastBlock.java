package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetLastBlock {

    public StringBuilder content;
    public BufferedReader bufferedReader;

    public void getLastBlock() {

        content = new StringBuilder();

        try {
            // create a url object
            String endpoint = "https://api.orderbook.io/info/block";
            URL url = new URL(endpoint);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");

            // wrap the urlconnection in a bufferedreader
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }

        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("/info/block = " + content);

    }
}
