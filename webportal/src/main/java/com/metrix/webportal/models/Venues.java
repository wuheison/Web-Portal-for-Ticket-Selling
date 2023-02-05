package com.metrix.webportal.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
// 1. Annotation for indicating this is an entity class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venues implements Serializable {
    // 2. Annotation for indicating this field is a primary key of the class
    // 3. Annotation for indicating this field will auto generate seq. number when
    // insert into DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 4a. Annotation for checking this field is not blank, if blank, view will show
    // error message "Name must be provided!"
    // 5a. Annotation for checking this field cannot exceed 100 characters, if not,
    // view will show error message "Name must less than 100 characters!"
    // 6a. Annotation indicating this field in DB is not nullable
    @NotBlank(message = "Name must be provided!")
    @Size(max = 100, message = "Name must less than 100 characters!")
    @Column(length = 100, nullable = false)
    private String venueName;

    // 4b. Annotation for checking this field is not blank, if blank, view will show
    // error message "Address must be provided!"
    // 5b. Annotation for checking this field cannot exceed 255 characters, if not,
    // view will show error message "Address must less than 255 characters!"
    // 6b. Annotation indicating this field in DB is not nullable and a unique field
    @NotBlank(message = "Address must be provided!")
    @Size(max = 255, message = "Name must less than 100 characters!")
    @Column(length = 255, nullable = false, unique = true)
    private String venueAddr;

    // 7. Annotation for checking minimum value = 1, if not, view will show error
    // message "Number of least must at least 1"
    // 8. Annotation for checking maximum value = 100, if not, view will show error
    // message "Number of least must less than 100"
    // to prevent the do while of generating unique qr code long run
    // 6c. Annotation indicating this field in DB is not nullable
    @Min(value = 1, message = "Number of least must at least 1")
    @Max(value = 100, message = "Number of least must less than 100")
    @Column(nullable = false)
    private int numberOfSeat;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Events> events = new ArrayList<>();
}
