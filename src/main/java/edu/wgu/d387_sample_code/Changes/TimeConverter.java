package edu.wgu.d387_sample_code.Changes;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeConverter {

    public String convert() {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZoneId central = ZoneId.of("Universal");
        ZoneId mountain = ZoneId.of("America/Denver");

        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zoneDateTimeCentral = zonedDateTime.withZoneSameInstant(central);
        ZonedDateTime zoneDateTimeMountain = zonedDateTime.withZoneSameInstant(mountain);
        LocalDateTime localDateTimeCentral = zoneDateTimeCentral.toLocalDateTime();
        LocalDateTime localDateTimeMountain = zoneDateTimeMountain.toLocalDateTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedET = localDateTime.format(formatter);
        String formattedUTC = localDateTimeCentral.format(formatter);
        String formattedMT = localDateTimeMountain.format(formatter);

        return formattedET + " ET | " + formattedUTC + " UTC | " + formattedMT + " MT";

    }
}
