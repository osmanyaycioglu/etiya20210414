package com.training.micro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "phone_gen",
                table = "id_gen",
                pkColumnName = "gen_index",
                pkColumnValue = "phone_id",
                valueColumnName = "current_id",
                initialValue = 0,
                allocationSize = 1)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")
    private long   pId;
    private String category;
    private String name;
    private String number;
    @ManyToOne
    private Person person;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(final String categoryParam) {
        this.category = categoryParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public long getpId() {
        return this.pId;
    }

    public void setpId(final long pIdParam) {
        this.pId = pIdParam;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person personParam) {
        person = personParam;
    }

}
