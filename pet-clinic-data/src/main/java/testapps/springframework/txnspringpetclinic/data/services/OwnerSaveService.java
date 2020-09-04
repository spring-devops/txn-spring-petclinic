package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.model.PetType;

import java.util.Set;

@Service
public class OwnerSaveService {

    private final OwnerCrudService ownerService;
    private final PetTypeCrudService petTypeService;
    private final PetCrudService petService;

    public OwnerSaveService(OwnerCrudService ownerService,
                          VeterinarianCrudService veterinarianService,
                          PetTypeCrudService petTypeService,
                          PetCrudService petCrudService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petCrudService;
    }

    public void saveOwner (Owner owner){
        if (owner == null) { /* Raise Exception here */}
        if (!owner.isValid()) { /* Raise Exception here */}
        //Note - The above check will have checked that everything inside owner is valid and resdy to go database
        ownerService.save(owner);
        owner.getPets().forEach(pet -> {
            PetType petType = pet.getPetType();
            //If the Pet ID is missing, it needs to be saved, otherwise skip the save part
            if (petType.getId() == null)
                //The New Pet Type ID will be set automatically
                petTypeService.save(petType);
            if (pet.getId() == null)
                //The New Pet ID will be set automatically
                pet.setOwner(owner);
                petService.save(pet) ;
        });
    }
}
