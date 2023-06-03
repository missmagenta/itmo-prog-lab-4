package interfaces;

import abstractThings.Dialog;

public interface Conversationable {
    Dialog getConversation();

    void setConversation(Dialog dialog);

    String getName();
}
