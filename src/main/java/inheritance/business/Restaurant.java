package inheritance.business;

import inheritance.interfaces.BusinessInformation;
import inheritance.interfaces.ToString;

public class Restaurant extends Business implements ToString, BusinessInformation {
    public Restaurant(String name, String price) {
        super(name, price);
    }
}
