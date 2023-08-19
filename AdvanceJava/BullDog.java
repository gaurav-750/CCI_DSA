package AdvanceJava;

public class BullDog extends Dog{
    private String name;

    public BullDog(String name){
        super(name);
        this.name = name;
    }


    @Override
    public void walk(){
        System.out.println(this.name + " is walking!");
    }


}
