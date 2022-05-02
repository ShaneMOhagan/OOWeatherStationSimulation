package template_datetime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class ComputeDateTime {
	
	public final String createDateTime() {
		Date date = createDateObj();
		SimpleDateFormat sdf = createSDF();
		String timeZone = setTimeZone();
		convertTimeToTimezone(sdf, timeZone);
		String dateTime = convertDateTimeToString(sdf, date);
		return dateTime;
	}
	
	abstract String setTimeZone();
	
	public Date createDateObj() {
		Date date = new Date();
		return date;
	}
	
	public SimpleDateFormat createSDF() {
		SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z\"");
		return sdf;
	}
	
	public void convertTimeToTimezone(SimpleDateFormat sdf, String timeZone) {
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
	}
	
	public String convertDateTimeToString(SimpleDateFormat sdf, Date date) {
		String dateTime = sdf.format(date);
		return dateTime;
	}
}