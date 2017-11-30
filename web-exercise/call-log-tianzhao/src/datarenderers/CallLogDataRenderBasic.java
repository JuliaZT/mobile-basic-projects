package datarenderers;

import javax.servlet.http.HttpServletRequest;

import databeans.CallInformation;

/**
 * A data renderer that displays up to 10 most recent call information.
 *
 */
public class CallLogDataRenderBasic implements CallLogDataRender {
	
	private final String basicJSP = "CallLogList.jsp";
	
	public CallLogDataRenderBasic() {
		
	}
	
	public String getJSP() {
		return basicJSP;
	}
	
	public void attachJavaBeans(HttpServletRequest request,
			                                  CallInformation[] recentCallLog) {
		request.setAttribute("data", recentCallLog);
		
	}
	
	
}
