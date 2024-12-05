package com.example.tatjavalab5.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ro_realtors")
public class Realtor {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "percent", nullable = false)
    private Double percent;

    @Column(name = "experience", nullable = false)
    private LocalDate experience;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
