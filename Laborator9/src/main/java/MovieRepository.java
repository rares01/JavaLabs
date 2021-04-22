import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovieRepository {
    private EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }
    public void create(Movies movie) {
        em.persist(movie);
    }
    public Movies findById(int id) {
        TypedQuery<Movies> query = em.createNamedQuery("Movies.findById", Movies.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    public Movies findByName(String name) {
        TypedQuery<Movies> query = em.createNamedQuery(
                "Movies.findByName", Movies.class)
                .setParameter("title", name);
        return query.getSingleResult();
    }
}
