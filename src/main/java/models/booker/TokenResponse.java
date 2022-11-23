package models.booker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {
    @JsonProperty("token")
    private String token;
}
