import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> arr) {
        // Write your code here.
        int flag = 0;
        int index1 = 0;
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) < arr.get(i + 1)) {
                index1 = i;
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            int low = index1;
            int high = arr.size() - 1;
            while (low < high) {
                int temp = arr.get(low);
                arr.set(low, arr.get(high));
                arr.set(high, temp);
                low++;
                high--;
            }
            return arr;
        }

        for (int j = arr.size() - 1; j >= 0; j--) {
            if (arr.get(j) > arr.get(index1)) {
                int temp = arr.get(j);
                arr.set(j, arr.get(index1));
                arr.set(index1, temp);
                break;
            }

        }

        int low = index1 + 1;
        int high = arr.size() - 1;
        while (low < high) {
            int temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);
            low++;
            high--;
        }
        return arr;
    }
}
