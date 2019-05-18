package inheritance.user;

import inheritance.business.Business;
import inheritance.interfaces.ToString;
import inheritance.review.Review;

import java.util.List;
import java.util.ArrayList;

public class User implements ToString {
    private String name;
    private List<Review> reviews;

    public User(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public boolean hasAlreadyReviewed(Business business) {
        for (int i = 0; i < this.reviews.size(); i++) {
            if (reviews.get(i).getBusiness().getName() == business.getName()) {
                return true;
            }
        }

        return false;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public String toString() {
        return this.name + " has reviewed " + reviews.size() + " business(es).";
    }
}
