package info.sjd;

//import java.io.Serializable;

public class LogRec {//implements Serializable{
	/**
	 * 
	 */
	
	
	//private static final long serialVersionUID = 340414075615808978L;
	private long time_stamp;
	private String session;
	private String ip;
	
	public LogRec() {
	}
	
	public LogRec(long time_stamp, String session, String ip) {
		this.time_stamp = time_stamp;
		this.session = session;
		this.ip = ip;
	}
	

	
	public LogRec(String line) {
		
		String[] words = line.split(" ");
		
		
		
		//Set three variables.
		long time_stamp = 0;
		String session = "UNDEFINED";
		String ip = "UNDEFINED";
		
		try {
			this.time_stamp = Long.parseLong(words[0]);
		}
		catch (Exception e) {
//			this.time_stamp = 0;
		}
		try {
			this.session = words[1];
		}
		catch (Exception e) {
		}
		try {
			this.ip = words[2];
		}
		catch (Exception e) {
		}					
		

/*		this.time_stamp = time_stamp;
		this.session = session;
		this.ip = ip;*/
	}
	
	//////////////////////////
	public String getString() {
		String sb = Long.toString(time_stamp)+" "+
					session+" "+
					ip;
		return sb;
	}
	
	public long getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(long time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
