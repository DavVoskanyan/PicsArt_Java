package mainCookClass.SubCookClass;

import mainCookClass.Cook;

public abstract class Chef extends Cook  implements ChefsInterface{

    @Override
    public void cookingMeal() {
        System.out.println("I'm cooking an extraordinary meal");
    }

    @Override
    public abstract void makingDish1();

    @Override
    public abstract void makingDish2();

    @Override
    public abstract void makingDish3();
}
