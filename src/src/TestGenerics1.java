public class TestGenerics1 {

    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go() {
        Animal[] animals = { new Dog(), new Cat(), new Dog() };
        Dog[] dogs = { new Dog(), new Dog(), new Dog() };
        Cat[] cats = { new Cat(), new Cat(), new Cat() };
        takeAnimals(animals);
        takeAnimals(dogs);
        takeAnimals(cats);
    }

    public void takeAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }
}
