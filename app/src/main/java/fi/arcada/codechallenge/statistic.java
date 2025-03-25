package fi.arcada.codechallenge;

import java.util.ArrayList;

public class statistic {
    public static double calcMean(ArrayList<Double> nums) {
        System.out.println("works");
        double sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        System.out.println(sum);
        double result = sum/ nums.size();
        System.out.println(result);
        return result;
    }

}
