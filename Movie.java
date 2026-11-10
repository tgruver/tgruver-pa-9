public class Movie{
    private int id, votes;
    private String title, genre;
    private double rating;
    public Movie(int id, String title, String genre, int votes, double rating){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.votes = votes;

    }
    public int getID(){ return id;}
    public String getTitle() { return title;}
    public String getGenre() { return genre;}
    public double getRating(){ return rating;}
    public int getVotes(){ return votes;}

    public void setID(int id){ this.id = id;}
    public void setTitle(String title){ this.title = title;}
    public void setGenre(String genre){ this.genre = genre;}
    public void setRating(double rating){ this.rating = rating;}
    public void setVotes(int votes){ this.votes = votes;}

    public String toString(){
        return String.format("%-10d\t%-50s\t%-40s\t%-10d\t%.1f", id, title, genre, votes, rating);
    }
    public boolean equals(Object o){
        if(o instanceof Movie){
            Movie m = (Movie)o;
            return this.title.equals(m.title);
        }
        return false;
    }
}