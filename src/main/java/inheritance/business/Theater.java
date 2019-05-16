package inheritance.business;

import java.util.ArrayList;
import java.util.List;

public class Theater extends Business {
    private List<String> movies;

    public Theater(String name, String price) {
        super(name, price);
        this.movies = new ArrayList<>();
    }

    public void addMovie(String movie) {
        if (this.hasMovie(movie)) {
            System.out.println(this.getName() + " already has " + movie);
        } else {
            this.movies.add(movie);
        }
    }

    public void removeMovie(String movie) {
        if (this.hasMovie(movie)) {
            this.movies.remove(movie);
        } else {
            System.out.println(this.getName() + " doesn't have " + movie);
        }
    }

    private boolean hasMovie(String movie) {
        return this.movies.contains(movie);
    }

    public String toString() {
        String theaterInfo = this.getName() + " has a " + this.calculateStars() + " star rating, " + this.getReviews().size() + " reviews and is showing:\n";

        for (int i = 0; i < this.movies.size(); i++) {
            theaterInfo += this.movies.get(i) + "\n";
        }

        return theaterInfo;
    }
}
