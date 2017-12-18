package com.acme.bank.loan.management.domain.converter;

import com.acme.bank.loan.management.domain.entity.PersonEntity;
import com.acme.bank.loan.management.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonModelToEntityConverter extends AbstractConverter<Person, PersonEntity> {

    @Override
    public PersonEntity convert(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setPersonalId(person.getPersonalId());
        entity.setBirthDate(person.getBirthDate());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setNationality(person.getNationality());
        return entity;
    }
}
