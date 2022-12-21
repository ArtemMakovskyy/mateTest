package main.collection.list;

import java.util.List;

public class ListElementsAddition {
    public int calculateSum(List<Integer> integerList) {
        if (integerList == null){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
        }
        return sum;
    }
}
