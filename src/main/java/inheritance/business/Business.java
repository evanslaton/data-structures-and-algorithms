package inheritance.business;

import inheritance.review.Review;
import inheritance.user.User;

import java.util.List;
import java.util.ArrayList;

public class Business {
    private String name;
    private int stars;
    private String price;
    private List<Review> reviews;

    public Business(String name, String price) {
        this.name = name;
        this.stars = 0;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public int getStars() {
        return this.stars;
    }

    public void updateStars() {
        if (reviews.size() == 0) {
            this.stars = 0;
        } else {
            this.stars = getStarsAverage() / this.reviews.size();
        }
    }

    private int getStarsAverage() {
        int starTotal = 0;

        for (int i = 0; i < reviews.size(); i++) {
            starTotal += this.reviews.get(i).getStars();
        }

        return starTotal;
    }

    public void addReview(Review review) {
        User author = review.getAuthor();
        Business business = review.getBusiness();

        if (author.hasAlreadyReviewed(business)) {
            System.out.println("This user has already reviewed this business");
        } else {
            this.reviews.add(review);
            author.addReview(review);
            this.updateStars();
        }
    }

    public String toString() {
        return this.name + " has a " + this.stars +  " star rating, a price rating of " + this.price + ", and " + this.reviews.size() + " reviews.";
    }
}
