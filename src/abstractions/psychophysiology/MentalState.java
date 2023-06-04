package abstractions.psychophysiology;

import java.util.Objects;

public class MentalState {
    Emotion emotion = Emotion.NORMAL;

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MentalState that = (MentalState) obj;
        return emotion == that.emotion;
    }

    @Override
    public String toString() {
        return "MentalState{" +
                "emotion='" + emotion + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(emotion);
    }
}
