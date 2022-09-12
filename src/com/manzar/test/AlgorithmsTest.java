package com.manzar.test;

import com.manzar.model.Person;
import com.manzar.algorithms.Algorithms;
import com.manzar.util.PersonsGenerator;

import java.util.Arrays;
import java.util.Comparator;

public class AlgorithmsTest {

    public static final Comparator<Person> PERSON_COMPARATOR_BY_AGE = Comparator.comparing(Person::getAge);
    public static final Comparator<Person> PERSON_COMPARATOR_BY_HEIGHT = Comparator.comparing(Person::getHeight);
    public static final Comparator<Person> PERSON_COMPARATOR_BY_WEIGHT = Comparator.comparing(Person::getWeight);

    public static void main(String[] args) {

        Person[] people1 = PersonsGenerator.generatePersons(10_000);
        Algorithms.sort(people1, people1.length, PERSON_COMPARATOR_BY_AGE);
        Arrays.stream(people1).forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Person[] people2 = PersonsGenerator.generatePersons(10_000);
        Arrays.stream(people2).forEach(System.out::println);
        long number = Algorithms.findUniquePersonsHeightWithSameWeight(people2);
        System.out.println(number);
    }
}

