package abstractions.food;

public class Cutlet extends SpaceFood {
    public Cutlet() {
        super("cutlet");
    }

    @Override
    public String toString() {
        return "Cutlet{" +
                "foodName='" + getFoodName() + '\'' +
                ", grade='" + getFoodGrade() + '\'' +
                '}';
    }
}
