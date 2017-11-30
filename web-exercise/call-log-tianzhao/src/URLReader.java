import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A URLReader that fetches data from a given url string.
 *
 */
public class URLReader {

	/**
	 * Given a url string, fetch data from this url.
	 * @param urlString A url to read data from
	 * @return the fetched data as a String
	 * @throws IOException when the URLReader failed to fetch data from the url
	 */
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
