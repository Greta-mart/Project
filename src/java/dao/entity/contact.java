package dao.entity;

import javax.persistence.*;

@Entity
@Table(name="Product_owner_contacts")
public class contact {

    @ManyToOne
    @JoinColumn(name = "Product_ownerID")
    private long id;

    @Column(name = "Type", nullable = false)
    private contactTypes type;

    @Column(name = "Value", nullable = false)
    private String data;

    public contact(contactTypes type, String data) {
        this.type = type;
        this.data = data;
    }

    public contactTypes getType() {
        return type;
    }

    private void setType(contactTypes type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "contact{" +
                "id=" + id +
                ", type=" + type +
                ", data='" + data + '\'' +
                '}';
    }
}
