package com.manzar.algorithms;

import com.manzar.model.Person;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithms {

    public static final Comparator<Person> PERSON_WEIGHT_COMPARATOR = Comparator.comparing(Person::getWeight);

    /**
     * This is an implementation of merge sort algorithm. Time complexity - O(n * log n)
     */
    public static void sort(Person[] people, int arrayLength, Comparator<Person> personComparator) {
        if (arrayLength < 2) {
            return;
        }
        int middle = arrayLength / 2;
        Person[] leftPart = new Person[middle];
        Person[] rightPart = new Person[arrayLength - middle];
        System.arraycopy(people, 0, leftPart, 0, middle);

        if (arrayLength - middle >= 0) System.arraycopy(people, middle, rightPart, 0, arrayLength - middle);

        sort(leftPart, middle, personComparator);
        sort(rightPart, arrayLength - middle, personComparator);

        merge(people, leftPart, rightPart, personComparator);

    }

    private static void merge(Person[] people, Person[] leftPart, Person[] rightPart, Comparator<Person> personComparator) {
        int i = 0, j = 0, k = 0;

        while (i < leftPart.length && j < rightPart.length) {
            if (personComparator.compare(leftPart[i], rightPart[j]) <= 0) {
                people[k++] = leftPart[i++];
            } else {
                people[k++] = rightPart[j++];
            }
        }
        while (i < leftPart.length) {
            people[k++] = leftPart[i++];
        }
        while (j < rightPart.length) {
            people[k++] = rightPart[j++];
        }
    }

    /**
     * Time complexity - O(n * log n)
     */

    public static long findUniquePersonsHeightWithSameWeight(Person[] people) {
        long count = 0;
        Arrays.sort(people, PERSON_WEIGHT_COMPARATOR);
        for (int i = 0; i < people.length; i++) {
            while (sameWeightAndSameHeightCondition(people, i)) {
                i++;
            }
            count++;
        }
        return count;
    }

    private static boolean sameWeightAndSameHeightCondition(Person[] people, int i) {
        return i < people.length - 1 && people[i].getWeight() == people[i + 1].getWeight() &&
                people[i].getHeight() == people[i + 1].getHeight();
    }

}
