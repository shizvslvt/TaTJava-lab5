package com.example.tatjavalab5.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ro_estates")
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realtor_id")
    private Realtor realtor;

    @Lob
    @Column(name = "title", nullable = false)
    private String title;

    @ColumnDefault("0")
    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "time", nullable = false)
    private Instant time;

    @Column(name = "accepted")
    private Instant accepted;

    @ColumnDefault("0")
    @Column(name = "archived", nullable = false)
    private Integer archived;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("0")
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("0")
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("0")
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ColumnDefault("0")
    @Column(name = "area", nullable = false)
    private Double area;

    @ColumnDefault("0")
    @Column(name = "bedrooms", nullable = false)
    private Integer bedrooms;

    @ColumnDefault("0")
    @Column(name = "floors", nullable = false)
    private Integer floors;

}