package actors;

import abstractThings.*;
import abstractThings.food.SpaceFood;

import java.util.Objects;

public class Ponchik extends SpaceTraveler {
    private State state = State.AWAKE;

    public Ponchik(String name, MentalState mentalState) {
        super(name, mentalState);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void sleep() {
        this.state = State.SLEEP;
        System.out.println(getName() + " заснул с недоеденной " +
                getCurrentConsumableFood().getFoodName() + " во рту");
    }

    public void revise(SpaceFood spaceFood) {
        if (state == State.AWAKE) {
            System.out.println(getName() + " должен произвести в " + Location.FOOD_COMPARTMENT.getValue() +
                    " ревизию и проверить качество всех " + spaceFood.getFoodName() +
                    ", которые имеют оценку " + spaceFood.getFoodGrade().getValue());
        } else {
            System.out.println(getName() + " is not able to revise food because he is sleeping");
        }
    }

    public void reactTo(Sky.GlowingSphere glowingSphere) {
        if (state == State.AWAKE) {
            getMentalState().setEmotion(Emotion.SHOCKED);
            System.out.println(glowingSphere.getSize() + " " + glowingSphere.getDescription() + " висел над ракетой, заслоняя небо со звездами");
        }
    }

    interface Tremblable {
        void tremble();
    }

    public class Lips implements Tremblable {
        @Override
        public void tremble() {
            System.out.println("Затряслись губы");
        }
    }

    public class Cheeks implements Tremblable {
        @Override
        public void tremble() {
            System.out.println("Затряслись щеки");
        }
    }

    public class Ears implements Tremblable {
        @Override
        public void tremble() {
            System.out.println("Затряслись уши");
        }
    }

    public class Eyes {
        public void flowTears() {
            getMentalState().setEmotion(Emotion.AFRAID);
            System.out.println("Из глаз потекли слезы. " + getName() + " был " + getMentalState().getEmotion().getValue());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ponchik that = (Ponchik) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Ponchik{" +
                "name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
