package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {
    @Override
    public int compare(Television o1, Television o2) {
        int result;
        int brandComparison = o1.getBrand().compareTo(o2.getBrand());
        if(brandComparison == 0) {
            result = Integer.compare(o1.getCurrentChannel(), o2.getCurrentChannel());
        } else {
            result = brandComparison;
        }
        return result;
    }
}
