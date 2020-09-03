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

}
