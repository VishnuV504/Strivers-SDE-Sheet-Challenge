import java.util.*;

public class Solution {
    public static int largestRectangle(ArrayList<Integer> heights) {
        int[] NextSmallerElementToRight = new int[heights.size()];
        int[] NextSmallerElementToLeft = new int[heights.size()];
        Stack<Integer> IndexLeft = new Stack<>();
        Stack<Integer> IndexRight = new Stack<>();

        for (int i = 0; i < heights.size(); i++) {
            if (IndexLeft.isEmpty())
                NextSmallerElementToLeft[i] = -1;
            else if (heights.get(IndexLeft.peek()) < heights.get(i))// next smaller element to right
                NextSmallerElementToLeft[i] = IndexLeft.peek();
            else {
                while (!IndexLeft.isEmpty()) {
                    if (heights.get(IndexLeft.peek()) < heights.get(i))
                        break;
                    IndexLeft.pop();
                }
            }
            if (IndexLeft.isEmpty())
                NextSmallerElementToLeft[i] = -1;
            else
                NextSmallerElementToLeft[i] = IndexLeft.peek();
            IndexLeft.push(i);

        }

        for (int i = heights.size() - 1; i >= 0; i--) {
            if (IndexRight.isEmpty())
                NextSmallerElementToRight[i] = heights.size();
            else if (heights.get(IndexRight.peek()) < heights.get(i))// next smaller element to right
                NextSmallerElementToRight[i] = IndexRight.peek();
            else {
                while (!IndexRight.isEmpty()) {
                    if (heights.get(IndexRight.peek()) < heights.get(i))
                        break;
                    IndexRight.pop();
                }
            }
            if (IndexRight.isEmpty())
                NextSmallerElementToRight[i] = heights.size();
            else
                NextSmallerElementToRight[i] = IndexRight.peek();
            IndexRight.push(i);

        }

        int Maxhistogram = 0;
        int histogramArea = 0;
        for (int i = 0; i < heights.size(); i++) {
            histogramArea = (NextSmallerElementToRight[i] - NextSmallerElementToLeft[i] - 1) * heights.get(i);
            if (Maxhistogram < histogramArea)
                Maxhistogram = histogramArea;
        }
        return Maxhistogram;
    }
}