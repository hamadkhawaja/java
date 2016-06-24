import java.util.List;

/**
 * Created by Hamad on 6/24/2016.
 */
public class ListOfListsItt {
    List<List<String>> lists = null;
    int indMinor = 0;
    int indMajor = 0;
    boolean foundNext = false; // used to check if hasNext has been called.

    ListOfListsItt(List<List<String>> input) {
        lists = input;
    }

    public boolean hasNext() {
        // If lists are null
        if (lists == null) {
            return false;
        }

        // if we are on the last index of the last list
        if (indMajor == lists.size() && indMinor == lists.get(indMajor).size()) {
            return false;
        }

        foundNext = false;
        // Keep on looping till we find a valid element.
        while (indMajor < lists.size()) {
            if (lists.get(indMajor) != null) {
                while (indMinor < lists.get(indMajor).size() &&
                        lists.get(indMajor).get(indMinor).isEmpty()){
                    indMinor++;
                }

                if (indMinor < lists.get(indMajor).size()) {
                    foundNext = true;
                    return true;
                }
            }

            indMinor = 0;
            indMajor++;
        }

        return false;
    }

    public String getNext() {
        if (foundNext || hasNext()) {
            foundNext = false;
            return lists.get(indMajor).get(indMinor);
        }

        throw new RuntimeException("No more elements exception.");
    }
}
