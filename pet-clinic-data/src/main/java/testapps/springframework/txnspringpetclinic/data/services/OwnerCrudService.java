package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Owner;

public interface OwnerCrudService extends GenericEntityCrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}


