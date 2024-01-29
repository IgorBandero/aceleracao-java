package com.holidays.api.controllers;

import com.holidays.api.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping({"/holidays", "/holidays/"})
public class HolidaysController {
    
    @GetMapping({"", "/"})
    public String getHolidaysList() {
        List<Date> holidays = new ArrayList<>();
        holidays = createHolidaysList();        
        return printHolidays(holidays);
    }

    @GetMapping("/{date}")
    public String checkHoliday(@PathVariable String date) {
        List<Date> holidays = new ArrayList<>();
        holidays = createHolidaysList();
        return isHoliday(date, holidays);
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

    public static String printHolidays(List<Date> holidays){        
        String message = "";
        for(int i=0; i<holidays.size(); i++){
            Date holiday = holidays.get(i);
            message = message + holiday.getFullDate() + "\n";
        }
        return message;
    }

    public static String isHoliday(String fullDate, List<Date> holidays){
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
