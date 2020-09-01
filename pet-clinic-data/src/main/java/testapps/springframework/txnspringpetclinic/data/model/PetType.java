package testapps.springframework.txnspringpetclinic.data.model;

public class PetType extends BaseEntityLong {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
