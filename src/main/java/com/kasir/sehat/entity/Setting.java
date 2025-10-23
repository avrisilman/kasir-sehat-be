package com.kasir.sehat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_status", nullable = false)
    private String storeStatus;

    private String language;

    @Column(name = "last_backup")
    private LocalDateTime lastBackup;

    private String subscription;

}