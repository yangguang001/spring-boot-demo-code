package com.springboot.data.jpa.dao;

import com.springboot.data.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yz on 2018/1/2.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name=:name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    Person withNameAndAddressNamedQuery(String name, String address);
}
