package models.booker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookerCreateResponse {
    @JsonProperty("bookingid")
    private String bookingID;
    @JsonProperty("booking")
    private BookerResponse bookerResponse;

    public String getBookingID() {
        return bookingID;
    }

    public BookerResponse getBookerResponse() {
        return bookerResponse;
    }
}
