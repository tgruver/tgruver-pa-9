import java.util.List;
import java.util.Set;
public class Test{
    public static void main(String[] args){
        System.out.println("\nTest case 1: Reading the movies from the file");
        MovieManager mm = new MovieManager(10_000, 10_000, 10_000, 0.75);
        mm.loadMovies("movies.csv");
        System.out.println(mm.size() + " movies loaded from the file \"movies.csv\"");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 2: (Searching by ID: successful)");
        System.out.println("Finding movie with ID 101\n Movie found:\n" + mm.findMovieByID(65));

         System.out.println("-".repeat(100));
        System.out.println("\nTest case 3: (Searching by ID: fail)");
        System.out.println("\nFinding movie with ID 99999999\n Movie not found: " + mm.findMovieByID(99999999));

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 4: (Searching by genre: successful)");
        List<Movie> movies = mm.getMoviesByGenre("Drama");
        if(movies == null)
            System.out.println("No movies found with genre \"Drama\"");
        else{
            System.out.println("There are " + movies.size() + " movies with genre \"Drama\"");
            System.out.println("First ten movies of the list: ");
            print(movies, 10);
        }

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 5: (Searching by genre: fail)");
        movies = mm.getMoviesByGenre("Unknown");
        if(movies == null)
            System.out.println("No movies found with genre \"Unknown\"");
        else
            System.out.println("There are " + movies.size() + " movies with genre \"Unknown\"");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 6: (Searching by rating)");
        movies = mm.getMoviesByRating(4.5);
        if(movies != null){
            System.out.println("There are " + movies.size() + " movies with rating = 4.5");
            System.out.println("First ten movies of the list: ");
            print(movies, 10);
        }
        else
            System.out.println("There are no movies with rating = 4.5");
        System.out.println("-".repeat(100));

        System.out.println("\nTest case 7: (Searching by rating: fail)");
        movies = mm.getMoviesByRating(7.5);
        if(movies != null)
            System.out.println("There are " + movies.size() + " movies with rating = 7.5");
        else
            System.out.println("There are no movies with rating 7.5");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 8: (Searching by title (successful))");
        String title = "Heist (2015)";
        boolean found = mm.findMovieByTitle(title);
        if (found)
            System.out.println("There is a movie with the title \"" + title + "\"");
        else
            System.out.println("There is no movie with the title \"" + title + "\"");
        
        System.out.println("-".repeat(100));
        System.out.println("\nTest case 9: (Searching by title (fail))");
        title = "Unknown Title";
        found = mm.findMovieByTitle("");
        if (found)
            System.out.println("There is a movie with the title \"" + title + "\"");
        else
            System.out.println("There is no movie with the title \"" + title + "\"");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 10: (getting the list of movie genres)");
        Set<String> genres = mm.getAllGenres();
        if(genres == null)
            System.out.println("There are no movie genres");
        else
            System.out.println("There are " + mm.getAllGenres().size() + " movie genres");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 11: (Top n movies by genre)");
        movies = mm.getTopMovies("Comedy", 20);
        if(movies != null){
            System.out.println("Top twenty movies with genre Comedy: ");
            print(movies, 20);
        }
        else
            System.out.println("There are no movies with genre \"Comedy\"");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 12: (Top movies by votes and rating)");
        movies = mm.getHighlyRatedMovies(4.0, 10_000);
        if(movies != null){
            System.out.println("There are " + movies.size() + " movies with more than 10,000 votes and a rating higher than 4.0");
            System.out.println("Top ten movies of the list: ");
            print(movies, 10);
        }
        else
            System.out.println("There are no mmovies with rates >= 4.0 and votes > 10,000");

        System.out.println("-".repeat(100));
        System.out.println("\nTest case 13: (Custom sorting using quickSort, radixSort, and bucketSort)");
        List<MapEntry<String,List<Movie>>> list = mm.getMoviesByGenreThenVotesThenRating();
        if(list != null){
          System.out.println("Sorted list of movies for genre Drama (Top 10)");
          for(MapEntry<String,List<Movie>> me: list){
            if(me.getKey().equals("Drama")){
                movies = me.getValue();
                int n = Math.min(movies.size(), 10);
                for(int i=movies.size()-1; i>=movies.size()-n; i--){
                  System.out.println(movies.get(i));
                }
            }
          }
          System.out.println("-".repeat(100));
          System.out.println("Sorted list of movies for genre Comedy (Top 10)");
          for(MapEntry<String,List<Movie>> me: list){
            if(me.getKey().equals("Comedy")){
                movies = me.getValue();
                int n = Math.min(movies.size(), 10);
                for(int i=movies.size()-1; i>=movies.size()-n; i--){
                  System.out.println(movies.get(i));
                }
            }
          }
        }
        else
            System.out.println("There is no list of movies to be sorted");
        System.out.println("-".repeat(100));

        System.out.println("\nTest case 14: (Hash Maps performance)");
        mm.printStatistics();
        System.out.println();
        System.out.println("-".repeat(100));

        System.out.println("\nTest case 15: (Hash Maps performance: Different initial capacities)");
        MovieManager movieManager = null;
        int capId, capGenre, capRating;
        for(capId = 10_000, capGenre = 2_000, capRating = 20; capId < 100_000; capId *= 2,capGenre*=2,capRating*=2){
            System.out.println("-".repeat(100));
            System.out.println("Initial Capacity: " + capId + ", " + capGenre + ", " + capRating);
            movieManager = new MovieManager(capId, capGenre, capRating, 0.75);
            movieManager.loadMovies("movies.csv");
            movieManager.printStatistics();
            System.out.println();
        }
        System.out.println("-".repeat(100));

        System.out.println("\nTest case 16: (Hash Maps performance: Different initial load factors)");
        for(double lf = 0.5; lf <= 1.5; lf *=1.5){
            System.out.println("-".repeat(100));
            System.out.println("Load Factor: " + lf);
            movieManager = new MovieManager(10_000, 4_000, 50, lf);
            movieManager.loadMovies("movies.csv");
            movieManager.printStatistics();
            System.out.println();
        }
        System.out.println("-".repeat(100));
    }
    /**
     * Method to print a list one element per line
     */
    public static void print(List<Movie> list, int n){
        int m = Math.min(n, list.size());
        for(int i= 0; i<m; i++){
            System.out.println(list.get(i));
        }
    }
}