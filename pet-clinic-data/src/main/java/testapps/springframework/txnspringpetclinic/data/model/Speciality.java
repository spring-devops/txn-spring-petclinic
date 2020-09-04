package testapps.springframework.txnspringpetclinic.data.model;

public class Speciality extends BaseEntityLong {

    public static final String [] SPECIALITIES = {"Surgeon", "Medicine", "Radiologist", "Psychiatry", "General Practitioner", "Oncologist", "Nutritionist"};

    private String specialityName;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public boolean isValid() {
        return specialityName != null && specialityName.length() > 0;
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
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
        return toString();
    }
}
