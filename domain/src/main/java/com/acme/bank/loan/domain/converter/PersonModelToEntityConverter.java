package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.PersonEntity;
import com.acme.bank.loan.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonModelToEntityConverter extends AbstractConverter<Person, PersonEntity> {

    @Override
    public PersonEntity convert(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setPersonId(person.getPersonId());
        entity.setSsn(person.getSsn());
        entity.setBirthDate(person.getBirthDate());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setNationality(person.getNationality());
        return entity;
    }
}
