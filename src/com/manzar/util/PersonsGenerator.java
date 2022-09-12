package com.manzar.util;

import com.manzar.model.Person;

import java.util.Random;
import java.util.stream.Stream;

public class PersonsGenerator {

    private static final Random random;

    static {
        random = new Random();
    }

    public static Person[] generatePersons(int numberOfPersons) {
        return Stream.generate(PersonsGenerator::generatePerson).limit(numberOfPersons).toArray(Person[]::new);
    }

    private static Person generatePerson() {
        int height = random.nextInt(40, 250);
        int weight = random.nextInt(1, 200);
        int age = random.nextInt(0, 120);
        return new Person(height, weight, age);
    }
}
