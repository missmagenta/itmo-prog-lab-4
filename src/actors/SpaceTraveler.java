package actors;

import interfaces.*;
import abstractThings.food.SpaceFood;
import abstractThings.*;

import java.util.Objects;

public class SpaceTraveler extends Character implements Eatable, Conversationable {
    private boolean hungry;
    private boolean inWeightlessness;
    private Dialog conversation;
    private SpaceFood currentConsumableFood;
    private Location location;
    private MentalState mentalState;


    public SpaceTraveler(String name, MentalState mentalState) {
        super(name);
        this.mentalState = mentalState;
    }

    public boolean isHungry() {
        return this.hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
        if (hungry) {
            System.out.println(getName() + " был голоден");
        } else {
            System.out.println(getName() + " был не голоден");
        }
    }

    public void setInWeightlessness(boolean inWeightlessness) {
        this.inWeightlessness = inWeightlessness;
    }

    @Override
    public Dialog getConversation() {
        return this.conversation;
    }

    @Override
    public void setConversation(Dialog dialog) {
        this.conversation = dialog;
    }

    public SpaceFood getCurrentConsumableFood() {
        return this.currentConsumableFood;
    }

    public void setCurrentConsumableFood(SpaceFood food) {
        this.currentConsumableFood = food;
    }

    public void eat() {
        System.out.println(getName() + " съел " +
                currentConsumableFood.getConsumedPortionsByFoodType() + " " +
                currentConsumableFood.getFoodName());
    }

    public void setLocation(Location location) {
        this.location = location;
        System.out.println(getName() + " were in " + location.getValue() + " location");
    }

    public void moveTo(Location location) {
        this.location = location;
        System.out.println(getName() + " moved to " + location.getValue());
    }

    public MentalState getMentalState() {
        return mentalState;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        SpaceTraveler that = (SpaceTraveler) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "SpaceTraveler{" +
                "name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
