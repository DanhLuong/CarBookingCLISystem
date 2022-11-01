package com.danh;

public class FindResult<T> {
    private boolean isExist;
    private T t;
    private int index;

    public FindResult(boolean isExist) {
        this.isExist = isExist;
    }

    public FindResult(boolean isExist, T t, int index) {
        this.isExist = isExist;
        this.t = t;
        this.index = index;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
