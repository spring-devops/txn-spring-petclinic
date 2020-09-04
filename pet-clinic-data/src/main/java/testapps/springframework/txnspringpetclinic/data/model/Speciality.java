package testapps.springframework.txnspringpetclinic.data.model;

public class Speciality extends BaseEntityLong {

    private String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityHash=" + this.hashCode() + ", " +
                "specialityName='" + specialityName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public String partialToString() {
        return null;
    }
}
