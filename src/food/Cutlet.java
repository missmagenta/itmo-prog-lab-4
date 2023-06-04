package food;

public class Cutlet extends SpaceFood {
    public Cutlet() {
        super("cutlet", null, 0);
    }

    @Override
    public String toString() {
        return "Cutlet{" +
                "foodName='" + getFoodName() + '\'' +
                ", grade='" + getFoodGrade() + '\'' +
                '}';
    }
}
