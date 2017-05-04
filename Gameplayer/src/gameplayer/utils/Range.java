/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.utils;

import java.util.Iterator;

/**
 *
 * @author Máté Pozsgay
 */
public class Range implements Iterable<Integer>, Iterator<Integer> {

    protected int min = 0, max = 0, cursor = 0;

    public Range() {
    }

    public Range(int fromValue, int toValue) {
        this.min = fromValue;
        this.max = toValue;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isInBoundary(int value) {
        return value >= min && value <= max;
    }

    @Override
    public Iterator<Integer> iterator() {
        cursor = min;
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor <= max;
    }

    @Override
    public Integer next() {
        return cursor++;
    }

}
