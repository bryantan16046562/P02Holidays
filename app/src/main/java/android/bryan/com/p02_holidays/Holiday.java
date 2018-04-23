package android.bryan.com.p02_holidays;

public class Holiday {
    private String holidayname;
    private String holidaydate;

    public Holiday(String holidayname, String holidaydate) {
        this.holidayname = holidayname;
        this.holidaydate = holidaydate;
    }
    public String getName() {
        return holidayname;
    }
    public String getDate() {
        return holidaydate;
    }
}
