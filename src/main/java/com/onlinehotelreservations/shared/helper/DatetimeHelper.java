package com.onlinehotelreservations.shared.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatetimeHelper {
    public static LocalDate getLocalDateFromDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
