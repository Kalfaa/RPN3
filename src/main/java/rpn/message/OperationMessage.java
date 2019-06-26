package rpn.message;

import java.util.Stack;

import static rpn.constantes.Constantes.TYPE_OPERATOR;

public class OperationMessage implements Message {
    public final String operator;
    public final Stack<Double> stackNumbers;
    public final String expressionId;
    public OperationMessage(String operator, Stack<Double> stackNumbers, String expressionId) {
        this.operator = operator;
        this.stackNumbers = stackNumbers;
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return operator;
    }
    @Override
    public String id() {
        return expressionId;
    }
}
