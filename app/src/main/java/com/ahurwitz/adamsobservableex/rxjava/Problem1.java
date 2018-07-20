package com.ahurwitz.adamsobservableex.rxjava;

import java.util.Arrays;

import rx.Observable;

public class Problem1 {
    public Observable<String> test1(){
        Integer[] array1 = {1,3,4,0,0,0};
        Integer[] array2 = {5,6,7};

        Observable<Integer> from3 = Observable.from(array1);
        Observable<Integer> from4 = Observable.from(array2);

        final int totalSize = array1.length+array2.length;
        final int array2Size = array2.length;

        return Observable
                .merge(from3, from4)
                .toSortedList()
                .map(list -> list.subList(array2Size, totalSize))
                .map(Object::toString);
    }

    public Observable<String> test2(){
        Integer[] array1 = {1,3,4,0,0,0};
        Integer[] array2 = {5,6,7};

        Observable<Integer[]> from1 = Observable.just(array1);
        Observable<Integer[]> from2 = Observable.just(array2);

        return Observable.zip(from1, from2, (integers, integers2) -> merge(integers, 3, integers2, 3))
                .map(Arrays::toString);
    }

    private Integer[] merge(Integer[] nums1, int m, Integer[] nums2, int n) {
        int i = m+n-1, j = m-1, k = n-1;
        while(j >= 0 && k >= 0){
            nums1[i--] =  (nums2[k] > nums1[j]) ? nums2[k--] : nums1[j--];
        }

        while(k >= 0){
            nums1[i--] = nums2[k--];
        }
        return nums1;
    }
}
