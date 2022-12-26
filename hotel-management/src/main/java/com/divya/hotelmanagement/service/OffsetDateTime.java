package com.divya.hotelmanagement.service;

import java.time.format.DateTimeFormatter;

public class OffsetDateTime {
    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2020-03-25T00:00:00.000Z",
                DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.System.out.println(offsetDateTime);
    }

}
