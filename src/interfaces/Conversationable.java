package interfaces;

import abstractions.Dialog;

public interface Conversationable {
    Dialog getConversation();

    void setConversation(Dialog dialog);

    String getName();
}
