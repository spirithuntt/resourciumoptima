package com.resourciumoptima.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "equipement_id", referencedColumnName = "id")
    private Equipement equipement;

}
