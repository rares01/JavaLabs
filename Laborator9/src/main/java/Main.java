import java.sql.Timestamp;

public class Main {
    public static void main(String[] args){

        Movies movie=new Movies();
        movie.setId(730);
        movie.setScore(7);
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        movie.setRelease_date(timestamp);
        movie.setDuration(120);
        movie.setTitle("nimic");
        System.out.println(movie);

        MovieRepository movieRepository=new MovieRepository(Singleton.getEntityManager());
        movieRepository.create(movie);
        /**Pentru metoda findById */
        System.out.println("Am gasit filmul cu id-ul: ");
        System.out.println(movieRepository.findById(2));
        /** Pentru meotda findByName*/
        System.out.println("Am gasit filmul cu numele:");
        System.out.println(movieRepository.findByName("nimic"));
        Singleton.getEntityManager().getTransaction().commit();
        Singleton.getEntityManager().close();

    }
}
