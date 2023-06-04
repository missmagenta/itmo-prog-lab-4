package abstractions;

import abstractions.psychophysiology.Emotion;
import actors.SpaceTraveler;

public class Sky {
    public static class Moon {
        final private String color = "silver";

        public String getColor() {
            return color;
        }

        public static void attract(SpaceTraveler spaceTraveler) {
            spaceTraveler.getMentalState().setEmotion(Emotion.ENCHANTED);
            System.out.println("Прошло два или три часа, а " + spaceTraveler.getName() + " все смотрел на " +
                    new Moon().getColor() + " Луну и никак не мог от нее оторваться. " +
                    "Луна словно притягивала к себе его взоры. " + spaceTraveler.getName() + " был " +
                    spaceTraveler.getMentalState().getEmotion().getValue());
        }
    }

    public static class GlowingSphere {
        final private String description;
        final private String size;

        public GlowingSphere(String size, String description) {
            this.size = size;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public String getSize() {
            return size;
        }
    }
}
