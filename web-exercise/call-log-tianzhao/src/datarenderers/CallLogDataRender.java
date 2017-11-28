package datarenderers;

import javax.servlet.http.HttpServletRequest;

import databeans.CallInformation;

/**
 * Allow different data visualization of the call log data.
 */
public interface CallLogDataRender {
	
	/**
	 * Specify the certain JSP used to render the call log data.
	 * @return
	 */
	public String getJSP();
	
	/**
	 * Attach the java beans as request attributes.
	 * @param request The request sent to CallLogGet servlet
	 * @param recentCallLog The information fetched from the server
	 */
	public void attachJavaBeans(HttpServletRequest request,
			                    CallInformation[] recentCallLog);

}
