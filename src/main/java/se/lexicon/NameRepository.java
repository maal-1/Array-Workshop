package se.lexicon;

import java.util.ArrayList;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {

        NameRepository.names = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            NameRepository.names[i] = names[i].strip();
        }

    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];;
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        return names.clone();
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName))
                return name;
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        if (find(fullName) == null) {
            String [] newNamesArray = new String[names.length+1];
            for (int i = 0; i < names.length; i++) {
                newNamesArray[i] = names[i];
            }
            newNamesArray[names.length] = fullName.strip();
            names = newNamesArray;
            return true;
        }

        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        ArrayList<String> matchingNames = new ArrayList<>();
        for (String name : names) {
            if (name.substring(0, name.indexOf(' ')).equalsIgnoreCase(firstName)) {
                matchingNames.add(name);
            }

        }
        if (matchingNames.size() == 0)
            return null;
        else {
            String[] matchingNamesArray = new String[matchingNames.size()];
            return (matchingNames.toArray(matchingNamesArray));
        }
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        ArrayList<String> matchingNames = new ArrayList<>();
        for (String name : names) {
            if (name.substring(name.indexOf(' ')+1).equalsIgnoreCase(lastName)) {
                matchingNames.add(name);
            }
        }

        if (matchingNames.size() == 0)
            return null;
        else {
            String[] matchingNamesArray = new String[matchingNames.size()];
            return (matchingNames.toArray(matchingNamesArray));
        }
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        String findOriginal = find(original);
        if (findOriginal == null) {
            return false;

        } else if (findOriginal.equalsIgnoreCase(updatedName)) {
            return false;

        } else {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(original))
                    names[i] = updatedName;
            }
            return true;
        }

    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {

        int index = -1;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName.strip())){
                index = i;
                break;
            }
        }

        //false if the name is not found in the array
        if (index == -1) {
            return false;

        } else {
            String[] newNamesArray = new String[names.length - 1];

            for (int i = 0; i < newNamesArray.length; i++) {

                if (i >= index){
                    newNamesArray[i] = names[i+1];
                    continue;
                }
                newNamesArray[i] = names[i];
            }

            names = newNamesArray;
            return true;
        }
    }


}