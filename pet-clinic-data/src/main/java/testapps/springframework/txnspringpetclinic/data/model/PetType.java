package testapps.springframework.txnspringpetclinic.data.model;

public class PetType extends BaseEntityLong {
    private static String [] petTypes = {"Dog", "Cat", "Hamster", "Turtle", "Bird", "Rodent", "Rabbit", "Other"} ;
    public static boolean isValidPet (PetType petTypeToCheck){
        if (petTypeToCheck == null) return false ;
        String petTypeToCheckName = petTypeToCheck.getName();
        for (String petTypeToCompareName : petTypes) {
            if (petTypeToCompareName.equals(petTypeToCheckName)) return true ;
        }
        return false ;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected boolean validatePetType() {
        return (name != null && name.length() > 0);
    }

    @Override
    public boolean isValid() {
        return validatePetType() && PetType.isValidPet(this);
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
    }

    @Override
    public String toString() {
        return "PetType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String partialToString() {
        return toString();
    }
}
