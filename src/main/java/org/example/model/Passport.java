package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passports")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "passport_type")
    String passportType;
    @Column(name = "unique_number")
    int uniqueNumber;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    }, mappedBy = "passport")
    User user;

    public Passport(String passportType, int uniqueNumber) {
        this.passportType = passportType;
        this.uniqueNumber = uniqueNumber;
    }
}
