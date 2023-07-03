package animals;

public abstract class Animal {

    private String name;
    private Integer age;
    private Integer weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 0) throw new NumberFormatException("Возраст должен быть положительным числом");
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight < 0) throw new NumberFormatException("Вес должен быть положительным числом");
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }
    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет - %s", getName(), getAge(), getAgeAnnotation(getAge()), getWeight(), getColor());
    }

    private String getAgeAnnotation(Integer ageValue) {

        int mod = ageValue % 10;
        String ageAnnotation = "лет";

        if (mod >=5 || ageValue >= 11 && ageValue <= 14) {
            ageAnnotation =  "лет";
        } else if (mod == 1) {
            ageAnnotation =  "год";
        } else if (mod >= 2) {
            ageAnnotation =  "года";
        }

        return ageAnnotation;

    }

}
