import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamad on 6/14/2016.
 */
public class TwoSum {
    private Map<Integer, Integer> table = new HashMap<>();

    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count + 1);
    }

    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> entry: table.entrySet()) {
            int find = val - entry.getKey();
            if (find == val ) {
                return (entry.getValue() >= 2);
            } else if (table.containsKey(find)) {
                return true;
            }
        }
        return false;
    }
}
