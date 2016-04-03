import training.Address;
import training.Phone;
import training.PhoneType;
import training.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String [] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAtask");
        EntityManager em = factory.createEntityManager();

        List<Phone> phonesAdmin= new ArrayList<>();
        Phone homePhone = new Phone("667452", PhoneType.HOME);
        Phone mobile = new Phone("31232312", PhoneType.MOBILE);
        phonesAdmin.add(homePhone);
        phonesAdmin.add(mobile);
        Address adminAddress = new Address("Novokamenskaya", 22, 12);
        User admin = new User("admin", "admin@email.com", "Bill", "Jones", phonesAdmin, adminAddress);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(homePhone);
        em.persist(mobile);
        em.persist(admin);
        transaction.commit();

        em.close();
        factory.close();
    }
}
