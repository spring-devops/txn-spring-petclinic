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
        boolean skipVet = false;
        if (vet == null) {
            /* Raise Exception here */
            skipVet = true;
            System.out.println("OwnerSaveService >>>> saveOwner >>>> ***WARNING*** Skipping Save For NULL Owner ");
        }

        if (!vet.isValid()) {
            /* Raise Exception here */
            skipVet = true;
            System.out.println("OwnerSaveService >>>> saveOwner >>>> ***WARNING*** Skipping Save For Vet " + vet.toString());
        }

        //Note - The above check will have checked that everything inside vet is valid and ready to go database
        if (!skipVet) {
            vet.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) specialityCrudService.save(specialty);
            });
            veterinarianService.save(vet);
        }
    }
}
