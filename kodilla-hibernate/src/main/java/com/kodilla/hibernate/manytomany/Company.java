package com.kodilla.hibernate.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWithFirstLettersEqualTo",
        query = "SELECT * FROM COMPANIES" +
                " WHERE LEFT(COMPANY_NAME , 3)=:FIRSTLETTERS",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.findCompanyByPartOfName",
        query = "FROM Company WHERE name LIKE :PARTOFNAME"
)


@Entity
@Table(name = "COMPANIES")
public class Company {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    private int id;

    @NotNull
    @Column(name = "COMPANY_NAME")
    private String name;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }
}