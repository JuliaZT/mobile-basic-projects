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
