package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.PersonEntity;
import com.acme.bank.loan.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToModelConverter extends AbstractConverter<PersonEntity, Person> {

    @Override
    public Person convert(PersonEntity entity) {
        Person person = new Person();
        person.setPersonId(entity.getPersonId());
        person.setSsn(entity.getSsn());
        person.setBirthDate(entity.getBirthDate());
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setGender(entity.getGender());
        person.setNationality(entity.getNationality());
        return person;
    }
}
