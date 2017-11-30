package databeans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A data model that stores the information of a call log entry.
 *
 */
public class CallInformation {
	
	private Long utcTimestamp;
	private String identity;
	private String reputation;
	private String id;
	private String termination;
	private String callDirection;
	private String phoneNumber;
	
	public CallInformation() {
		this.utcTimestamp = null;
		this.identity = null;
		this.reputation = null;
		this.id = null;
		this.termination = null;
		this.callDirection = null;
		this.phoneNumber = null;
	}
	
	/**
	 * Extract only the date portion from the timestamp.
	 * @return The time in the format of day/month/year
	 */
	public String getFormattedDate() {
		// timestamp is in milliseconds
		Date time = new Date(this.utcTimestamp * 1000);
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
		return fm.format(time);		
	}
	
	/**
	 * Extract only the time portion from the timestamp.
	 * @return The time in the format of hour:minute:second
	 */
	public String getFormattedTime() {
		// timestamp is in milliseconds
		Date time = new Date(this.utcTimestamp * 1000);
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		return fm.format(time);		
	}
	
	public long getTime() {
		return this.utcTimestamp;
	}
	
	public String getIdentity() {
		return this.identity;
	}
	
	public String getReputation() {
		return this.reputation;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getTermination() {
		return this.termination;
	}
	
	public String getCallDirection() {
		return this.callDirection;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setTime(long timeStamp) {
		this.utcTimestamp = timeStamp;
	}
	
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public void setReputation(String rep) {
		this.reputation = rep;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setTermination(String termination) {
		this.termination = termination;
	}
	
	public void setCallDirection(String dir) {
		this.callDirection = dir;
	}
	
	public void setNumber(String number) {
		this.phoneNumber = number;
	}
	
	
	
}
