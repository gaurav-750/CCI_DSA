package AdvanceJava;

public class Dog implements Animal{
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(){
        System.out.println("Dog is eating");
    }

    public void walk(){
        System.out.println("Dog is walking");
    }

    public void walk(int km){
        System.out.println("Dog is walking " + km + " kms.");
    }

}
