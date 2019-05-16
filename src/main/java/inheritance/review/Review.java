package inheritance.review;

import inheritance.business.Business;
import inheritance.user.User;

public class Review {
    private String body;
    private User author;
    private int stars;
    private Business business;

    public Review(String body, User author, int stars, Business business) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.business = business;
    }

    public String getBody() {
        return this.body;
    }

    public User getAuthor() {
        return this.author;
    }

    public int getStars() {
        return this.stars;
    }

    public Business getBusiness() {
        return this.business;
    }

    public String toString() {
        return "Author: " + this.author.getName() + "\nStar Rating: " + this.stars + "\nReview: " + this.body;
    }

    public void updateStars(int stars) {
        this.stars = stars;
    }
}
