import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println((finishTime - startTime) / 1000000);
    }

    private void run() throws IOException {
        int[] arrayToSearch = readFromFile();
        System.out.println(getSeqSubLength(arrayToSearch));
    }

    private int getSeqSubLength(int[] arrayToSearch) {
        int[] results = new int[arrayToSearch.length];
        for (int i = 0; i < arrayToSearch.length; i++) {
            results[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arrayToSearch[i] >= arrayToSearch[j]
                        && arrayToSearch[i] % arrayToSearch[j] == 0
                        && results[j] + 1 > results[i])
                    results[i]++;
            }
        }
        int max = 0;
        for (int currLength :
                results) {
            if (currLength > max) max = currLength;
        }
        return max;
    }

    private int[] readFromFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("./src/Test.txt"));
        int size = Integer.parseInt(bf.readLine());
        int[] result = new int[size];
        String[] tokens = bf.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }
}