package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Pet;

public interface PetService<Pet, Long> extends GenericEntityService<Pet, Long> { }
