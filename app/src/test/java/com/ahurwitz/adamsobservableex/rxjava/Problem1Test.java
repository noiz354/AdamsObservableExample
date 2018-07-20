package com.ahurwitz.adamsobservableex.rxjava;

import org.junit.Test;

import java.util.Arrays;

import rx.observers.TestSubscriber;

public class Problem1Test {
    @Test
    public void shouldLoadTwoUsers() {
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        new Problem1().test1().subscribe(testSubscriber);
        testSubscriber.assertValue(Arrays.toString(new int[]{1,3,4,5,6,7}));
    }

    @Test
    public void shouldLoadTwoUsers_() {
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        new Problem1().test2().subscribe(testSubscriber);
        testSubscriber.assertValue(Arrays.toString(new int[]{1,3,4,5,6,7}));
    }
}
