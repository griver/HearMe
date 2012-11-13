package hearme.environment;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 */
public class Location implements Comparable<Location> {

    public String getLocationName(){
        //ToDo: Somebody must either delete or implements me!
        return "Default Location";
    }

    @Override
    public int compareTo(Location location) {
        return 0;
    }
}
