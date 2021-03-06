package testapps.springframework.txnspringpetclinic.data.model;

import java.time.LocalDate;

public class PetVisit extends BaseEntityLong{
    private LocalDate visitDate;
    private String description;
    private Pet pet;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    protected boolean validatePetVisit() {
        return visitDate != null && description != null && description.length() > 0 && pet != null ;
    }

    @Override
    public boolean isValid() {
        return validatePetVisit() && pet.isValid();
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
    }

    @Override
    public String toString() {
        return "PetVisit{" +
                "petVisitHash=" + this.hashCode() +
                ", visitDate=" + visitDate +
                ", description='" + description + '\'' +
                ", pet=" + ((pet == null) ? "<NULL>" :  pet) +
                ", id=" + id +
                '}';
    }

    @Override
    public String partialToString() {
        return null;
    }
}
