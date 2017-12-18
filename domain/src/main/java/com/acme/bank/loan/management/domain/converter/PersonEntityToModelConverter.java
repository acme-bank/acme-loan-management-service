package com.acme.bank.loan.management.domain.converter;

import org.springframework.stereotype.Component;

import com.acme.bank.loan.management.domain.entity.PersonEntity;
import com.acme.bank.loan.management.domain.model.Person;

@Component
public class PersonEntityToModelConverter extends AbstractConverter<PersonEntity, Person> {

    @Override
    public Person convert(PersonEntity entity) {
        Person person = new Person();
        person.setPersonalId(entity.getPersonalId());
        person.setBirthDate(entity.getBirthDate());
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setGender(entity.getGender());
        person.setNationality(entity.getNationality());
        return person;
    }
}
