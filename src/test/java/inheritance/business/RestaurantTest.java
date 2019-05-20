package inheritance.business;

import inheritance.interfaces.BusinessInformation;
import inheritance.review.Review;
import inheritance.review.TheaterReview;
import inheritance.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void testRestaurant() {
        Theater amcLennox24 = new Theater("AMC Lennox 24", "$");

        User evan = new User("Evan");
        User joe = new User("Joe");

        Review evanReview = new TheaterReview("Delicious", evan, 5, amcLennox24, "Endgame");
        Review evanReview2 = new Review("Amazing", evan, 5, amcLennox24);
        Review joeReview = new Review("Delicious", joe, 4, amcLennox24);
        joeReview.updateStars(0);

        amcLennox24.addReview((evanReview));
        amcLennox24.addReview((evanReview2));
        amcLennox24.addReview(joeReview);

        amcLennox24.addMovie("Endgame");
        amcLennox24.addMovie("Endgame");
        amcLennox24.addMovie("Tolkien");
        amcLennox24.addMovie("Star Wars");

        System.out.println(evan.toString());
        System.out.println(joe.toString());
        System.out.println(amcLennox24.toString() + "\n");

        amcLennox24.removeMovie("Endgame");
        System.out.println("***");
        System.out.println(amcLennox24.toString() + "\n");

        System.out.println(joeReview.toString());

        BusinessInformation bi = new Restaurant("Burger King", "$");
        System.out.println(bi.toString());
    }

}