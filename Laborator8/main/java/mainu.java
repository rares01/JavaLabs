import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class mainu {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {

        /**Conexiunea se realizeaza aici */
        Connection con = Singleton.createCon();
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("src/script/createTable.sql"));
        //Running the script
        sr.runScript(reader);


        /**Pentru a creea un object-oriented model am folosit pentru fiecare tip (Movies,Genres etc..):
         * o interfata, si 2 clase ex: movieDao ( ca interfata), ClassMovieDao si Movies ( cele 2 clase)*/


        /**Pentru clasa Movies avem si o clasa ClassMovieDao si un interface movieDao */
        System.out.println("Pentru Movies:");
        Movies movie= new Movies(200,"rafaelo","10 august 2000",2,97);
        ClassMovieDao movDao= new ClassMovieDao();
        movDao.createMovie(movie);
        Movies mv1 = movDao.getIdMovie(10);
        System.out.println();
        System.out.println(mv1.getId() + " " + mv1.getTitle() + " " + mv1.getRelease_date()+ " " + mv1.getDuration() + " " + mv1.getScore());
        List<Movies> mv=  movDao.selectAllMovies();
        System.out.println();
        for (Movies allMovies : mv) {
            System.out.println(allMovies.getId() + " " + allMovies.getTitle() + " " + allMovies.getRelease_date()+ " " + allMovies.getDuration() + " " + allMovies.getScore());
        }
        Movies mv2 = movDao.getNameMovie("rafaelo");
        System.out.println();
        System.out.println(mv2.getId() + " " + mv2.getTitle() + " " + mv2.getRelease_date()+ " " + mv2.getDuration() + " " + mv2.getScore());
        System.out.println();
        /**Aici se afla elementele din dataset */
        /**Metoda preia path-urile,delimiteaza, si creeaza o lista de filme */
        List<Movies> moviesCSV=movDao.toolMovies("C:\\Users\\RaresGeorge\\IdeaProjects\\Laborator8.2\\src\\IMDb movies.csv");

        /**Pentru clasa Genres avem si o clasa ClassGenresDao si un interface genresDao */
        System.out.println("Pentru Genres:");
        Genres genres = new Genres(40,"romantic");
        ClassGenresDao  genDao= new ClassGenresDao();
        genDao.createGenres(genres);
        Genres gen1 = genDao.getIdGenres(40);
        System.out.println();
        System.out.println(gen1.getId() + " " + gen1.getName());
        List<Genres> gen=  genDao.selectAllGenres();
        System.out.println();
        for (Genres allGenres : gen) {
            System.out.println(allGenres.getId() + " " + allGenres.getName());
        }
        Genres gen2 = genDao.getNameGenres("romantic");
        System.out.println();
        System.out.println(gen2.getId() + " " + gen2.getName());
        System.out.println();
        /**Aici se afla elementele din dataset */
        List<Genres> genresCSV=genDao.toolGenres("C:\\Users\\RaresGeorge\\IdeaProjects\\Laborator8.2\\src\\IMDb movies.csv");

        /**Pentru clasa Actors avem si o clasa ClassActorsDao si un interface actorsDao */
        System.out.println("Pentru Actors: ");
        Actors actors = new Actors(200,"Bradd Pitt");
        ClassActorsDao  actDao= new ClassActorsDao();
        actDao.createActors(actors);
        Actors act1 = actDao.getIdActors(200);
        System.out.println();
        System.out.println(act1.getMovieId() + " " + act1.getName());
        List<Actors> act=  actDao.selectAllActors();
        System.out.println();
        for (Actors allActors : act) {
            System.out.println(allActors.getMovieId() + " " + allActors.getName());
        }
        Actors act2 = actDao.getNameActors("Bradd Pitt");
        System.out.println();
        System.out.println(act2.getMovieId() + " " + act2.getName());
        System.out.println();
        /**Aici se afla elementele din dataset */
        List<Actors> actorsCSV=actDao.toolActors("C:\\Users\\RaresGeorge\\IdeaProjects\\Laborator8.2\\src\\IMDb movies.csv");

        /**Pentru clasa Directors avem si o clasa ClassDirectorsDao si un interface directorsDao */
        System.out.println("Pentru Directors:");
        Directors directors = new Directors(200,"Tarantino");
        ClassDirectorsDao  dirDao= new ClassDirectorsDao();
        dirDao.createDirectors(directors);
        Directors dir1 = dirDao.getIdDirectors(200);
        System.out.println();
        System.out.println(dir1.getMovieId() + " " + dir1.getName());
        List<Directors> dir=  dirDao.selectAllDirectors();
        System.out.println();
        for (Directors allDirectors : dir) {
            System.out.println(allDirectors.getMovieId() + " " + allDirectors.getName());
        }
        Directors dir2 = dirDao.getNameDirectors("Tarantino");
        System.out.println();
        System.out.println(dir2.getMovieId() + " " + dir2.getName());
        System.out.println();
        /**Aici se afla elementele din dataset */
        List<Directors> directorsCSV=dirDao.toolDirectors("C:\\Users\\RaresGeorge\\IdeaProjects\\Laborator8.2\\src\\IMDb movies.csv");

        System.out.println("Pentru Asstab:");
        Asstab asstab = new Asstab(82,200);
        ClassAsstabDao  asstabDao= new ClassAsstabDao();
        asstabDao.createAssTab(asstab);
        Asstab asstab1 = asstabDao.getIdAssTabMovie(200);
        System.out.println();
        System.out.println(asstab1.getMovieID() + " " + asstab1.getGenreID());
        List<Asstab> asstabs=  asstabDao.selectAllAssTab();
        System.out.println();
        for (Asstab allAssTabs : asstabs) {
            System.out.println(allAssTabs.getMovieID() + " " + allAssTabs.getGenreID());
        }
        Asstab asstab2 = asstabDao.getIdAssTabGenres(82);
        System.out.println();
        System.out.println(asstab2.getMovieID() + " " + asstab2.getGenreID());
        System.out.println();

    }

}
