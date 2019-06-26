package rpn.message;

import rpn.bus.Bus;
import rpn.consumer.Consumer;
import rpn.message.Message;
import rpn.message.OperationMessage;
import rpn.message.OperatorMessage;

public class Division implements Consumer {
    private final Bus bus;
    public Division(Bus bus) {
        this.bus = bus;
    }
    @Override
    public void receive(Message message) {
        OperationMessage operationMessage = (OperationMessage) message;
        if(!operationMessage.stackNumbers.empty()) {
            Double divider = operationMessage.stackNumbers.pop();
            if (divider.compareTo(0.0) != 0) {
                double res = operationMessage.stackNumbers.pop() / divider;
                operationMessage.stackNumbers.push(res);
                bus.publish(new OperatorMessage(operationMessage.stackNumbers, operationMessage.expressionId));
            }
        }
    }
}