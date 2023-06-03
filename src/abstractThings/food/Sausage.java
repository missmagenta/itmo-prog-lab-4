package abstractThings.food;

public class Sausage extends SpaceFood {
    public Sausage() {
        super("sausage");
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "foodName='" + getFoodName() + '\'' +
                ", grade='" + getFoodGrade() + '\'' +
                '}';
    }
}

