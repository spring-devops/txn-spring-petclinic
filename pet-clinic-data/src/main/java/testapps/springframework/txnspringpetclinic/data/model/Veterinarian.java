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
