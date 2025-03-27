package org.example;

import org.example.Card.Suit;

import java.util.*;

public class HandEvaluator {

    public ArrayList<Card> stringToCards(String str) {
        try {
            ArrayList<Card> cards = new ArrayList<>();
            String[] splitStr = str.split(",");

            for (String code : splitStr) {
                cards.add(new Card(code));
            }

            System.out.println(str);
            return cards;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Argument must be comma seperated codes e.g. As,5c,3d,Th,9c");
        }
    }

    public int[] fiveCardStrength(ArrayList<Card> cards) {
        /*
        Function to calculate the strength of 5 cards.
        For any hand I calculate an int array which describes the strength of the hand.
        For any 2 hands with respective int arrays strength1 and strength 2.
        strength1 > strength2 if strength1[i] > strength2[i] for the first i, where strength1[i] != strength2[i]
        e.g.
        hand1 = Ah,As,Kc,5d,2h      strength1 = [2, 14, 13, 5, 2]   Pair: A, Kickers: K, 5, 2
        hand2 = 3h,3s,3c,Td,Js      strength2 = [4, 3, 11, 10]      Trips: 3, Kickers: J, T
        strength2 > strength1 because strength2[0] > strength1[0]

        hand3 = 7d,7c,7s,Ad,Ks     strength3 = [4, 7, 14, 13]       Trips: 7, Kickers: A, K
        strength3 > strength2 because strength3[1] > strength2[1] and strength3[0] == strength2[0]

        The first strength number refers to the relative hand (4 = trips, 2 = pair, 10 = royal flush)
        The subsequent numbers are the kickers in decreasing order of importance

        Hand rankings:
        10. Royal Flush
        9.  Straight Flush
        8.  Quads
        7.  Full House
        6.  Flush
        5.  Straight
        4.  Three of a king (trips)
        3.  Two Pair
        2.  One Pair
        1.  High Card
         */

        /*
        First make set containing the unique suits and values as well as a hashmap counting
        the number of duplicates of each card e.g. 3 Jacks,  2 tens or 2 Aces, 1 five, 1 three, 1 two
        We will need all this info to calculate flushes, straights, quads, trips and pairs
         */
        Set<Suit> suits = new HashSet<>();
        Set<Integer> setValuesAcesHigh = new HashSet<>();
        Map<Integer, Integer> duplicatesCount = new HashMap<>();

        /*
        Separately consider the max and min values when either aces are high or low.
        This is important when calculating a straight, for example A,2,3,4,5 vs 10,J,Q,K,A
         */
        int maxValueAcesLow = Integer.MIN_VALUE;
        int minValueAcesLow = Integer.MAX_VALUE;

        int maxValueAcesHigh = Integer.MIN_VALUE;
        int minValueAcesHigh = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            Card card = cards.get(i);
            Suit suit = card.suit;
            int valueAcesLow = card.intValue;
            int valueAcesHigh = card.intValue == 1 ? 14 : card.intValue;

            suits.add(suit);
            setValuesAcesHigh.add(valueAcesHigh);

            minValueAcesLow = Math.min(minValueAcesLow, valueAcesLow);
            maxValueAcesLow = Math.max(maxValueAcesLow, valueAcesLow);

            minValueAcesHigh = Math.min(minValueAcesHigh, valueAcesHigh);
            maxValueAcesHigh = Math.max(maxValueAcesHigh, valueAcesHigh);

            // build hashmap containing number of duplicates per card value. E.g. 3 aces, 2 5s
            duplicatesCount.put(valueAcesHigh, duplicatesCount.getOrDefault(valueAcesHigh, 0) + 1);
        }

        ArrayList<Integer> quads = new ArrayList<>();
        ArrayList<Integer> trips = new ArrayList<>();
        ArrayList<Integer> pairs = new ArrayList<>();
        ArrayList<Integer> kickers = new ArrayList<>();
        // Kickers are all non-paired cards

        boolean flush = suits.size() == 1;
        boolean straight = (setValuesAcesHigh.size() == 5
                            && (maxValueAcesLow - minValueAcesLow == 4 || maxValueAcesHigh - minValueAcesHigh == 4));

        for (int key : duplicatesCount.keySet()) {
            if (duplicatesCount.get(key) == 4) {
                quads.add(key);
            }
            else if (duplicatesCount.get(key) == 3) {
                trips.add(key);
            }
            else if (duplicatesCount.get(key) == 2) {
                pairs.add(key);
            }
            else {
                kickers.add(key);
            }
        }

        pairs.sort(Comparator.reverseOrder());
        kickers.sort(Comparator.reverseOrder());
        int[] result;


        // Royal Flush
        if (flush && straight && minValueAcesHigh == 10) {
            result = new int[] {10};
        }
        // Straight Flush
        else if (flush && straight) {
            result = new int[] {9, maxValueAcesLow};
        }
        // Quads
        else if (quads.size() == 1) {
            result = new int[] {8, quads.getFirst(), kickers.getFirst()};
        }
        // Full House
        else if (trips.size() == 1 && pairs.size() == 1) {
            result = new int[] {7, trips.getFirst(), pairs.getFirst()};
        }
        // Flush
        else if (flush) {
            result = new int[] {6,
                    kickers.get(0),
                    kickers.get(1),
                    kickers.get(2),
                    kickers.get(3),
                    kickers.get(4)};
        }
        // Straight
        else if (straight) {
            result = new int[] {5, minValueAcesHigh};
        }
        // Trips
        else if (trips.size() == 1) {
            result = new int[] {4,
                    trips.getFirst(),
                    kickers.getFirst(),
                    kickers.getLast()};
        }
        // Two Pair
        else if (pairs.size() == 2) {
            result = new int[] {3,
                    pairs.getFirst(),
                    pairs.getLast(),
                    kickers.getFirst()};
        }
        // Pair
        else if (pairs.size() == 1) {
            result = new int[] {2,
                    pairs.getFirst(),
                    kickers.get(0),
                    kickers.get(1),
                    kickers.get(2)};
        }
        // High Card
        else {
                result = new int[] {1,
                    kickers.get(0),
                    kickers.get(1),
                    kickers.get(2),
                    kickers.get(3),
                    kickers.get(4)};
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
