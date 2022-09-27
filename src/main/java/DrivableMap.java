/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /* TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     */
    public boolean addDrivable(String id, Drivable item) {
        if (drivable_map.containsKey(id)) {
            return false;
        } else {
            drivable_map.put(id, item);
            return true;
        }
    }




    /* TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */
    public boolean hasFasterThan(int speed) {
        ArrayList<String> drivable_keys = new ArrayList<>(drivable_map.keySet());
        for(int i = 0; i < drivable_map.size(); i++) {
            Drivable drivable_value = drivable_map.get(drivable_keys.get(i));
            if ((drivable_value != null && drivable_value.getMaxSpeed() >= speed)){
                return true;
            }
        }
        return false;
    }





    /* TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     */
    public ArrayList<Tradable> getTradable() {
        ArrayList<Tradable> tradable_list = new ArrayList<>();
        ArrayList<String> drivable_keys = new ArrayList<>(drivable_map.keySet());
        for(int i = 0; i < drivable_map.size(); i++) {
            Drivable drivable_value = drivable_map.get(drivable_keys.get(i));
            if (drivable_map.get(drivable_keys.get(i)) instanceof Tradable) {
                Tradable tradable_value = (Tradable) drivable_value;
                tradable_list.add(tradable_value);
            }
        }
        return tradable_list;
    }


    
}