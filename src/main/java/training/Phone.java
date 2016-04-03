package training;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column(nullable =  false)
    private String number;
    @NotNull
    @Column(name = "phone_type",nullable =  false)
    @Enumerated(EnumType.ORDINAL)
    private PhoneType type;

    public Phone(){
        super();
    }

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
