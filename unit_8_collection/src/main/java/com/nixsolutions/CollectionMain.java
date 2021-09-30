package com.nixsolutions;

public class CollectionMain {
    public static void main(String[] args) {
        int capacity;
        System.out.println("Collections");
        System.out.println("1. default: MathSet()");
        MathSet array1 = new MathSet();
        for (Number i : array1.getListSet()) {
            System.out.println("array1 = " + i);
        }
        System.out.println("2. capacity: MathSet(int capacity)");
        capacity = 5;
        MathSet array2 = new MathSet(capacity);
        for (Number i : array2.getListSet()) {
            System.out.println("array2 = " + i);
        }

        System.out.println("3. array: MathSet(Number[] numbers)");
        Number[] n = {1, 2, 1};
        MathSet array3 = new MathSet(n);
        for (Number i : array3.getListSet()) {
            System.out.println("array3 = " + i);
        }
        System.out.println("4. array+vararg: MathSet(Number[] ... numbers)");
        Number[] a = {10, 1, 2, 10};
        Number[] b = {20, 3, 50, 5, 3};
        MathSet array4 = new MathSet(n, a, b);
        for (Number i : array4.getListSet()) {
            System.out.println("array4 = " + i);
        }
        System.out.println("5. MathSet+number: MathSet(MathSet numbers)");
        MathSet array5 = new MathSet(array4);
        for (Number i : array5.getListSet()) {
            System.out.println("array5 = " + i);
        }
        System.out.println("6. MathSet+vararg: MathSet(MathSet ... numbers)");
        MathSet array6 = new MathSet(array3, array4);
        for (Number i : array6.getListSet()) {
            System.out.println("array6 = " + i);
        }

        System.out.println("add items");
        array1.add(10);
        array1.add(8);
        array1.add(5);
        array2.add(10);
        array2.add(11);
        array2.add(10);
        array2.add(11);
        array3.add(2);
        array3.add(1);
        array3.add(11);
        array4.add(4, 5, 11, 5);
        array5.add(7, 11);
        array6.add(7);
        for (Number i : array1.getListSet()) {
            System.out.println("array1 = " + i);
        }
        for (Number i : array2.getListSet()) {
            System.out.println("array2 = " + i);
        }
        for (Number i : array3.getListSet()) {
            System.out.println("array3 = " + i);
        }
        for (Number i : array4.getListSet()) {
            System.out.println("array4 = " + i);
        }
        for (Number i : array5.getListSet()) {
            System.out.println("array5 = " + i);
        }
        for (Number i : array6.getListSet()) {
            System.out.println("array6 = " + i);
        }
        System.out.println("join items");
        array6.join(array1);
        array5.join(array3, array2);
        for (Number i : array5.getListSet()) {
            System.out.println("array5 = " + i);
        }
        for (Number i : array6.getListSet()) {
            System.out.println("array6 = " + i);
        }
        System.out.println("intersection items");
        array1.intersection(array2);
        for (Number i : array1.getListSet()) {
            System.out.println("array1 = " + i);
        }
        array3.intersection(array2, array4);
        for (Number i : array3.getListSet()) {
            System.out.println("array3 = " + i);
        }

        System.out.println("sort");
        array5.sortDesc();
        for (Number i : array5.getListSet()) {
            System.out.println("sortDesc() array5 = " + i);
        }
        array6.sortDesc(4, 7);
        for (Number i : array6.getListSet()) {
            System.out.println("sortDesc(4, 7) array6= " + i);
        }
        array3.sortDesc(3);
        for (Number i : array3.getListSet()) {
            System.out.println("sortDesc(3) array3 = " + i);
        }

        array5.sortAsc();
        for (Number i : array5.getListSet()) {
            System.out.println("sortAsc() array5 = " + i);
        }
        array6.sortAsc(4, 7);
        for (Number i : array6.getListSet()) {
            System.out.println("sortAsc(4, 7) array6= " + i);
        }
        array3.sortAsc(3);
        for (Number i : array3.getListSet()) {
            System.out.println("sortAsc(3) array3 = " + i);
        }

        System.out.println("get index array6 value 3 - " + array6.get(3));
        System.out.println("get max array6 - " + array6.getMax());
        System.out.println("get min array6 - " + array6.getMin());
        System.out.println("get average array6 - " + array6.getAverage());
        System.out.println("get median array6 - " + array6.getMedian());
        System.out.println("toArray array6 - ");
        for (Number i : array6.toArray()) {
            System.out.println("i " + i + " ");
        }
        for (Number j : array6.toArray(3, 5)) {
            System.out.println("j " + j + " ");
        }
        for (Number i : array6.cut(4, 7).getListSet()) {
            System.out.println("cut array6 - " + i);
        }
        array5.clear();
        for (Number i : array5.getListSet()) {
            System.out.println("clear array5 - " + i);
        }
        Number[] tmp = {3, 5, 8, 50};
        array6.add(12);
       array6.clear(tmp);
        for (Number i : array6.getListSet()) {
            System.out.println("clear {3, 5, 8, 50} in array6 - " + i);
        }


    }
}
