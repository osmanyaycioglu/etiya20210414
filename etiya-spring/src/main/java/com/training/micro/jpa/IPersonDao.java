package com.training.micro.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.micro.models.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    List<Person> findByNameIn(List<String> name);

    List<Person> findByNameOrderBySurnameAsc(String name);

    @Query("select p from Person p where p.name=?1")
    List<Person> intSearchName(String name);

    @Query("select p from Person p where p.name= :isim")
    List<Person> intSearchName2(@Param("isim") String name);

    @Query(value = "select * from kisi p where p.name= :isim", nativeQuery = true)
    List<Person> intSearchName3(@Param("isim") String name);


}
