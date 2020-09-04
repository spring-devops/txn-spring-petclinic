package testapps.springframework.txnspringpetclinic.persistence.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.model.PetType;
import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializr implements CommandLineRunner {

    private final OwnerCrudService ownerService;
    private final VeterinarianCrudService veterinarianService;
    private final PetTypeCrudService petTypeService;
    private final PetCrudService petService;
    private final OwnerSaveService ownerSaveService;

    public DataInitializr(OwnerCrudService ownerService,
                          VeterinarianCrudService veterinarianService,
                          PetTypeCrudService petTypeService,
                          PetCrudService petCrudService, OwnerSaveService ownerSaveService) {
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
        this.petTypeService = petTypeService;
        this.petService = petCrudService;
        this.ownerSaveService = ownerSaveService;
    }

    private void bootStrapOwnerAndPets() {
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        //petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        //petTypeService.save(petTypeCat);

        PetType petTypeHamster = new PetType();
        petTypeHamster.setName("Hamster");
        //petTypeService.save(petTypeHamster);

        Owner ownerInitOwner1 = new Owner();
        //ownerInitOwner1.setId(1l);
        ownerInitOwner1.setFirstName("Micheal");
        ownerInitOwner1.setLastName("Jackyson");
        ownerInitOwner1.setAddressLine1("123 Main St., Circle Line");
        ownerInitOwner1.setCity("New Jack City");
        ownerInitOwner1.setTelephone("222-222-1010");
        Set<Pet> owner1Pets = new HashSet<Pet>();
        ownerInitOwner1.setPets(owner1Pets);

        Pet pet1 = new Pet();
        pet1.setName("Coco");
        pet1.setBirthDate(LocalDate.of(2017, Month.MAY, 15));
        pet1.setPetType(petTypeDog);
        owner1Pets.add(pet1);
        //petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Mynard");
        pet2.setBirthDate(LocalDate.of(2011, Month.DECEMBER, 27));
        pet2.setPetType(petTypeCat);
        owner1Pets.add(pet2);
        //petService.save(pet2);

        Pet pet3 = new Pet();
        pet3.setName("Chippie");
        pet3.setBirthDate(LocalDate.of(2019, Month.MARCH, 7));
        pet3.setPetType(petTypeHamster);
        owner1Pets.add(pet3);
        //petService.save(pet3);

        Owner ownerInitOwner2 = new Owner();
        //ownerInitOwner2.setId(2l);
        ownerInitOwner2.setFirstName("Jamie");
        ownerInitOwner2.setLastName("Stewart");
        ownerInitOwner2.setAddressLine1("91 New Flamenco Blvd, Apt. B99");
        ownerInitOwner2.setCity("Racoon City");
        ownerInitOwner2.setTelephone("211-211-9898");
        Set<Pet> owner2Pets = new HashSet<Pet>();
        ownerInitOwner2.setPets(owner2Pets);

        Pet pet4 = new Pet();
        pet4.setName("Centurion");
        pet4.setBirthDate(LocalDate.of(2004, Month.FEBRUARY, 28));
        pet4.setPetType(petTypeDog);
        owner2Pets.add(pet4);
        //petService.save(pet4);

        ownerSaveService.saveOwner(ownerInitOwner1);
        ownerSaveService.saveOwner(ownerInitOwner2);
    }

    private void bootStrapVeterinarian() {
        Veterinarian veterinarianInitVeterinarian1 = new Veterinarian();
        //veterinarianInitVeterinarian1.setId(1l);
        veterinarianInitVeterinarian1.setFirstName("Dr. Phylis");
        veterinarianInitVeterinarian1.setLastName("Arbrorean");
        veterinarianService.save(veterinarianInitVeterinarian1);

        Veterinarian veterinarianInitVeterinarian2 = new Veterinarian();
        //veterinarianInitVeterinarian2.setId(2l);
        veterinarianInitVeterinarian2.setFirstName("Dr. Gomer");
        veterinarianInitVeterinarian2.setLastName("Pyle");
        veterinarianService.save(veterinarianInitVeterinarian2);

    }

    @Override
    public void run(String... args) throws Exception {

        bootStrapOwnerAndPets();

        System.out.println("CommandLineRunner >>>> Pets Types loaded and saved ....");
        System.out.println(petTypeService.toString());

        System.out.println("CommandLineRunner >>>> Pets loaded and saved ....");
        System.out.println(petService.toString());

        System.out.println("CommandLineRunner >>>> Owners loaded and saved ....");
        System.out.println(ownerService.toString());

        bootStrapVeterinarian();
        System.out.println("CommandLineRunner >>>> Veterinarians loaded and saved ....");
        System.out.println(veterinarianService.toString());
    }
}
