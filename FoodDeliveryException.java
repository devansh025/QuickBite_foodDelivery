// custom exception i made for handling errors in this app
// instead of using generic Exception everywhere
public class FoodDeliveryException extends Exception {

    public FoodDeliveryException(String message) {
        super(message);
    }
}
