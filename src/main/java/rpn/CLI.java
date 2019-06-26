package rpn;

import rpn.bus.InMemoryBus;
import rpn.consumer.DisplayResultConsumer;
import rpn.message.*;
import rpn.consumer.TokenizerConsumer;
import rpn.consumer.Calculator;

import java.util.UUID;

import static rpn.constantes.Constantes.*;

public class CLI {
    public static void main(String[] args) {
        InMemoryBus bus = new InMemoryBus();
        bus.subscribe(TYPE_EXPRESSION, new TokenizerConsumer(bus));
        Calculator calculator = new Calculator(bus);
        bus.subscribe(TYPE_MESSAGE, calculator);
        bus.subscribe(TYPE_EOT, calculator);
        bus.subscribe(TYPE_ADDITION, new Addition(bus));
        bus.subscribe(TYPE_SOUSTRACTION, new Subtraction(bus));
        bus.subscribe(TYPE_MULTIPLICATION, new Multiplication(bus));
        bus.subscribe(TYPE_DIVISION, new Division(bus));
        bus.subscribe(TYPE_RESULT, new DisplayResultConsumer());
        String expressionId = UUID.randomUUID().toString();
        ExpressionMessage expressionMessage = new ExpressionMessage("1 2 +", expressionId);
        bus.publish(expressionMessage);
    }
}