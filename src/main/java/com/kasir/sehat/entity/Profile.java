package com.kasir.sehat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {
    @Id
    @Column(name = "cashier_id", length = 20)
    private String cashierId;

    @Column(nullable = false, length = 100)
    private String shop;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "img_cashier")
    private String imgCashier;

    private String role;

    @Column(name = "shift_date")
    private LocalDate shiftDate;

    @Column(name = "shift_start")
    private LocalTime shiftStart;

    @Column(name = "shift_end")
    private LocalTime shiftEnd;

    @Column(name = "shift_status")
    private Boolean shiftStatus;
}
