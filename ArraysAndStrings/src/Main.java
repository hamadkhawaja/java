import java.util.List;

public class Main {


    public static Stack sortStack(Stack main) {
        Stack sorted = new Stack(main.size);
        while (!main.isEmpty()) {
            int temp = main.pop();
            while (!sorted.isEmpty() && sorted.top() < temp) {
                main.push(sorted.pop());
            }

            sorted.push(temp);
        }
        return sorted;
    }

    public static void main(String[] args) {
        ArraysAndStrings arr = new ArraysAndStrings();
        List<String> retVal = arr.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        for (int i = 0; i < retVal.size(); i++) {
            System.out.println(retVal.get(i));
        }
    }
}
