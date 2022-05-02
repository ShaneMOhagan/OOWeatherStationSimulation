package template_datetime;

public class GMT4DateTime extends ComputeDateTime {
	public GMT4DateTime() {}
	public String setTimeZone() {
		String timeZone = "GMT-4";
		return timeZone;
	}
}