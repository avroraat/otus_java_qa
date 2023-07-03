package animals.enums;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;

public enum AnimalTypes {

    CAT("кошка", Cat.class),
    DOG("собака", Dog.class),
    DUCK("утка", Duck.class);

    private String name;
    private Class animalClass;

    private AnimalTypes(String name, Class animalClass) {
        this.name = name;
        this.animalClass = animalClass;
    }

    public static AnimalTypes getByName(String nameValue) {
        AnimalTypes result = null;
        for (AnimalTypes animalType: AnimalTypes.values()) {
            if (animalType.name.equals(nameValue)) {
                result = animalType;
                break;
            }
        }
        return result;
    }

    public static String getAllAsString() {
        String result = "";
        int i = 0;
        for (AnimalTypes type: AnimalTypes.values()) {
            i++;
            result = result + type.name;
            if (i < AnimalTypes.values().length) {
                result = result + "/";
            }
        }
        return result;
    }

    public Animal create() {
        Animal result = null;
        try {
             result = (Animal) this.animalClass.newInstance();
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при создании животного, попробуйте другое");
        }
        return result;
    }

}
