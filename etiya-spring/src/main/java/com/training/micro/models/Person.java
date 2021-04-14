package com.training.micro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.micro.validation.StartWith;

@XmlRootElement
@Entity
@TableGenerator(name = "person_gen",
                table = "id_gen",
                pkColumnName = "gen_index",
                pkColumnValue = "person_id",
                valueColumnName = "current_id",
                initialValue = 0,
                allocationSize = 1)
@Table(name = "kisi")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "person_gen")
    private long        perId;
    @NotEmpty(message = "İsim null olamaz")
    @Size(min = 2, max = 20, message = "İsim 2 ile 20 arasında olmalı")
    // @Column(length = 50)
    @StartWith(value = "isim:", message = "Name isim: ile başlamalı")
    private String      name;
    @NotEmpty
    @StartWith(value = "soy:", message = "Surname soy: ile başlamalı")
    private String      surname;
    @NotNull
    @Max(300)
    @Min(100)
    private Integer     height;
    @NotNull
    @Past
    private LocalDate   birthdate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private List<Phone> phones;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private PersonEx    personEx;


    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(final LocalDate birthdateParam) {
        this.birthdate = birthdateParam;
    }

    public long getPerId() {
        return this.perId;
    }

    public void setPerId(final long perIdParam) {
        this.perId = perIdParam;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        this.phones = phonesParam;
    }

    public PersonEx getPersonEx() {
        return this.personEx;
    }

    public void setPersonEx(final PersonEx personExParam) {
        this.personEx = personExParam;
    }


}
