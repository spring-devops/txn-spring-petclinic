package testapps.springframework.txnspringpetclinic.data.model;

public abstract class Person<K> extends BaseEntityLong {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isValid() {
        return (
                this.firstName != null &&
                        this.firstName.length() > 0 &&
                        this.lastName != null &&
                        this.lastName.length() > 0
        );
    }

    public boolean isValidEntity() {
        return isValid();
    }
}
