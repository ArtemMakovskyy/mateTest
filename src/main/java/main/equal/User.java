package main.equal;

public class User implements Cloneable {
   private String name;
   private String lastName;
   private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public User clone()  {
        try {
//            return (User) super.clone();
            User clonedUser = (User) super.clone();
            clonedUser.setAddress(address.clone());
            return clonedUser;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't create user clone" , e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
