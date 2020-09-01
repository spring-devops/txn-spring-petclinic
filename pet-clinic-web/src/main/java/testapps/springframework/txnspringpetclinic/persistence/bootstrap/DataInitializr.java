package testapps.springframework.txnspringpetclinic.persistence.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.OwnerCrudService;
import testapps.springframework.txnspringpetclinic.data.services.VeterinarianCrudService;

@Component
public class DataInitializr implements CommandLineRunner {

    private final OwnerCrudService ownerService;
    private final VeterinarianCrudService veterinarianService;

    public DataInitializr(OwnerCrudService ownerService, VeterinarianCrudService veterinarianService) {
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerInitOwner1 = new Owner();
        //ownerInitOwner1.setId(1l);
        ownerInitOwner1.setFirstName("Micheal");
        ownerInitOwner1.setLastName("Jackyson");
        ownerService.save(ownerInitOwner1);

        Owner ownerInitOwner2 = new Owner();
        //ownerInitOwner2.setId(2l);
        ownerInitOwner2.setFirstName("Jamie");
        ownerInitOwner2.setLastName("Stewart");
        ownerService.save(ownerInitOwner2);

        System.out.println("CommandLineRunner >>>> Two Owners loaded and saved ....");
        System.out.println(ownerService.toString());

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

        System.out.println("CommandLineRunner >>>> Two Veterinarians loaded and saved ....");
        System.out.println(veterinarianService.toString());

    }
}
