package com.turizm.OtelRezervasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otel_ozellikler")
@Entity
public class HotelFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ucretsiz_otopark_var_mi")
    private boolean hasFreeParking;

    @Column(name="ucretsiz_wifi_var_mi")
    private boolean hasFreeWiFi;

    @Column(name="yuzme_havuzu_var_mi")
    private boolean hasSwimmingPool;

    @Column(name="fitness_center_var_mi")
    private boolean hasFitnessCenter;

    @Column(name="hotel_concierge_var_mi")
    private boolean hasHotelConcierge;

    @Column(name="spa_var_mi")
    private boolean hasSPA;

    @Column(name="oda_servisi_7_24_var_mi")
    private boolean hasRoomService24_7;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
