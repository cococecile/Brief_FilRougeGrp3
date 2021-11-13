package group3.gestionpersonnel.business.utils;

/**
 * Contains method to check if required values are provided
 * 
 * @author Caroline
 */
public class NullChecker {

    /**
     * Checks if an object is null and, if the object is a string, also checks if
     * it's empty.
     * 
     * @param <T> the type of the object to check
     * @param objectToCheck the object to check
     * @return true if object is not null and not empty, false otherwise.
     */
    public static boolean isNotNullAndNotEmpty(Object objectToCheck) {
        Boolean result = false;
        if (objectToCheck != null) {
            result = true;
        }
        if (objectToCheck.getClass().equals(String.class) && ((String) objectToCheck).trim().isEmpty()) {
            result = false;
        }
        return result;
    }

}
