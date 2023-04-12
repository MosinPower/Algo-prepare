package com.github.mosinpower;

import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        if(!isPresent) {
            int index = list.size();
            list.add(val);
            map.put(val, index);
        }
        return !isPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        list.set(idx, list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randIndex = random.nextInt(list.size());
        return list.get(randIndex);
    }
}