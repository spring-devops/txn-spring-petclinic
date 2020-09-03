package testapps.springframework.txnspringpetclinic.data.model;

public class Speciality extends BaseEntityLong {

    private String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
