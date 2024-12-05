package com.example.tatjavalab5.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ro_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "pid")
    private Integer pid;

    @ColumnDefault("0")
    @Column(name = "balance")
    private Double balance;

    @Column(name = "time")
    private Instant time;

    @OneToMany(mappedBy = "seller")
    private Set<Estate> roEstates = new LinkedHashSet<>();

    public User(String name, String email, String password, String birthday, String pid, double balance) {
        this.name = name;
        this.mail = email;
        this.password = password;
        this.birthday = LocalDate.parse(birthday);
        this.pid = Integer.parseInt(pid);
        this.balance = balance;
    }
}