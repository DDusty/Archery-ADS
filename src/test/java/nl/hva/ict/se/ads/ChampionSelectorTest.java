package nl.hva.ict.se.ads;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionSelectorTest {
    protected Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        // Instantiate your own compaxrator here...
        // comparator = new .....();
    }

    @Test
    public void selInsSortAndCollectionSortResultInSameOrder() {
        List<Archer> unsortedArchersForSelIns = Archer.generateArchers(100);
        List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForSelIns);

        List<Archer> sortedArchersSelIns = ChampionSelector.selInsSort(unsortedArchersForSelIns, comparator);
        List<Archer> sortedArchersCollection = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);

        assertEquals(sortedArchersCollection, sortedArchersSelIns);

    }

    @Test
    public void selInsSortAndQuickSortResultInSameOrder() {
        List<Archer> unsortedArchers = Archer.generateArchers(100);
        List<Archer> unsortedArchersQs = new ArrayList<>(unsortedArchers);

        List<Archer> sortedArchersSelIns = ChampionSelector.selInsSort(unsortedArchers, comparator);
        List<Archer> sortedArchersQs = ChampionSelector.quickSort(unsortedArchersQs, comparator);


        assertEquals(sortedArchersQs, sortedArchersSelIns);

    }

    @Test
    public void ExtendedtimerInsSort() {
        long totalRuntime = 0;

        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            List<Archer> archers = Archer.generateArchers(100);
            ChampionSelector.selInsSort(archers, comparator);
            long endTime = System.currentTimeMillis();

            totalRuntime += (endTime - startTime);
        }

        System.out.println("selection sort on avg " + totalRuntime / 100 + " milliseconds");
    }

    @Test
    public void ExtendedtimerCollectionSort() {
        long totalRuntime = 0;

        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            List<Archer> archers = Archer.generateArchers(100);
            ChampionSelector.collectionSort(archers, comparator);
            long endTime = System.currentTimeMillis();

            totalRuntime += (endTime - startTime);
        }

        System.out.println("selection sort on avg " + totalRuntime / 100 + " milliseconds");
    }

    @Test
    public void ExtendedtimerQuickSort() {
        long totalRuntime = 0;

        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            List<Archer> archers = Archer.generateArchers(100);
            ChampionSelector.quickSort(archers, comparator);
            long endTime = System.currentTimeMillis();

            totalRuntime += (endTime - startTime);
        }

        System.out.println("selection sort on avg " + totalRuntime / 100 + " milliseconds");
    }

    @Test
    public void ExtendedGetChampion() {
        List<Archer> unsortedArchers = Archer.generateArchers(100);
        List<Archer> unsortedArchersQs = new ArrayList<>(unsortedArchers);

        List<Archer> sortedArchersSelIns = ChampionSelector.selInsSort(unsortedArchers, comparator);
        List<Archer> sortedArchersQs = ChampionSelector.quickSort(unsortedArchersQs, comparator);
        int lastItem = unsortedArchers.size() - 1;

        Archer championSelIns = sortedArchersSelIns.get(lastItem);
        Archer championQs = sortedArchersQs.get(lastItem);

        assertEquals(championQs, championSelIns);

        System.out.println(championQs);
    }

}
