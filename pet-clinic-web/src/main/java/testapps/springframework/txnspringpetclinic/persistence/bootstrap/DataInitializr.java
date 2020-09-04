package testapps.springframework.txnspringpetclinic.persistence.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import testapps.springframework.txnspringpetclinic.data.model.*;
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
    private final VeterinarianSaveService veterinarianSaveService;

    public DataInitializr(OwnerCrudService ownerService,
                          VeterinarianCrudService veterinarianService,
                          PetTypeCrudService petTypeService,
                          PetCrudService petCrudService, OwnerSaveService ownerSaveService, VeterinarianSaveService veterinarianSaveService) {
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
        this.petTypeService = petTypeService;
        this.petService = petCrudService;
        this.ownerSaveService = ownerSaveService;
        this.veterinarianSaveService = veterinarianSaveService;
    }

    PetType petTypeDog = new PetType();
    PetType petTypeCat = new PetType();
    PetType petTypeHamster = new PetType();

    Speciality spcSurgeon = new Speciality();
    Speciality spcMedicine = new Speciality();
    Speciality spcRadiologist = new Speciality();
    Speciality spcPsychiatry = new Speciality();
    Speciality spcGP = new Speciality();
    Speciality spcOncologist = new Speciality();
    Speciality spcNutritionist = new Speciality();

    private void initializePetTypes(){
        petTypeDog.setName("Dog");
        petTypeCat.setName("Cat");
        petTypeHamster.setName("Hamster");
    }

    private void initializeSpecialties() {
        spcSurgeon.setSpecialityName(Speciality.SPECIALITIES[0]);
        spcMedicine.setSpecialityName(Speciality.SPECIALITIES[1]);
        spcRadiologist.setSpecialityName(Speciality.SPECIALITIES[2]);
        spcPsychiatry.setSpecialityName(Speciality.SPECIALITIES[3]);
        spcGP.setSpecialityName(Speciality.SPECIALITIES[4]);
        spcOncologist.setSpecialityName(Speciality.SPECIALITIES[5]);
        spcNutritionist.setSpecialityName(Speciality.SPECIALITIES[6]);
    }

    private Set<Pet> getPetsOwner1() {
        Set<Pet> ownerPets = new HashSet<Pet>();

        Pet pet = new Pet();
        pet.setName("Coco");
        pet.setBirthDate(LocalDate.of(2017, Month.MAY, 15));
        pet.setPetType(petTypeDog);
        ownerPets.add(pet);

        pet = new Pet();
        pet.setName("Mynard");
        pet.setBirthDate(LocalDate.of(2011, Month.DECEMBER, 27));
        pet.setPetType(petTypeCat);
        ownerPets.add(pet);

        pet = new Pet();
        pet.setName("Chippie");
        pet.setBirthDate(LocalDate.of(2019, Month.MARCH, 7));
        pet.setPetType(petTypeHamster);
        ownerPets.add(pet);

        return ownerPets;
    }

    private Set<Pet> getPetsOwner2() {
        Set<Pet> ownerPets = new HashSet<Pet>();

        Pet pet = new Pet();
        pet.setName("Centurion");
        pet.setBirthDate(LocalDate.of(2004, Month.FEBRUARY, 28));
        pet.setPetType(petTypeDog);
        ownerPets.add(pet);

        return ownerPets;
    }

    private void bootStrapOwnerAndPets() {
        initializePetTypes();
        Owner ownerInitOwner1 = new Owner();
        //ownerInitOwner1.setId(1l);
        ownerInitOwner1.setFirstName("Micheal");
        ownerInitOwner1.setLastName("Jackyson");
        ownerInitOwner1.setAddressLine1("123 Main St., Circle Line");
        ownerInitOwner1.setCity("New Jack City");
        ownerInitOwner1.setTelephone("222-222-1010");
        ownerInitOwner1.setPets(getPetsOwner1());

        Owner ownerInitOwner2 = new Owner();
        //ownerInitOwner2.setId(2l);
        ownerInitOwner2.setFirstName("Jamie");
        ownerInitOwner2.setLastName("Stewart");
        ownerInitOwner2.setAddressLine1("91 New Flamenco Blvd, Apt. B99");
        ownerInitOwner2.setCity("Racoon City");
        ownerInitOwner2.setTelephone("211-211-9898");
        ownerInitOwner2.setPets(getPetsOwner2());

        ownerSaveService.saveOwner(ownerInitOwner1);
        ownerSaveService.saveOwner(ownerInitOwner2);
    }

    private Set<Speciality> getSpecialitiesVet1() {
        Set<Speciality> specialities = new HashSet<>();

        specialities.add(spcSurgeon);
        specialities.add(spcMedicine);
        specialities.add(spcRadiologist);
        specialities.add(spcPsychiatry);
        specialities.add(spcGP);

        return specialities;
    }

    private Set<Speciality> getSpecialitiesVet2() {
        Set<Speciality> specialities = new HashSet<>();

        specialities.add(spcGP);
        specialities.add(spcOncologist);
        specialities.add(spcNutritionist);

        return specialities;
    }

    private void bootStrapVeterinarian() {
        initializeSpecialties();
        Veterinarian veterinarianInitVeterinarian1 = new Veterinarian();
        //veterinarianInitVeterinarian1.setId(1l);
        veterinarianInitVeterinarian1.setFirstName("Dr. Phylis");
        veterinarianInitVeterinarian1.setLastName("Arbrorean");
        veterinarianInitVeterinarian1.setSpecialities(getSpecialitiesVet1());
        veterinarianSaveService.saveVeterinarian(veterinarianInitVeterinarian1);

        Veterinarian veterinarianInitVeterinarian2 = new Veterinarian();
        //veterinarianInitVeterinarian2.setId(2l);
        veterinarianInitVeterinarian2.setFirstName("Dr. Gomer");
        veterinarianInitVeterinarian2.setLastName("Pyle");
        Set<Speciality> specialities2 = new HashSet<>();
        veterinarianInitVeterinarian2.setSpecialities(getSpecialitiesVet2());
        veterinarianSaveService.saveVeterinarian(veterinarianInitVeterinarian2);
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
