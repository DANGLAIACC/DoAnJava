package GiaoDien;

import java.util.concurrent.TimeUnit;

public class Test3 {
	public static void main(String[] args) {
		long millis = 3600000;// = 60*60000
	    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
	    System.out.println(hms);
	    
//	    long seconds = millis;
//	    long s = seconds % 60;
//	    long m = (seconds / 60) % 60;
//	    long h = (seconds / (60 * 60)) % 24;
//	  	System.out.println(String.format("%d:%02d:%02d", h,m,s));
	}
}
