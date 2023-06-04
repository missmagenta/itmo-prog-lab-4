package abstractions;

import exceptions.IllegalParticipantOfDialogException;
import interfaces.Conversationable;

import java.util.Objects;

public class Dialog {
    private Conversationable speaker1;
    private Conversationable speaker2;
    private String topic;

    public void addParticipant(Conversationable speaker1, Conversationable speaker2) throws IllegalParticipantOfDialogException {
        if (this.speaker1 != null || this.speaker2 != null) {
            throw new IllegalParticipantOfDialogException("This dialog already has 2 participants");
        }
        this.speaker1 = speaker1;
        this.speaker2 = speaker2;
        System.out.println(speaker1.getName() + " и " + speaker2.getName() + " entered the conversation");
        speaker1.setConversation(this);
        speaker2.setConversation(this);
    }

    public void say(Conversationable speaker, String message, Conversationable listener) throws
            IllegalParticipantOfDialogException {
        boolean isSpeakerParticipant = (speaker == speaker1) || (speaker == speaker2);
        boolean isListenerParticipant = (listener == speaker1) || (listener == speaker2);
        if (isSpeakerParticipant && isListenerParticipant) {
            System.out.println(speaker.getName() + ": " + message);
        } else if (isSpeakerParticipant || isListenerParticipant) {
            String notParticipantName = isSpeakerParticipant ? listener.getName() : speaker.getName();
            throw new IllegalParticipantOfDialogException(notParticipantName + " is not a participant of this conversation");
        } else {
            throw new IllegalParticipantOfDialogException("Neither " + speaker.getName() +
                    " nor " + listener.getName() + " are participants of this conversation");
        }
    }

    public void removeParticipant(Conversationable speaker) {
        if (speaker1 != null && speaker1 == speaker) {
            speaker1 = null;
        } else if (speaker2 != null && speaker2 == speaker) {
            speaker2 = null;
        } else {
            throw new IllegalParticipantOfDialogException(speaker.getName() + " was not a participant of this conversation");
        }
        speaker.setConversation(null);
        System.out.println(speaker.getName() + " left the conversation");
    }

    public void setTopic(Conversationable speaker, String topic) {
        this.topic = topic;
        System.out.println(speaker.getName() + " set the topic - " + topic);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Dialog that = (Dialog) obj;
        return Objects.equals(speaker1, that.speaker1) &&
                Objects.equals(speaker2, that.speaker2);
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "speaker1='" + speaker1 + '\'' +
                ", speaker2='" + speaker2 + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(speaker1, speaker2);
    }
}
