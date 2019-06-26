package rpn.message;

import java.util.Stack;

import static rpn.constantes.Constantes.TYPE_OPERATOR;

public class OperatorMessage implements Message {
    public final Stack<Double> stackNumbers;
    private final String expressionId;
    public OperatorMessage(Stack<Double> stackNumbers, String expressionId) {
        this.stackNumbers = stackNumbers;
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return TYPE_OPERATOR;
    }
    @Override
    public String id() {
        return expressionId;
    }
}
