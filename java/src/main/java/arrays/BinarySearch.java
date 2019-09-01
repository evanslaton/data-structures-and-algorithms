package arrays;

public class BinarySearch {

    public static int binarySearch(int[] sortedArray, int searchKey) {
        int SEARCH_KEY_NOT_FOUND = -1;

        if (!isSorted(sortedArray)) {
            return SEARCH_KEY_NOT_FOUND;
        }

        int left = 0;
        int middle;
        int right = sortedArray.length - 1;

        while (left <= right) {
            middle = ((left + right) / 2);

            if (sortedArray[middle] < searchKey) {
                left = middle + 1;
            } else if (sortedArray[middle] > searchKey) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return SEARCH_KEY_NOT_FOUND;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
