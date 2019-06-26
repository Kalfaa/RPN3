package rpn.consumer;

import rpn.bus.Bus;
import rpn.message.EndOfToken;
import rpn.message.ExpressionMessage;
import rpn.message.Message;
import rpn.message.TokenMessage;

import java.util.stream.Stream;

public class TokenizerConsumer implements Consumer {
    private final Bus bus;
    public TokenizerConsumer(Bus bus) {
        this.bus = bus;
    }
    @Override
    public void receive(Message message) {
        ExpressionMessage eMsg = (ExpressionMessage) message;
        String expression = eMsg.expression();
        Stream.of(expression.split("\\s+"))
                .forEach(token -> bus.publish(new TokenMessage(token, eMsg.expressionId())));
        bus.publish(new EndOfToken(eMsg.expressionId()));
    }
}