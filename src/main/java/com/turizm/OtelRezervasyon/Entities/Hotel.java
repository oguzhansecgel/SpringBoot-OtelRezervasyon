package com.turizm.OtelRezervasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "oteller")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="otel_adi")
    private String hotelName;

    @Column(name = "adres")
    private String adress;

    @Column(name="email")
    private String email;

    @Column(name="telefon")
    private String phoneNumber;

    @Column(name="yildiz")
    private int stars;

    @Enumerated(EnumType.STRING) // veri tabanında enumu string olarak getirir enumun sayısı olarak değil.
    @Column(name="pansiyon_tipi")
    private HotelType hotelType;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY) // orphanRemoval = true bir çocuk entity, ilişkili olduğu ebeveyn entity'den çıkarıldığında, bu çocuk entity veritabanından da silinir.
    private List<Room> rooms= new ArrayList<>();

}
