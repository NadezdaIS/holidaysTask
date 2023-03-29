import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Holiday> holidaysLV = new ArrayList<>();

        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JANUARY, 1), "New Year's Day"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.APRIL, 7), "Good Friday"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.APRIL, 10), "Easter Monday"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.MAY, 1), "Labour Day"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.MAY, 4), "Restoration of Independence Day"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JUNE, 24), "Midsummer's Eve"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JUNE, 23), "Midsummer's Day"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.NOVEMBER, 18), "Proclamation Day of the Republic of Latvia"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 24), "Christmas Eve"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 25), "Christmas Day"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 26), "Second Day of Christmas"));
        holidaysLV.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 31), "New Year's Eve"));

        ArrayList<Holiday> holidaysLT = new ArrayList<>();

        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JANUARY, 1), "New Year's Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.FEBRUARY, 16), "Day of Restoration of the State of Lithuania"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.MARCH, 11), "Day of Restoration of Independence of Lithuania"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.APRIL, 9), "Easter Sunday"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.APRIL, 10), "Easter Monday"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.MAY, 1), "International Workers' Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.MAY, 7), "Mother's Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JUNE, 4), "Father's Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JUNE, 24), "St. John's Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.JULY, 6), "Statehood Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.AUGUST, 15), "Assumption Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.NOVEMBER, 1), "All Saints' Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.NOVEMBER, 2), "All Souls' Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 24), "Christmas Eve"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 25), "Christmas Day"));
        holidaysLT.add(new Holiday(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 26), "Second Day of Christmas"));

        System.out.println("Please enter the country:");
        Scanner scanner = new Scanner(System.in);
        String choiceOfCountry = scanner.nextLine().toLowerCase().trim();
        System.out.println("Please choose the month");
        String choiceMonth = scanner.nextLine();
        Month month = Month.valueOf(choiceMonth.toUpperCase());

        if (choiceOfCountry.equals("latvia")) {
            ArrayList<Holiday> chosenHoliday = new ArrayList<>();
            for (Holiday currentHoliday : holidaysLV) {
                if (currentHoliday.getDate().getMonth() == month) {
                    chosenHoliday.add(currentHoliday);
                }
            }
            System.out.println(chosenHoliday);

        } else if (choiceOfCountry.equals("lithuania")) {
            ArrayList<Holiday> chosenHoliday = new ArrayList<>();
            for (Holiday currentHoliday : holidaysLT) {
                if (currentHoliday.getDate().getMonth() == month) {
                    chosenHoliday.add(currentHoliday);
                }
            }
            System.out.println(chosenHoliday);

        } else {
            System.out.println("Wrong country entered, choose between Latvia and Lithuania!");
        }

    }
}