import abstractThings.*;
import abstractThings.food.Cutlet;
import abstractThings.food.Sausage;
import abstractThings.food.SpaceFood;
import actors.Character;
import actors.Neznaika;
import actors.Ponchik;
import actors.SpaceTraveler;

public class Main {
    public static void main(String[] args) {
        SpaceTraveler traveler = new SpaceTraveler("Space Travelers", new MentalState());
        Ponchik ponchik = new Ponchik("Ponchik", new MentalState());
        Neznaika neznaika = new Neznaika("Neznaika", new MentalState());
        Dialog dialog = new Dialog(ponchik, neznaika);
        SpaceFood spaceDish = new SpaceFood("Space dish");
        SpaceFood sausage = new Sausage();
        SpaceFood cutlet = new Cutlet();

        traveler.setInWeightlessness(true);

        dialog.addParticipant(ponchik);
        dialog.say(ponchik, "Ну что ж, поскольку мы летим на Луну и назад все пути отрезаны, теперь у нас только одна задача:" +
                "пробраться обратно в пищевой отсек и как следует позавтракать.", neznaika);
        dialog.setTopic(ponchik, "Breakfast in Space");
        dialog.addParticipant(neznaika);
        dialog.say(neznaika, "Мы ведь только что завтракали.", ponchik);
        neznaika.contradict(ponchik);
        dialog.say(ponchik, "Так разве это был настоящий завтрак? " +
                "Этот завтрак был пробный, так сказать, черновой, тренировочный.", neznaika);
        dialog.say(neznaika, " Как это — тренировочный?", ponchik);
        dialog.say(ponchik, "Ну, мы ведь завтракали в космосе первый раз. " +
                "Значит, вроде как бы не завтракали, а только как бы осваивали процесс питания в космосе, то есть тренировались. " +
                "Зато теперь, когда тренировка закончена, мы можем позавтракать по-настоящему", neznaika);
        dialog.say(neznaika, "Что ж, это, пожалуй, можно.", ponchik);

        dialog.removeParticipant(neznaika);
        dialog.removeParticipant(ponchik);

        traveler.setLocation(Location.INITIAL);
        traveler.moveTo(Location.FOOD_COMPARTMENT);

        neznaika.setHungry(false);
        neznaika.setCurrentConsumableFood(cutlet);
        cutlet.consumePortions(1);
        neznaika.eat();

        ponchik.setHungry(true);
        ponchik.revise(spaceDish);
        ponchik.setCurrentConsumableFood(sausage);
        sausage.consumePortions(10);
        ponchik.eat();
        ponchik.sleep();

        spaceDish.getRemainingPortionCount();

        neznaika.moveTo(Location.ASTRONOMICAL_CABIN);
        Sky.Moon.attract(neznaika);
        neznaika.setHungry(true);
        neznaika.moveTo(Location.FOOD_COMPARTMENT);
        neznaika.prepareForSleep();
        neznaika.sleep();
        ponchik.setState(State.AWAKE);
        neznaika.setState(State.AWAKE);
        traveler.moveTo(Location.ASTRONOMICAL_CABIN);

        ponchik.reactTo(new Sky.GlowingSphere("big", "glowing sphere"));
        Ponchik.Lips lips = ponchik.new Lips();
        Ponchik.Cheeks cheeks = ponchik.new Cheeks();
        Ponchik.Ears ears = ponchik.new Ears();
        Ponchik.Eyes eyes = ponchik.new Eyes();
        lips.tremble();
        cheeks.tremble();
        ears.tremble();
        eyes.flowTears();

        /*
         Вымышленная ситуация
         Если бы Пончик и Незнайка в своем диалоге один раз упомянули какого-нибудь жителя их Солнечного Города,
         который остался на Земле, то объект упомянутого персонажа можно было бы объявить через анонимный класс.
         */
        Character knopochka = new Character("Knopochka") {
            final Location location = Location.EARTH;

            @Override
            public Location getLocation() {
                return location;
            }
        };
        System.out.println("Пончик рассказал бы Незнайке о " + knopochka.getName() +
                ", которая сейчас на " + knopochka.getLocation().getValue());
    }
}