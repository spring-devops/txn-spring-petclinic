package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Owner;

import java.util.Set;

public interface OwnerService<Owner, Long> extends GenericEntityService<Owner, Long>{
    Owner findByLastName(String lastName);
}


