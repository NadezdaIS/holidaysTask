package holidaysAPI;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first country code (e.g. US): ");
        String country1 = scanner.nextLine();
        System.out.print("Enter month (e.g. 01 for January): ");
        String month = scanner.nextLine();

        try {
            List<String> holidays = HolidayFinder.findHolidays(country1, month);
            System.out.println("Holidays in " + country1 + " in " + month + ":");
            for (String holiday : holidays) {
                System.out.println("- " + holiday);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
