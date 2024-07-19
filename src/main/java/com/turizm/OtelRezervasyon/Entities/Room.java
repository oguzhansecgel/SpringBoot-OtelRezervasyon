package com.turizm.OtelRezervasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "oda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="yatak_sayisi")
    private int bedCount;

    @Column(name="metrekare")
    private double squareMeters;

    @Column(name="televizyon_var_mi")
    private boolean hasTelevision;

    @Column(name="minibar_var_mi")
    private boolean hasMinibar;

    @Column(name="oyun_konsolu_var_mi")
    private boolean hasGameConsole;

    @Column(name="kasa_var_mi")
    private boolean hasSafe;

    @Column(name="projeksiyon_var_mi")
    private boolean hasProjector;

    @Column(name="fiyat")
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
