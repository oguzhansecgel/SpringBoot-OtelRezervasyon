package com.turizm.OtelRezervasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rezervasyonlar")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "musteri_adi")
    private String customerName;
    @Column(name = "musteri_soyadi")
    private String customerSurname;
    @Column(name = "musteri_tc_no")
    private String customerIdentityNo;
    @Column(name = "yetiskin_sayisi")
    private int adultCount;
    @Column(name = "cocuk_sayisi")
    private int childCount;
    @Column(name = "toplam_fiyat")
    private double totalPrice;
    @Column(name = "giris_tarihi")
    private LocalDate checkIn;
    @Column(name = "cikis_tarihi")
    private LocalDate checkOut;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
