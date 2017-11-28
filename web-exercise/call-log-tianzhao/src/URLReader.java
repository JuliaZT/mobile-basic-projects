import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {

    public static String fetchText(String urlString) throws IOException{
		
		URL url = new URL(urlString);
		StringBuilder sB = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
				
		String line;
		while ((line = rd.readLine()) != null) {
			sB.append(line);
		}
		rd.close();
		return sB.toString();
	}
}
