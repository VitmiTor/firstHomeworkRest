package models.booker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import org.testng.asserts.SoftAssert;

public class BookerResponse {
    @JsonProperty("firstname")
    private final String firstname;
    @JsonProperty("lastname")
    private final String lastname;
    @JsonProperty("totalprice")
    private final int totalPrice;
    @JsonProperty("depositpaid")
    private final boolean depositPaid;
    @JsonProperty("additionalneeds")
    private final String additionalNeed;
    @JsonProperty("bookingdates")
    private final BookingDatesResponse bookingDates;
    private final int numberMin = 50;
    private final int numberMax = 500;

    public BookerResponse() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        totalPrice = faker.number().numberBetween(numberMin, numberMax);
        depositPaid = faker.bool().bool();
        additionalNeed = faker.animal().name();
        bookingDates = new BookingDatesResponse();
    }

    public void isEqualsTo(BookerResponse bookerResponse) {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(bookerResponse.getFirstname(), firstname);
        softAssert.assertEquals(bookerResponse.getLastname(), lastname);
        softAssert.assertEquals(bookerResponse.getTotalPrice(), totalPrice);
        softAssert.assertEquals(bookerResponse.isDepositPaid(), depositPaid);
        softAssert.assertEquals(bookerResponse.getAdditionalNeed(), additionalNeed);
        softAssert.assertEquals(bookerResponse.getBookingDates().getCheckIn(), bookingDates.getCheckIn());
        softAssert.assertEquals(bookerResponse.getBookingDates().getCheckOut(), bookingDates.getCheckOut());
        softAssert.assertAll();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public String getAdditionalNeed() {
        return additionalNeed;
    }

    public BookingDatesResponse getBookingDates() {
        return bookingDates;
    }
}
