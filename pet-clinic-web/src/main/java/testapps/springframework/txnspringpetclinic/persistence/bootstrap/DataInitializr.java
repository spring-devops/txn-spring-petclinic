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

    public DataInitializr(OwnerCrudService ownerService,
                          VeterinarianCrudService veterinarianService,
                          PetTypeCrudService petTypeService,
                          PetCrudService petCrudService) {
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
        this.petTypeService = petTypeService;
        this.petService = petCrudService;
    }

    private void bootStrapPets() {
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        petTypeService.save(petTypeCat);

        PetType petTypeHamster = new PetType();
        petTypeHamster.setName("Hamster");
        petTypeService.save(petTypeHamster);

        Pet pet1 = new Pet();
        pet1.setName("Coco");
        pet1.setBirthDate(LocalDate.of(2017, Month.MAY, 15));
        pet1.setPetType(petTypeDog);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Mynard");
        pet2.setBirthDate(LocalDate.of(2011, Month.DECEMBER, 27));
        pet2.setPetType(petTypeCat);
        petService.save(pet2);

        Pet pet3 = new Pet();
        pet3.setName("Chippie");
        pet3.setBirthDate(LocalDate.of(2019, Month.MARCH, 7));
        pet3.setPetType(petTypeHamster);
        petService.save(pet3);

        Pet pet4 = new Pet();
        pet4.setName("Centurion");
        pet4.setBirthDate(LocalDate.of(2004, Month.FEBRUARY, 28));
        pet4.setPetType(petTypeDog);
        petService.save(pet4);
    }

    //We will assume/pass-in 4 pets - add first three to the first owner and last one to the second owner
    private void bootStrapOwner(Set<Pet> allPets) {
        if (allPets == null) allPets = new HashSet<Pet>() ;
        Pet [] allPetsOrdered = allPets.toArray(new Pet[allPets.size()]);

        Owner ownerInitOwner1 = new Owner();
        //ownerInitOwner1.setId(1l);
        ownerInitOwner1.setFirstName("Micheal");
        ownerInitOwner1.setLastName("Jackyson");
        ownerInitOwner1.setAddressLine1("123 Main St., Circle Line");
        ownerInitOwner1.setCity("New Jack City");
        ownerInitOwner1.setTelephone("222-222-1010");
        Set<Pet> owner1Pets = new HashSet<Pet>();
        if (allPets.size() > 0) {
            for (int i = 0; i < 3; i ++) {
                if (allPetsOrdered[0] != null) {
                    owner1Pets.add(allPetsOrdered[i]);
                    allPetsOrdered[i].setOwner(ownerInitOwner1);
                }
            }
            if (owner1Pets.size() > 0)
                ownerInitOwner1.setPets(owner1Pets);
        }
        ownerService.save(ownerInitOwner1);
        if (owner1Pets.size() > 0) {
            for (Pet pet : owner1Pets) {
                if (pet != null) {
                    petService.save(pet);
                }
            }
        }

        Owner ownerInitOwner2 = new Owner();
        //ownerInitOwner2.setId(2l);
        ownerInitOwner2.setFirstName("Jamie");
        ownerInitOwner2.setLastName("Stewart");
        ownerInitOwner2.setAddressLine1("91 New Flamenco Blvd, Apt. B99");
        ownerInitOwner2.setCity("Racoon City");
        ownerInitOwner2.setTelephone("211-211-9898");
        Set<Pet> owner2Pets = new HashSet<Pet>();
        if (allPets.size() > 3 && allPetsOrdered[3] != null) {
            owner2Pets.add(allPetsOrdered[3]);
            allPetsOrdered[3].setOwner(ownerInitOwner2);

            ownerInitOwner2.setPets(owner2Pets);
        }
        ownerService.save(ownerInitOwner2);

        if (owner2Pets.size() > 0)
            petService.save(allPetsOrdered[3]);
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

        bootStrapPets();
        bootStrapOwner(petService.findAll());

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
