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
