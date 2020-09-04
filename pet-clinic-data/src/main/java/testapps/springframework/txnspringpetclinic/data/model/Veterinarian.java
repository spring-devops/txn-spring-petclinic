package testapps.springframework.txnspringpetclinic.data.model;

import javax.xml.parsers.SAXParser;
import java.util.Set;

public class Veterinarian extends Person{

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> speciality) {
        this.specialities = speciality;
    }

    protected boolean validateSpecialities() {
        for (Speciality speciality : specialities) {
            if (speciality == null || !speciality.isValid()) return false ;
        }
        return true;
    }

    @Override
    public boolean isValid() {
        //The owner must have first name, last name, adddress, city, state, pets

        //For now, simply return true - this will be fixed later,
        // possibly by externalizing to a helper class that can
        // raise exceptions or handle messages back to the UI etc.
        return (super.isValid() && specialities != null && validateSpecialities());
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetHash=" + this.hashCode() +
                ", id=" + id + ", " +
                super.toString() +
                ", specialities=" + ((specialities == null) ? "<NULL>" : specialities) +
                '}';
    }

    @Override
    public String partialToString() {
        return "Veterinarian{" +
                "vetHash=" + this.hashCode() +
                ", id=" + id + ", " +
                super.toString() +
                ", specialities=" + ((specialities == null) ? "<NULL>" : specialities.size());
    }

}
