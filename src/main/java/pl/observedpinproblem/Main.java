package pl.observedpinproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(getPINs("11"));  //just to check if works in console
    }

    public static List<String> getPINs(String observed) {
        List<List<String>> possibilities = new ArrayList<>();

        for (int i = 0; i < observed.length(); i++) {
            possibilities.add(adjacentNumbers(observed.charAt(i)));
        }
        List<String> solution = possibilities.get(0);

        if (possibilities.size() == 1) {
            return possibilities.get(0);
        }

        for (int i = 1; i < possibilities.size(); i++) {
            List<String> addPossibilitiesToSolution = new ArrayList<>();

            for (String c : solution) {
                for (String s : possibilities.get(i)) {
                    addPossibilitiesToSolution.add(c + s);
                }
                solution = addPossibilitiesToSolution;
            }
        }
        return solution;
    }

    public static List<String> adjacentNumbers(char c) {
        int n = Integer.parseInt(c+"");
        if(n==1) {return Arrays.asList("124".split(""));}
        if(n==2) {return Arrays.asList("1235".split(""));}
        if(n==3) {return Arrays.asList("236".split(""));}
        if(n==4) {return Arrays.asList("1457".split(""));}
        if(n==5) {return Arrays.asList("24568".split(""));}
        if(n==6) {return Arrays.asList("3569".split(""));}
        if(n==7) {return Arrays.asList("478".split(""));}
        if(n==8) {return Arrays.asList("57890".split(""));}
        if(n==9) {return Arrays.asList("689".split(""));}
        if(n==0) {return Arrays.asList("80".split(""));}
        return null;
    }
}