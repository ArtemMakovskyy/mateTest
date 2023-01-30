package main.immutable.finalfields;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public final class User implements Cloneable{
    private final String firstName;
    private final String serName;
    private  List<Languages> languagesList;
    private  Address address;

    public User(String firstName, String serName, List<Languages> languagesList, Address address) {
        this.firstName = firstName;
        this.serName = serName;
        this.languagesList = languagesList;
        this.address = address;
    }

   public String getFirstName() {
      return firstName;
   }

   public String getSerName() {
      return serName;
   }

   public List<Languages> getLanguagesList(List<Languages> list) {
        List<Languages> listCopy = new ArrayList<>();
        for (Languages language : list) {
            listCopy.add(language.clone());
        }
        return listCopy;
    }

    public Address getAddress() {
        return new Address(address.getStreet(),address.getHouse());
    }

    @Override
    protected User clone() {
        return new User(firstName, serName, getLanguagesList(languagesList), address.clone());
    }
}
