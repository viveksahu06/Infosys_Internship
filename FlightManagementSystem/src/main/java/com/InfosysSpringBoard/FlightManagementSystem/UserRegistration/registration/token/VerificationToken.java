package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration.token;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.CallableStatement;
import java.util.Calendar;
import java.util.Date;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;
    private static final int EXPIRATION_TIME_MINUTES = 15; // Renamed for clarity

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expirationTime = calculateExpirationTime();
    }

    public VerificationToken(String token) {
        this.token = token;
        this.expirationTime = calculateExpirationTime();
    }

    private Date calculateExpirationTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME_MINUTES);
        return calendar.getTime();
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public User getUser() {
        return user;
    }
    // Other getters and setters
}

