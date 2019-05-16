package inheritance.business;

import inheritance.review.Review;
import inheritance.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void testRestaurant() {
        Shop mcDonalds = new Shop("McDonalds", "$");

        User evan = new User("Evan");
        User joe = new User("Joe");

        Review evanReview = new Review("Delicious", evan, 5, mcDonalds);
        Review evanReview2 = new Review("Amazing", evan, 5, mcDonalds);
        Review joeReview = new Review("Delicious", joe, 4, mcDonalds);

        mcDonalds.addReview((evanReview));
        mcDonalds.addReview((evanReview2));
        mcDonalds.addReview(joeReview);

        System.out.println(mcDonalds.toString() + "\n");
        System.out.println(evan.toString());
        System.out.println(joe.toString());
    }

}