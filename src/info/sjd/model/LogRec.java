package info.sjd.model;

public class LogRec {

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

		/** Parse three variables.*/
		try {
			this.time_stamp = Long.parseLong(words[0]);
		} catch (Exception e) {
			this.time_stamp = 0;
		}
		try {
			this.session = words[1];
		} catch (Exception e) {
			this.session = "UNDEFINED";
		}
		try {
			this.ip = words[2];
		} catch (Exception e) {
			this.ip = "UNDEFINED";
		}
	}
	
	@Override
	public String toString() {
		return Long.toString(time_stamp) + " " + session + " " + ip;
	}
	
	
	public String getString() {
		String sb = Long.toString(time_stamp) + " " + session + " " + ip;
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
