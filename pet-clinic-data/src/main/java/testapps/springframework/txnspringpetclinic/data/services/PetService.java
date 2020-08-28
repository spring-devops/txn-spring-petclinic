package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Pet;

import java.util.Set;

public interface PetService<Pet, Long> extends GenericEntityService<Pet, Long> { }
