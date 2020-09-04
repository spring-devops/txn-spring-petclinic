package testapps.springframework.txnspringpetclinic.data.model;

import javax.xml.parsers.SAXParser;

public class Veterinarian extends Person{

    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean isValid() {
        //The owner must have first name, last name, adddress, city, state, pets

        //For now, simply return true - this will be fixed later,
        // possibly by externalizing to a helper class that can
        // raise exceptions or handle messages back to the UI etc.
        return (super.isValid() && speciality != null && speciality.isValid());
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
                ", speciality=" + ((speciality == null) ? "<NULL>" : speciality) +
                '}';
    }

    @Override
    public String partialToString() {
        return "Veterinarian{" +
                "vetHash=" + this.hashCode() +
                ", id=" + id + ", " +
                super.toString();
    }

}
