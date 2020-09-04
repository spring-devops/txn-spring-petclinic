package testapps.springframework.txnspringpetclinic.data.model;

import java.util.Set;

public class Owner extends Person{

    private Set<Pet> pets;
    private String addressLine1;
    private String city;
    private String telephone;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected boolean validateAddress() {
        return (
                this.addressLine1 != null &&
                this.addressLine1.length() > 0 &&
                this.telephone != null &&
                this.telephone.length() > 0 &&
                this.city != null &&
                this.city.length() > 0 &&
                this.pets != null &&
                this.pets.size() > 0
        );
    }

    protected boolean validatePets() {
        for (Pet pet : pets) {
            if (pet == null || !pet.isValid()) return false ;
        }
        return true;
    }

    @Override
    public boolean isValid() {
        //The owner must have first name, last name, adddress, city, state, pets

        //For now, simply return true - this will be fixed later,
        // possibly by externalizing to a helper class that can
        // raise exceptions or handle messages back to the UI etc.
        return (super.isValid()) && validateAddress() && validatePets();
    }

    @Override
    public boolean isValidEntity() {
        return isValid();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerHash=" + this.hashCode() +
                ", id=" + id + ", " +
                super.toString() +
                ", pets=" + ((pets == null) ? "<NULL>" : pets.size()) +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    @Override
    public String partialToString() {
        return "Owner{" +
                "ownerHash=" + this.hashCode() +
                ", id=" + id + ", " +
                super.toString();
    }
}
