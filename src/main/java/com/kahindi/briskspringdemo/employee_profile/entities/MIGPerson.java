package com.kahindi.briskspringdemo.employee_profile.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "mig_person")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MIGPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mig_person_id")
    private long migPersonID;

    @Default
    @Column(name = "mig_person_uu")
    private final String migPersonUU = UUID.randomUUID().toString();

    @Column(name = "mig_person_name")
    private String migPersonName;

    @Column(name = "mig_person_company")
    private String migPersonCompany;
}
