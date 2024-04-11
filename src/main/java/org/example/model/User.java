package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;

    @OneToOne(cascade = {
           CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE,
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id")
          Passport passport;

            public User(String name, String lastName,Passport passport) {
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;
    }
}
