package training;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "user_id")))
public class User extends Account {

    @NotNull
    @Column(nullable = false, length = 40)
    private String firstName;
    @NotNull
    @Column(nullable = false, length = 40)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private List<Phone> phones;

    @Embedded
    private Address address;

    public User(){
        super();
    }

    public User(String username, String email, String firstName, String lastName, List<Phone> phones, Address address) {

        super(email, username);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
        this.address = address;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
