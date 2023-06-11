package com.shishir.expression.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "code", length = 7)
    private String code;
    @Column(name = "purchase_year", length = 4)
    private int purchaseYear;
    @Column(name = "type", length = 20)
    private String type;
}
