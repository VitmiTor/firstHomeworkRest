package models.booker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenBody {
    @JsonProperty("username")
    private final String username;
    @JsonProperty("password")
    private final String password;

    public TokenBody() {
        this.username = "admin";
        this.password = "password123";
    }


}
