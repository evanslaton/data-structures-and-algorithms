package inheritance.business;

import inheritance.interfaces.BusinessInformation;
import inheritance.interfaces.ToString;

public class Shop extends Business implements ToString, BusinessInformation {
    public Shop(String name, String price) {
        super(name, price);
    }
}
