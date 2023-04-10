/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 *
 * @author kurtm
 */
public class Validator {

    public Validator() {

    }

    public boolean checkIfDate(String date) {
        if (date.equals("") || date == null) {
            return false;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                LocalDate ld = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid");
                return false;
            }
            return true;
        }
    }

    public boolean checkStartEndDate(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lds = LocalDate.parse(startDate, formatter);
        LocalDate lde = LocalDate.parse(endDate, formatter);
        LocalDate now = LocalDate.now();
        if (lds.isAfter(lde)) {
            return false;
        } else if (lds.isBefore(now)) {
            return false;
        } else if (lds.isEqual(now)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isIntegerGreaterZero(String numOfPart) {
        try {
            int i = Integer.parseInt(numOfPart);
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public boolean checkIfDateTime(String date) throws ParseException {
        if (date.equals("") || date == null) {
            return false;
        } else {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            try {
                Date date1 = formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
    }

    public boolean checkIfDateTimeWithin(String start, String date, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDate d = LocalDate.parse(date, formatter2);
        LocalDate s = LocalDate.parse(start, formatter);
        LocalDate e = LocalDate.parse(end, formatter);

        if (d.isBefore(s)) {
            return false;
        }
        if (d.isAfter(e)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkStartEndDateTime(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime lds = LocalDateTime.parse(startDate, formatter);
        LocalDateTime lde = LocalDateTime.parse(endDate, formatter);
        if (lds.isAfter(lde)) {
            return false;
        } else {
            return true;
        }
    }
}
