package testapps.springframework.txnspringpetclinic.data.model;

import java.time.LocalDate;

public class Pet extends BaseEntityLong {
    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", petType=" + petType +
                ", ownerHash=" + ((owner == null) ? "<NULL>" : owner.hashCode()) +
                '}';
    }
}
