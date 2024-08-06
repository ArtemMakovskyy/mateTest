package live.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution349 {
    String link = "https://leetcode.com/problems/intersection-of-two-arrays/description/?source=submission-ac";
    String desc = "349. Intersection of Two Arrays";

    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        final int[] intersection1 = intersection(a, b);
        Arrays.stream(intersection1).forEach(System.out::println);

        System.out.println();

        int[] a1 = new int[]{1, 2, 2, 1};
        int[] b1 = new int[]{2, 2};
        final int[] intersection2 = intersection(a1, b1);
        Arrays.stream(intersection2).forEach(System.out::println);

    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[0];
//        result = myWorkWithCollection(nums1, nums2);
        result = ms2(nums1, nums2);
        result = ms3(nums1, nums2);
        result = ms4(nums1, nums2);
        result = msMy5(nums1, nums2);
        return result;
    }

    private static int[] msMy5(int[] nums1, int[] nums2) {
        int maxArraysLength = Math.max(nums1.length, nums2.length);
        int maxNumber = Math.max(findMaxValue(nums1), findMaxValue(nums2));
        boolean[] contains = new boolean[maxNumber + 1];
        int[] resultTemp = new int[maxArraysLength];

        for (int value : nums1) {
            contains[value] = true;
        }

        int positionCounts = 0;
        for (int value : nums2) {
            if (contains[value]) {
                resultTemp[positionCounts++] = value;
                contains[value] = false;
            }
        }

        int[] result = new int[positionCounts];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultTemp[i];
        }

        return sort(result);
    }

    private static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    private static int[] sort(int[] arr) {
        boolean sort = true;
        while (sort) {
            sort = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    sort = true;
                }
            }
        }
        return arr;
    }

    private static int[] ms4(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> result = new HashSet<>();

        for (int x : nums1) {
            result.add(x);
        }

        for (int x : nums2) {
            if (result.contains(x) && !ans.contains(x)) {
                ans.add(x);
            }
        }

        int[] intersectionArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            intersectionArray[i] = ans.get(i);
        }

        return intersectionArray;
    }

    private static int[] ms3(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        boolean[] contains = new boolean[5000];

        for (int num : nums1) {
            contains[num] = true;
        }

        for (int num : nums2) {
            if (contains[num]) {
                resultList.add(num);
                contains[num] = false;
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

    private static int[] ms2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            result[index++] = num;
        }
        return result;
    }

    private static int[] myWorkWithCollection(int[] nums1, int[] nums2) {
        final Set<Integer> integers1 = transformArrayToCollection(nums1);
        final Set<Integer> integers2 = transformArrayToCollection(nums2);
        integers1.retainAll(integers2);

        int[] result = new int[integers1.size()];
        int position = 0;
        for (Integer i : integers1) {
            result[position] = i;
            position++;
        }
        return result;
    }

    private static Set<Integer> transformArrayToCollection(int[] array) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

//    public static int[] intersection(int[] nums1, int[] nums2) {
//
//        List<Integer> result = new ArrayList<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    result.add(nums1[i]);
//                }
//            }
//        }
//
//        result.forEach(System.out::println);
//
//
//        return nums1;
//    }

}

//class Solution {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        int arrayLength = nums1.length > nums2.length ? nums1.length : nums2.length;
//        int[] result2 = new int[arrayLength];
//        int position = 0;
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    result2[position] = nums1[i];
//                    position++;
//                }
//            }
//        }
//        final int[] ints = removeDuplicatesAndZeros(result2);
//        Arrays.stream(ints).forEach(System.out::println);
//        return ints;
//
//    }
//    public int[] removeDuplicatesAndZeros(int[] array) {
//        Arrays.sort(array);
//        int uniqueCount = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != 0 && (i == 0 || array[i] != array[i - 1])) {
//                uniqueCount++;
//            }
//        }
//
//        int[] result = new int[uniqueCount];
//        int index = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != 0 && (i == 0 || array[i] != array[i - 1])) {
//                result[index++] = array[i];
//            }
//        }
//
//        return result;
//    }
//}
