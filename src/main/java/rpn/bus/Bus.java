package rpn.bus;

import rpn.consumer.Consumer;
import rpn.message.Message;

public interface Bus {
    void publish(Message message);
    void subscribe(String eventType, Consumer consumer);
}