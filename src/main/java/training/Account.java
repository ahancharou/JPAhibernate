package training;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account {

    @Id@GeneratedValue
    private long id;
    @NotNull
    @Column(nullable = false, length = 40)
    private String email;
    @NotNull
    @Column(nullable = false, length = 20)
    private String username;

    public Account(){
        super();
    }

    public Account(String email, String username) {
        super();
        this.email = email;
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
