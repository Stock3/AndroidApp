package com.example.loginapp.Model;

public class AuthenticationTokenDto {
    private String jwtToken;
    private String tokenType = "Bearer";

    public AuthenticationTokenDto() {
    }

    public AuthenticationTokenDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
