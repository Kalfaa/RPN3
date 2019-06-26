package rpn.message;

import rpn.bus.Bus;
import rpn.consumer.Consumer;
import rpn.message.Message;
import rpn.message.OperationMessage;
import rpn.message.OperatorMessage;

public class Addition implements Consumer {
    private final Bus bus;
    public Addition(Bus bus) {
        this.bus = bus;
    }
    @Override
    public void receive(Message message) {
        OperationMessage operationMessage = (OperationMessage) message;
        if(operationMessage.stackNumbers.size() >= 2) {
            double resAddition = operationMessage.stackNumbers.pop() + operationMessage.stackNumbers.pop();
            operationMessage.stackNumbers.push(resAddition);
            bus.publish(new OperatorMessage(operationMessage.stackNumbers, operationMessage.expressionId));
        }
    }
}
