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
        int []array = {0, 1, 2, 3, 4, 5, 6};
        int []result = arr.rotateArray(array, 3);

        for (int i =0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
