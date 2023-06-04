package food;

import exceptions.NegativeAmountOfConsumedPortions;

import java.util.Objects;

public class SpaceFood {
    final private String foodName;
    private FoodGrade grade = FoodGrade.UNKNOWN;
    private Integer totalPortions;
    private Integer consumedPortionsByFoodType;
    private static Integer totalConsumedPortions = 0;

    public SpaceFood(String foodName, Integer totalPortions, Integer consumedPortionsByFoodType) {
        this.foodName = foodName;
        this.totalPortions = totalPortions;
        this.consumedPortionsByFoodType = consumedPortionsByFoodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setConsumedPortionsByFoodType(int consumedPortionsByFoodType) throws
            NegativeAmountOfConsumedPortions {
        if (consumedPortionsByFoodType < 0)
            throw new NegativeAmountOfConsumedPortions("You cannot set a negative number to consumedPortionsByFoodType");
        totalConsumedPortions += consumedPortionsByFoodType;
        this.consumedPortionsByFoodType = consumedPortionsByFoodType;
    }

    public int getConsumedPortionsByFoodType() {
        return consumedPortionsByFoodType;
    }

    public FoodGrade getFoodGrade() {
        return this.grade;
    }

    public void setGrade(FoodGrade value) {
        this.grade = value;
    }

    public void setTotalPortions(Integer totalPortions) {
        this.totalPortions = totalPortions;
    }

    public int getRemainingPortionCount() {
        if (totalPortions == null) {
            System.out.println("Remaining portions: Total portions minus " + totalConsumedPortions);
            return -1;
        } else {
            int remainingPortions = totalPortions - totalConsumedPortions;
            System.out.println("Remaining portions: " + remainingPortions);
            return remainingPortions;
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
        SpaceFood that = (SpaceFood) obj;
        return Objects.equals(foodName, that.foodName);
    }

    @Override
    public String toString() {
        return "SpaceFood{" +
                "foodName='" + foodName + '\'' + ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName);
    }
}
