package datarenderers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import databeans.CallInformation;

public class CallLogDataRenderByDate implements CallLogDataRender {
	
	private final String JSP = "CallLogListByDate.jsp";
	
	public CallLogDataRenderByDate() {
		
	}
	
	public String getJSP() {
		return JSP;
	}
	
	public void attachJavaBeans(HttpServletRequest request,
			                                  CallInformation[] recentCallLog) {
		
		request.setAttribute("data", categorizeDataByDate(recentCallLog));
		
	}
	
	private List<List<CallInformation>> categorizeDataByDate(CallInformation[] recentCallLog) {
			
		List<List<CallInformation>> categorizedCalls = new ArrayList<>();
		if (recentCallLog.length == 0)
			return categorizedCalls;
		
		List<CallInformation> callsOnCurrentDay = new ArrayList<>();
		
		Date previousCall = null;
		for (int i = 0; i < recentCallLog.length; i++) {
			Date thisCall = new Date(recentCallLog[i].getTime() * 1000);
			if (previousCall != null && (!isSameDay(previousCall, thisCall))) {
				categorizedCalls.add(callsOnCurrentDay);
				callsOnCurrentDay = new ArrayList<>();
			}
			callsOnCurrentDay.add(recentCallLog[i]);
			previousCall = thisCall;
		}
		categorizedCalls.add(callsOnCurrentDay);
		return categorizedCalls;
	}
	
	private boolean isSameDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		
		return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) &&
				(c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR));
		
	}
	
	
}
