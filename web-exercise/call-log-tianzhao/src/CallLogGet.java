

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class CallLogGet
 */
@WebServlet("/CallLogGet")
public class CallLogGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String URL_STRING = "http://localhost:3000/call_log";
	private static final int CALL_DATA_NUM = 10;
	
	private static final String FIELD_TIME = "utcTimestamp";
	private static final String FIELD_IDENTITY = "identity";
	private static final String FIELD_REP = "reputation";
	private static final String FIELD_ID = "id";
	private static final String FIELD_TERM = "termination";
	private static final String FIELD_DIR = "callDirection";
	private static final String FIELD_NUM = "phone";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from server
		CallInformation[] recentCallLog = fetchCallLogData();
		
		/**
		for (CallInformation c : recentCallLog) {
			if (c.getIdentity() != null) {
			    System.out.println(c.getIdentity());
			}
	    }*/
		
		// display data on the web page
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
	}
	
	public static String fetchText() throws IOException{
		
		URL url = new URL(URL_STRING);
		StringBuilder sB = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
				
		String line;
		while ((line = rd.readLine()) != null) {
			sB.append(line);
		}
		rd.close();
		return sB.toString();
	}
	
	private CallInformation[] fetchCallLogData(){
		try {
			JSONArray array = new JSONArray(fetchText());
			int callNum = Math.min(CALL_DATA_NUM, array.length());
			CallInformation[] recentCallLog = new CallInformation[callNum];
			for (int i = 0; i < callNum; i++) {
				JSONObject obj = array.getJSONObject(i);
				recentCallLog[i] = parseCallDataFromJSON(obj);
			}
			return recentCallLog;
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	private CallInformation parseCallDataFromJSON(JSONObject obj) {
		Long time = obj.getLong(FIELD_TIME);
		String id = obj.getString(FIELD_ID);
		String term = obj.getString(FIELD_TERM);
		String dir = obj.getString(FIELD_DIR);
		String num = obj.getString(FIELD_NUM);
		
		CallInformation thisCall = new CallInformation();
		thisCall.setTime(time);
		thisCall.setID(id);
		thisCall.setTermination(term);
		thisCall.setCallDirection(dir);
		thisCall.setNumber(num);
		
		String identity;
		String rep;
		try {
		  identity = obj.getString(FIELD_IDENTITY);
		  thisCall.setIdentity(identity);
		} catch (JSONException e) {
			// this caller does not have an identity
		}
		
		try {
			rep = obj.getString(FIELD_REP);
			thisCall.setReputation(rep);
		} catch (JSONException e){
			// this call data does not have reputation field
		}
		return thisCall;
	}

}
