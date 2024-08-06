package tasks.other;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCards {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            int last = deque.removeLast();
            deque.addFirst(last);
            deque.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[i] = deque.removeFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] result1 = deckRevealedIncreasing(deck1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 13, 3, 11, 5, 17, 7]

//        int[] deck2 = {1, 1000};
//        int[] result2 = deckRevealedIncreasing(deck2);
//        System.out.println(Arrays.toString(result2)); // Output: [1, 1000]
    }
}