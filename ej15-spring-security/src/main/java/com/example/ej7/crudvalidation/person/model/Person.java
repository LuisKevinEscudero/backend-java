package com.example.ej7.crudvalidation.person.model;

import com.example.ej7.crudvalidation.stringSecuenceGenerator.PersonSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.Parameter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPerson")
    @GenericGenerator(name = "idPerson",
            strategy = "com.example.ej7.crudvalidation.stringSecuenceGenerator.PersonSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "person"),
                    @Parameter(name = PersonSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idPerson;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false)
    private String companyEmail;

    @Column(nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String city;

    @Column//(nullable = false)
    private Boolean active;

    @Column//(nullable = false)
    private Date createdDate;

    @Column
    private String imageUrl;

    @Column
    private Date terminationDate;

    @Column(nullable = false)
    private Boolean admin;

    public boolean getActive() {
        return this.active;
    }
}
