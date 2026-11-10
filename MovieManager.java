import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Set;

public class MovieManager {
    private HashMap<Integer, Movie> moviesByID;
    private HashMap<String, List<Movie>> moviesByGenre;
    private HashMap<Double, List<Movie>> moviesByRating;
    /**
     * Constructor with two parameters
     * @param initialCapacity of the three hashmaps
     * @param loadFactor the load factor of the three hashmaps
     */
    public MovieManager(int iCap1, int iCap2, int iCap3, double loadFactor){
        
    }
    /**
     * getter for the number of movies in the hashmap moviesByID
     * @return
     */
    public int size(){
        return 0;
    }
    /**
     * Method to read the movie information from a CSV file
     * @param filename the file to read data from
     */
    public void loadMovies(String filename){
        
    }
    /**
     * Method to lookup a movie using the id
     * @param id the id of the movie being looked up
     * @return the movie object if found, null otherwise
     */
    public Movie findMovieByID(int id){
        return null;
    }
    /**
     * Method to get the list of movies of a given genre
     * @param genre the genre being looked up
     * @return the list of movies of the given genre
     */
    public List<Movie> getMoviesByGenre(String genre){
        
        return null;
    }
    /**
     * Method to get the list of movies of a given rating
     * @param rating the genre being looked up
     * @return the list of movies of the given rating
     */
    public List<Movie> getMoviesByRating(double rating){
        
        return null;
    }
    /**
     * find movie by title
     * @param genre
     * @param n
     * @return
     */
    public boolean findMovieByTitle(String title){

        return false;
    }

    /**
     * get a list of all the genres
     * @return a list of the genres
     */
    public Set<String> getAllGenres(){

        return null;
    }
    /**
     * Method to get the top n rated movies with a given genre
     * @param genre of the movies being looked up
     * @param n the number of movies to return
     * @return the list of the n top rated (rating then votes) movies of the given genre
     */
    public List<Movie> getTopMovies(String genre, int n){
        
        return null;

    }
    /**
     * Method to get the list of highly rated movies
     * @param minRating the minimum rating the movies should have
     * @param minVotes the minimum number of votes the movies should have
     * @return the list of movies meeting the given crietria sorted by rating in descending order
     */
    public List<Movie> getHighlyRatedMovies(double minRating, int minVotes){
       
       return null;
    }
    /**
     * Sort the list of movies by genre, then by number of votes, and finally by rating
     * uses quicksort to sort by genre, radix sort to sort by number of votes, and bucket sort to sort by rating
     * @return the list of movies sorted by genre in ascending order, number of votes in ascending order, then by rating in ascending order
     */
    public List<MapEntry<String, List<Movie>>> getMoviesByGenreThenVotesThenRating(){
        
        return null;
    }

    /**
     * Method to print performance measurements of the hash tables
     * for each hash table, print: (on the same line)
     * 1. name of the hashtable
     * 2. size
     * 3. capacity
     * 4. load factor
     * 5. total number of collisions
     * 6. distribution of the bucket sizes
     */
    public void printStatistics(){
        System.out.println("\nPerformance of the three hashmaps");
        System.out.printf("%-10s\t%-10s\t%-10s\t%-12s\t%-12s\t%-15s\n", "HashMap", "Size", "Capacity", "LoadFactor", "Collisions", "Bucket Size Distribution");
        System.out.printf("%-10s\t", "moviesByID");
        if(moviesByID != null)
            moviesByID.printStatistics();
        System.out.println();
        System.out.printf("%-10s\t", "moviesByGenre");
        if(moviesByGenre != null)
            moviesByGenre.printStatistics();
        System.out.println();
        System.out.printf("%-10s\t", "moviesByRating");
        if(moviesByRating != null)
            moviesByRating.printStatistics();
    }
    /*************************************************************************
     *                        Private Methods                                *
     *************************************************************************/
    /**
     * quickSort algorithm for a list of pairs (genre, list of movies)
     * @param list the list of movies to be sorted
     * @param start the index of the start of the current part
     * @param end the index of the end of the current part
     */
    private void quickSort(List<MapEntry<String, List<Movie>>> list, int first, int last){
        
    }
    /**
     * Method to partition a list in two parts
     * @param list the list to partition
     * @param first the starting index of the part to partion in list
     * @param last the ending index of the part to partition in list
     * @return the index of the pivot
     */
    private int partition(List<MapEntry<String, List<Movie>>> list, int first, int last){
        
        return 0;
    }
    /**
     * radixSort algorithm to sort a list of movies by number of votes
     * @param list to be sorted
     */
    private void radixSort(List<Movie> list){
        
    }
/**
     * bucketSort algorithm to sort a list of movies by rating
     * @param list the list of movies to be sorted
     * uses the value of the rating multiplied by 10 as an int to select the bucket
     */
    private void bucketSort(List<Movie> list){
        
    }

    /**
     * Method to find the maximum value of the number of votes in a list of movies
     * @param list of the movies
     * @return the largest value of number of votes
     */
    private int maxVotes(List<Movie> list){
    
        return 0;
    }
    /**
     * Method to find the maximum value of the ratings in list
     * @param list the list of movies
     * @return the largest value of the ratings multiplied by 10 and returned as an int
     */
    private int maxRating(List<Movie> list){
        
        return 0;
    }

}
