package models.booker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDatesResponse {
    @JsonProperty("checkin")
    private final String checkIn;
    @JsonProperty("checkout")
    private final String checkOut;

    public BookingDatesResponse() {
        checkIn = "2018-08-09";
        checkOut = "2019-07-11";
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
}
