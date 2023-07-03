import animals.Animal;
import animals.enums.AnimalTypes;
import enums.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.print("Введите одну из команд - add/list/exit: ");
            String commandLine = scanner.next().trim().toUpperCase();
            Commands command = null;
            try {
                command = Commands.valueOf(commandLine);
            } catch (IllegalArgumentException exception) {
                System.out.println("Неверная команда, попробуйте ещё раз");
                continue;
            }
            switch (command) {
                case ADD -> {
                    AnimalTypes animalType = null;
                    Animal animal = null;
                    while (animalType == null || animal == null) {
                        System.out.print(String.format("Введите один из видов животных - %s: ", AnimalTypes.getAllAsString()));
                        String animalTypeInput = scanner.next().trim().toLowerCase();
                        animalType = AnimalTypes.getByName(animalTypeInput);
                        if (animalType == null) {
                            System.out.println("Вы ввели неизвестный вид животного, попробуйте ещё раз");
                        } else {
                            animal = animalType.create();
                        }
                    }
                    animal = fillAnimalData(animal);
                    animals.add(animal);
                    System.out.print(String.format("%s говорит: ", animal.getName()));
                    animal.say();
                }
                case LIST -> {
                    if(animals.size() == 0) {
                        System.out.println("Список пуст!");
                    }
                    animals.forEach(animal -> System.out.println(animal));
                    break;
                }
                case EXIT -> {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
            }
        }

    }

    private static Animal fillAnimalData(Animal animal) {

        System.out.print("Введите имя животного: ");
        animal.setName(scanner.next().trim());

        while (animal.getAge() == null) {
            System.out.print("Введите возраст животного: ");
            String inputAge = scanner.next().trim();
            try {
                animal.setAge(Integer.parseInt(inputAge));
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели возраст в неверном формате, нужно ввести положительное число (меньше 2147483648)");
            }
        }

        while (animal.getWeight() == null) {
            System.out.print("Введите вес животного: ");
            String inputWeight = scanner.next().trim();
            try {
                animal.setWeight(Integer.parseInt(inputWeight));
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели вес в неверном формате, нужно ввести положительное число (меньше 2147483648)");
            }
        }

        System.out.print("Введите цвет животного: ");
        animal.setColor(scanner.next().trim());

        return animal;

    }

}