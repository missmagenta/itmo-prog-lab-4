package food;

public class Sausage extends SpaceFood {
    public Sausage() {
        super("sausage", null, 0);
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "foodName='" + getFoodName() + '\'' +
                ", grade='" + getFoodGrade() + '\'' +
                '}';
    }
}

