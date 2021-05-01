package mainCookClass;

import mainCookClass.SubCookClass.ChefsInterface;

public abstract class Cook implements CookInterface {
    private String name;
    private int age = 18;
    private int workExperience = 3;


    //get & set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.matches("[A-Z][a-z]*"))
            this.name = name;
        else
            this.name = "Unknown";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 18 && age < 100)
            this.age = age;
    }

    public String getWorkExperience() {
        return workExperience + " years";
    }

    public void setWorkExperience(int workExperience) {
        if(workExperience > 3 )
        this.workExperience = workExperience;
    }




//CookInterface
    @Override
    public void makeBreakfast() {
        System.out.println("Good Morning. Breakfast is nearly ready!");
    }

    @Override
    public void makeDinner() {
        System.out.println("Go wash your hands, Dinner will be ready in 5 minutes!");
    }

    @Override
    public void makeSupper() {
        System.out.println("It's 7 o'clock. Let's have some supper!");
    }




    public abstract void cookingMeal();
}
