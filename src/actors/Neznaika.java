package actors;

import abstractions.psychophysiology.MentalState;
import abstractions.psychophysiology.State;
import exceptions.CharacterNotAwakeException;

import java.util.Objects;

public class Neznaika extends SpaceTraveler {
    private State state = State.AWAKE;

    public Neznaika(String name, MentalState mentalState) {
        super(name, mentalState);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void contradict(Ponchik ponchik) throws CharacterNotAwakeException {
        if (state == State.AWAKE) {
            System.out.println(getName() + " возразил to " + ponchik.getName());
        } else {
            throw new CharacterNotAwakeException("Cannot invoke this method because " + getName() + " has state " + State.SLEEP);
        }
    }

    public void prepareForSleep() {
        class SleepingPose {
            private boolean legsCrossed;
            private boolean armsFolded;

            public void displayPose() {
                legsCrossed = true;
                armsFolded = true;
                System.out.println(getName() + " принял позу: legs are crossed = " + legsCrossed +
                        ", arms are folded = " + armsFolded);
            }
        }
        SleepingPose sleepingPose = new SleepingPose();
        sleepingPose.displayPose();
    }

    public void sleep() {
        this.state = State.SLEEP;
        System.out.println(getName() + " заснул ");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Neznaika that = (Neznaika) obj;
        return getName().equals(that.getName());
    }

    @Override
    public String toString() {
        return "Neznaika{" +
                "name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
