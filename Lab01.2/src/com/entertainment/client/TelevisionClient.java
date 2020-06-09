package com.entertainment.client;

import com.entertainment.DisplayType;
import com.entertainment.IllegalChannelAssignmentException;
import com.entertainment.Television;

public class TelevisionClient {
    public static void main(String[] args) {
        Television emptyTV = new Television();
        Television brandVolumeTV = new Television(
                "Sony", 50);

        System.out.println(emptyTV);
        System.out.println(brandVolumeTV);

        try {
            emptyTV.changeChannel(43);
            System.out.println(emptyTV);
        } catch (IllegalChannelAssignmentException e) {
            e.printStackTrace();
        }

        Television tvA = new Television();
        Television tvB = new Television();

        // false. not same instance
        System.out.println(tvA == tvB);
        // false. no .equals() override
        System.out.println(tvA.equals(tvB));

        tvA = new Television("Sony", 50, DisplayType.LED);
        tvB = new Television("Sony", 50, DisplayType.LED);

        System.out.println("\n" + tvA);

        System.out.println("\ndisplay type equals test");
        System.out.println(tvA.equals(tvB));
        System.out.println("\ndisplay type hashCode test");
        System.out.println(tvA.hashCode() == tvB.hashCode());
    }
}
