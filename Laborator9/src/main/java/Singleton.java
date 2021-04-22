import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
    private static EntityManager entityManager=null;
    static
    {
        EntityManagerFactory ent= Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager= ent.createEntityManager();
        entityManager.getTransaction().begin();
    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
