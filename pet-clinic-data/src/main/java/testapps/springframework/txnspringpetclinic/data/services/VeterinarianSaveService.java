package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.PetType;
import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;

@Service
public class VeterinarianSaveService {
    private final VeterinarianCrudService veterinarianService;
    private final SpecialityCrudService specialityCrudService;

    public VeterinarianSaveService(VeterinarianCrudService veterinarianService, SpecialityCrudService specialityCrudService) {
        this.veterinarianService = veterinarianService;
        this.specialityCrudService = specialityCrudService;
    }

    public void saveVeterinarian(Veterinarian vet) {
        if (vet == null) { /* Raise Exception here */}
        if (!vet.isValid()) { /* Raise Exception here */}
        //Note - The above check will have checked that everything inside vet is valid and ready to go database
        if (vet.getSpeciality().getId() == null) specialityCrudService.save(vet.getSpeciality());
        veterinarianService.save(vet);
    }
}
