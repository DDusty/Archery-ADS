package nl.hva.ict.se.ads;

import java.util.*;

/**
 * Given a list of Archer's this class can be used to sort the list using one of three sorting algorithms.
 */
public class ChampionSelector {
    /**
     * This method uses either selection sort or insertion sort for sorting the archers.
     */
    public static List<Archer> selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

        int n = archers.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (archers.get(j).getTotalScore() < archers.get(min_idx).getTotalScore()) {
                    min_idx = j;
                } else if (archers.get(j).getTotalScore() == archers.get(min_idx).getTotalScore()) {
                    if (archers.get(j).getWeightedScore() < archers.get(min_idx).getWeightedScore()) {
                        min_idx = j;
                    } else if (archers.get(j).getWeightedScore() == archers.get(min_idx).getWeightedScore()) {
                        if (archers.get(j).getId() < archers.get(min_idx).getId()) {
                            min_idx = j;
                        }
                    }
                }
            // Swap the found minimum element with the first
            // element
            Archer temp = archers.get(i);
            archers.set(i, archers.get(min_idx));
            archers.set(min_idx, temp);
        }

        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers.
     */
    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        int start = 0;
        int end = archers.size() - 1;

        sort(archers, start, end);

        return archers;
    }

    /* This function takes last element as pivot, places the pivot element at its correct
       position in sorted list, and places all smaller (smaller than pivot) to left of
       pivot and all greater elements to right of pivot */
    public static int partition(List<Archer> archers, int low, int high) {
        Archer pivot = archers.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (archers.get(j).getTotalScore() < pivot.getTotalScore()) {
                i++;

                Archer temp = archers.get(i);
                archers.set(i, archers.get(j));
                archers.set(j, temp);
            } else if (archers.get(j).getTotalScore() == pivot.getTotalScore()) {
                if (archers.get(j).getWeightedScore() < pivot.getWeightedScore()) {
                    i++;

                    Archer temp = archers.get(i);
                    archers.set(i, archers.get(j));
                    archers.set(j, temp);
                } else if (archers.get(j).getWeightedScore() == pivot.getWeightedScore()) {
                    if (archers.get(j).getId() < pivot.getId()) {
                        i++;
                        Archer temp = archers.get(i);
                        archers.set(i, archers.get(j));
                        archers.set(j, temp);
                    }
                }
            }
        }

        Archer temp = archers.get(i + 1);
        archers.set(i + 1, archers.get(high));
        archers.set(high, temp);

        return i + 1;
    }


    /* QS the sorting method
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(List<Archer> archers, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(archers, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(archers, low, pi - 1);
            sort(archers, pi + 1, high);
        }
    }

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

        Collections.sort(archers, new Comparator<Archer>() {

            @Override
            public int compare(Archer o1, Archer o2) {
                int value = 0;
                if (o1.getTotalScore() < o2.getTotalScore()) {
                    value = -1;
                } else if (o1.getTotalScore() == o2.getTotalScore()) {
                    if (o1.getWeightedScore() < o2.getWeightedScore()) {
                        value = -1;
                    } else if (o1.getWeightedScore() == o2.getWeightedScore()) {
                        if (o1.getId() < o2.getId()) {
                            value = -1;
                        } else {
                            value = 1;
                        }
                    } else {
                        value = 1;
                    }
                } else {
                    value = 1;
                }
                return value;
            }
        });

        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers in such a way that it is able to cope with an Iterator.
     *
     * <b>THIS METHOD IS OPTIONAL</b>
     */
    public static Iterator<Archer> quickSort(Iterator<Archer> archers, Comparator<Archer> scoringScheme) {
        return null;
    }

}
