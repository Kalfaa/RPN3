package rpn.message;

import rpn.bus.Bus;
import rpn.consumer.Consumer;
import rpn.message.Message;
import rpn.message.OperationMessage;
import rpn.message.OperatorMessage;

public class Multiplication implements Consumer {
    private final Bus bus;
    public Multiplication(Bus bus) {
        this.bus = bus;
    }
    @Override
    public void receive(Message message) {
        OperationMessage operationMessage = (OperationMessage) message;
        if(!operationMessage.stackNumbers.empty()) {
            double res = operationMessage.stackNumbers.pop() * operationMessage.stackNumbers.pop();
            operationMessage.stackNumbers.push(res);
            bus.publish(new OperatorMessage(operationMessage.stackNumbers, operationMessage.expressionId));
        }
    }
}