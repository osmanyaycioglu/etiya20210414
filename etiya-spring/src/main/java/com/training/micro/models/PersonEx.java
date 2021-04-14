package com.training.micro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "persone_gen",
                table = "id_gen",
                pkColumnName = "gen_index",
                pkColumnValue = "persone_id",
                valueColumnName = "current_id",
                initialValue = 0,
                allocationSize = 1)
public class PersonEx {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "persone_gen")
    private long   peId;
    private String data;
    @OneToOne
    private Person person;


    public long getPeId() {
        return this.peId;
    }

    public void setPeId(final long peIdParam) {
        this.peId = peIdParam;
    }

    public String getData() {
        return this.data;
    }

    public void setData(final String dataParam) {
        this.data = dataParam;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }


}
