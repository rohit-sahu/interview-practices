package io.devzona.interview_practices.company;

public class Ford {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 7, 9, 10, 12, 14, 16};
        int first = 0;
        int last = arr.length - 1;
        int mid = first + (last - first) / 2;
        System.out.println(binarySearch(arr, first, last, 9));
        System.out.println(binarySearch1(arr, first, last, mid, 10));
    }

    public static int binarySearch(int[] arr, int first, int last, int a) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if(arr[mid] == a) {
                return mid;
            }
            if(arr[mid] > a) {
                //last  = mid - 1;
                //mid = first + (last - first) / 2;
                return binarySearch(arr, first, mid - 1, a);
            } else {
                //first  = mid + 1;
                //mid = first + (last - first) / 2;
                return binarySearch(arr, mid + 1, last, a);
            }
        }
        return -1;
    }

    public static int binarySearch1(int[] arr, int first, int last, int mid, int a) {
        while (last >= first) {
            if(arr[mid] == a) {
                return mid;
            }
            if(arr[mid] > a) {
                last  = mid - 1;
                mid = first + (last - first) / 2;
            } else {
                first  = mid + 1;
                mid = first + (last - first) / 2;
            }
        }
        return -1;
    }
}
