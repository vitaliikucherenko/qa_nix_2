package com.nixsolutions;

public class MathSet {
    private int capacity = 16;
    private Number[] listSet;
    int index = 0;

    //constructors
    public MathSet() {
        this.listSet = new Number[capacity];
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        this.listSet = new Number[capacity];
    }

    public MathSet(Number[] numbers) {
        this.listSet = new Number[capacity];
        for (Number i : numbers) {
            add(i);
        }
    }

    public MathSet(Number[]... numbers) {
        this.listSet = new Number[capacity];
        for (Number[] in : numbers) {
            for (Number i : in) {
                add(i);
            }
        }
    }

    public MathSet(MathSet numbers) {
        this.listSet = numbers.toArray();
        this.capacity = this.listSet.length;
    }

    public MathSet(MathSet... numbers) {
        this.listSet = joinSet(numbers);
    }

    //methods

    public void add(Number n) {
        if (!existN(listSet, n)) {
            if (capacity > index) {
                listSet[index] = n;
                index++;
            } else {
                Number[] tmp = listSet;
                capacity = (capacity * 3 / 2) + 1;
                listSet = new Number[capacity];
                for (int i = 0; i < index; i++) {
                    listSet[i] = tmp[i];
                }
                add(n);
            }
        }
    }

    public void add(Number... n) {
        for (Number i : n) {
            add(i);
        }
    }

    public void join(MathSet ms) {
        this.listSet = joinSet(this, ms);
    }

    public void join(MathSet... ms) {
        for (MathSet current : ms) {
            this.listSet = joinSet(this, current);
        }
    }

    public void intersection(MathSet ms) {
        if (this.getListSet().length >= ms.getListSet().length) {
            this.setListSet(intMathSet(ms, this));
        } else {
            this.setListSet(intMathSet(this, ms));
        }
    }

    public void intersection(MathSet... ms) {
        for (MathSet tmp : ms) {
            if (this.getListSet().length >= tmp.getListSet().length) {
                this.setListSet(intMathSet(tmp, this));
            } else {
                this.setListSet(intMathSet(this, tmp));
            }
        }
    }

    public void sortDesc() {
        Number tmp;
        for (int i = 1; i < listSet.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(listSet[j] == null) && listSet[j].doubleValue() > listSet[j - 1].doubleValue()) {
                    tmp = listSet[j];
                    listSet[j] = listSet[j - 1];
                    listSet[j - 1] = tmp;
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        Number tmp;
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(listSet[j] == null) && listSet[j].doubleValue() > listSet[j - 1].doubleValue()) {
                    tmp = listSet[j];
                    listSet[j] = listSet[j - 1];
                    listSet[j - 1] = tmp;
                }
            }
        }
    }

    public void sortDesc(Number value) {
        int i = getIndex(value);
        sortDesc(i, listSet.length - 1);
    }

    public void sortAsc() {
        Number tmp;
        for (int i = 1; i < listSet.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(listSet[j] == null) && listSet[j].doubleValue() < listSet[j - 1].doubleValue()) {
                    tmp = listSet[j];
                    listSet[j] = listSet[j - 1];
                    listSet[j - 1] = tmp;
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        Number tmp;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(listSet[j] == null) && listSet[j].doubleValue() < listSet[j - 1].doubleValue()) {
                    tmp = listSet[j];
                    listSet[j] = listSet[j - 1];
                    listSet[j - 1] = tmp;
                }
            }
        }
    }

    public void sortAsc(Number value) {
        int i = getIndex(value);
        sortAsc(i, listSet.length - 1);
    }

    public Number get(int index) {
        return this.getListSet()[index];
    }

    public Number getMax() {
        MathSet ms = new MathSet(this.getListSet());
        ms.sortDesc();
        return ms.getListSet()[0];
    }

    public Number getMin() {
        MathSet ms = new MathSet(this.getListSet());
        ms.sortAsc();
        return ms.getListSet()[0];
    }

    public Number getAverage() {
        Number sum = 0;
        int count = 0;
        Number res = 0;
        for (int i = 0; i < listSet.length; i++) {
            if (listSet[i] != null) {
                sum = sum.doubleValue() + listSet[i].doubleValue();
                count++;
            }
        }
        if (count > 0) {
            return res = sum.doubleValue() / count;
        } else {
            return null;
        }
    }

    public Number getMedian() {
        Number m = 0;
        MathSet ms = new MathSet(this.getListSet());
        ms.sortAsc();
        int count = 0;
        for (int i = 0; i < listSet.length; i++) {
            if (listSet[i] != null) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else if (count % 2 == 0) {
            m = (ms.getListSet()[count / 2].doubleValue() + ms.getListSet()[count / 2].doubleValue()) / 2;
        } else {
            m = ms.getListSet()[count / 2];
        }
        return m;
    }

    public Number[] toArray() {
        return this.getListSet();
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        int index = 0;
        Number[] result = new Number[lastIndex - firstIndex + 1];
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            result[index] = this.getListSet()[i];
            index++;
        }
        return result;
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        Number[] mas = this.toArray(firstIndex, lastIndex);
        MathSet ms = new MathSet();
        ms.setListSet(mas);
        return ms;
    }

    public void clear() {
        for (int i = 0; i < getListSet().length; i++) {
            listSet[i] = null;
        }
    }

    public void clear(Number[] numbers) {
        int j;
        for (Number n : numbers) {
            j=getIndex(n);
            this.listSet[j] = null;
            for (int i = j; i < this.listSet.length; i++) {
                if (i == this.listSet.length - 1) {
                    this.listSet[i] = null;
                } else {
                    this.listSet[i] = this.listSet[i + 1];
                }
            }
        }
    }

    private int getIndex(Number n) {
        int index = 0;
        if (existN(this.getListSet(), n)) {
            while (this.getListSet()[index] != n) {
                index++;
            }
        }
        return index;
    }

    public Number[] getListSet() {
        return listSet;
    }

    public void setListSet(Number[] numbers) {
        this.listSet = numbers;
    }

    private Number[] joinSet(MathSet... numbers) {
        int size = 0;
        int current = 0;
        for (MathSet num : numbers) {
            size += num.getListSet().length;
        }
        Number[] allNumbers = new Number[size];
        for (MathSet num : numbers) {
            for (Number n : num.getListSet()) {
                allNumbers[current] = n;
                current++;
            }
        }
        return getUniqueValues(allNumbers);
    }

    private Number[] getUniqueValues(Number[] numbers) {
        Number[] result = new Number[numbers.length];
        int resultCount = 0;
        boolean isPresent;
        for (int i = 0; i < numbers.length; i++) {
            isPresent = false;
            for (int j = 0; j < i; j++) {
                isPresent = existN(result, numbers[i]);
            }
            if (!(numbers[i] == null) && isPresent == false) {
                result[resultCount] = numbers[i];
                resultCount++;
            }
        }
        return result;
    }

    private Number[] intMathSet(MathSet msShort, MathSet msLong) {
        int resultCount = 0;
        for (int i = 0; i < msShort.getListSet().length; i++) {
            if (existN(msLong.getListSet(), msShort.getListSet()[i])) {
                resultCount++;
            }
        }
        Number[] result = new Number[resultCount];
        resultCount = 0;
        for (int i = 0; i < msShort.getListSet().length; i++) {
            if (existN(msLong.getListSet(), msShort.getListSet()[i])) {
                result[resultCount] = msShort.getListSet()[i];
                resultCount++;
            }
        }
        return result;
    }

    private boolean existN(Number[] tmp, Number n) {
        if (n != null) {
            for (Number i : tmp) {
                if (i != null && i.doubleValue() == n.doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

}