package holidays;

import java.time.LocalDate;

public class Holiday {

    private LocalDate date;
    private String holidayName;

    public Holiday(LocalDate date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }



    public LocalDate getDate() {
        return date;
    }
    public String getHolidayName() {
        return holidayName;
    }

    @Override
    public String toString() {
        return "This year " + holidayName + " is celebrated on " + date;
    }


}