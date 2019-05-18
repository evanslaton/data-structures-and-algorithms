package inheritance.review;

import inheritance.business.Business;
import inheritance.interfaces.ToString;
import inheritance.user.User;

public class TheaterReview extends Review implements ToString {
    private String movie;

    public TheaterReview(String body, User author, int stars, Business business, String movie) {
        super(body, author, stars, business);
        this.movie = movie;
    }

    public String toString() {
        return "Author: " + this.getAuthor().getName() + "\nStar Rating: " + this.getStars() + "\nMovie: " + this.movie + "\nReview: " + this.getBody();
    }
}
