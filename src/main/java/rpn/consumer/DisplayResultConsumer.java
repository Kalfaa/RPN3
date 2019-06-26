package rpn.consumer;

import rpn.message.Message;
import rpn.message.ResultCalculationMessage;

public class DisplayResultConsumer implements Consumer {
    public DisplayResultConsumer() {
    }
    @Override
    public void receive(Message message) {
        ResultCalculationMessage res = (ResultCalculationMessage) message;
        System.out.println(res.result);
    }
}
