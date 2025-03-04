// src/main/java/com/example/securingweb/model/AuthenticationResponse.java
package com.example.securingweb.model;

public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}