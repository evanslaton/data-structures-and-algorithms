package inheritance.business;

import inheritance.review.Review;
import inheritance.user.User;

public class Res extends Business {
    private Review review;

    public Res(String name, String price, String body, User author, int stars) {
        super(name, price);
        this.review = new Review(body, author, stars, this);
    }

    public static void main(String[] args) {
        Res r = new Res("KFC", "$", "Okay food", new User("Bob"), 2);
        System.out.println(r.review.toString());
    }
}
