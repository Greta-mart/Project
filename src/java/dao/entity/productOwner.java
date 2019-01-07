package dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Product_owner")
public class productOwner {
    public static final String TABLE_NAME = "Product_owner";
    public static final String ID_COLUMN = "Product_ownerID";
    public static final String FIRSTNAME_COLUMN = "First_Name";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product_ownerID")
    private Long id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "Lastname", nullable = false)
    private String lastName;

    @Column(name = "CompaneName", nullable = false)
    private List<contact> contactList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<contact> getContactList() {
        return contactList;
    }

    private void setContactList(List<contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "productOwner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactList=" + contactList +
                '}';
    }
}