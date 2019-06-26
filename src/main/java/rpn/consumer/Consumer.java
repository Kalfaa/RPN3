package rpn.consumer;

import rpn.message.Message;

public interface Consumer {
    void receive(Message message);
}