package testapps.springframework.txnspringpetclinic.data.model;

import java.time.LocalDate;

public class Pet extends BaseEntityLong {

    private String name;

    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    protected boolean validatePet() {
        return (
                this.name != null &&
                        this.name.length() > 0 &&
                        this.birthDate != null &&
                        petType != null
        );
    }

    @Override
    public boolean isValid() {
        return validatePet() && petType.isValid();
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                ", petType=" + ((petType == null) ? "<NULL>" : petType) +
                ", owner=" + ((owner == null) ? "<NULL>" : owner.partialToString()) +
                '}';
    }

    @Override
    public String partialToString() {
        return toString();
    }
}
