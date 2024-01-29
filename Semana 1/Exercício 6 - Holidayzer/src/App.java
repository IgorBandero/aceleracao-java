import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        List<Date> holidays = new ArrayList<>();
        holidays = createHolidaysList();
        System.out.print("\nInforme uma data no formato dd-mm-aaaa: ");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        scanner.close();   
        System.out.println(checkHoliday(date, holidays));
        printHolidays(holidays);
    }

    public static List<Date> createHolidaysList(){        
        List<Date> holidays = new ArrayList<>();
        holidays.add(new Date("01-01-2024", true, "Confraternização Mundial"));
        holidays.add(new Date("12-02-2024", true, "Carnaval"));
        holidays.add(new Date("13-02-2024", true, "Carnaval"));
        holidays.add(new Date("29-03-2024", true, "Sexta-feira Santa"));
        holidays.add(new Date("21-04-2024", true, "Tiradentes"));
        holidays.add(new Date("01-05-2024", true, "Dia do Trabalho"));
        holidays.add(new Date("30-05-2024", true, "Corpus Christi"));
        holidays.add(new Date("07-09-2024", true, "Independência do Brasil"));
        holidays.add(new Date("12-10-2024", true, "Nossa Senhora Aparecida"));
        holidays.add(new Date("02-11-2024", true, "Finados"));
        holidays.add(new Date("15-11-2024", true, "Proclamação da República"));
        holidays.add(new Date("20-11-2024", true, "Dia Nacional de Zumbi e da Consciência Negra"));
        holidays.add(new Date("25-12-2024", true, "Natal"));
        return holidays;
    }

    public static void printHolidays(List<Date> holidays){
        System.out.print("\n");
        for(int i=0; i<holidays.size(); i++){
            Date holiday = holidays.get(i);
            System.out.println(holiday.getFullDate());
        }
        System.out.print("\n");
    }

    public static String checkHoliday(String fullDate, List<Date> holidays){
        Date holiday;
        for(int i=0; i<holidays.size(); i++){
            holiday = holidays.get(i);
            if (holiday.getDate().equals(fullDate)){
                return "\nDia " + fullDate + " é feriado! " + "\uD83C\uDF89";
            }
        }
        return "\nDia " + fullDate + " não é feriado " + "\uD83D\uDE22";
    }

}
