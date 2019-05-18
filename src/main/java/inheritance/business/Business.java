package inheritance.business;

import inheritance.interfaces.BusinessInformation;
import inheritance.interfaces.ToString;
import inheritance.review.Review;
import inheritance.user.User;

import java.util.List;
import java.util.ArrayList;

public class Business implements ToString, BusinessInformation {
    private String name;
    private String price;
    private List<Review> reviews;

    public Business(String name, String price) {
        this.name = name;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public int calculateStars() {
        int stars;

        if (reviews.size() == 0) {
            stars = 0;
        } else {
            stars = getStarsAverage() / this.reviews.size();
        }

        return stars;
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
        }
    }

    public String toString() {
        return this.name + " has a " + this.calculateStars() +  " star rating, a price rating of " + this.price + ", and " + this.reviews.size() + " reviews.";
    }
}
