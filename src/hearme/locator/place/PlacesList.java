package hearme.locator.place;

/**
 * Created with IntelliJ IDEA.
 * User: Yarik
 * Date: 13.11.12
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */



import com.google.api.client.util.Key;

import java.io.Serializable;
import java.util.List;

/** Implement this class from "Serializable"
 * So that you can pass this class Object to another using Intents
 * Otherwise you can't pass to another actitivy
 * */
public class PlacesList implements Serializable {

    @Key
    public String status;

    @Key
    public List<Place> results;

}
