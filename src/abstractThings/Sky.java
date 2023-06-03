package abstractThings;

import actors.Neznaika;

public class Sky {
    public static class Moon {
        private String color = "silver";

        public String getColor() {
            return color;
        }

        public static void attract(Neznaika neznaika) {
            neznaika.getMentalState().setEmotion(Emotion.ENCHANTED);
            System.out.println("Прошло два или три часа, а " + neznaika.getName() + " все смотрел на " +
                    new Moon().getColor() + " Луну и никак не мог от нее оторваться. " +
                    "Луна словно притягивала к себе его взоры. " + neznaika.getName() + " был " +
                    neznaika.getMentalState().getEmotion().getValue());
        }
    }

    public static class GlowingSphere {
        private String description;
        private String size;

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
