package rpn.message;

import java.util.Stack;

import static rpn.constantes.Constantes.TYPE_RESULT;

public class ResultCalculationMessage implements Message {
    public final Stack<Double> result;
    public final String expressionId;
    public ResultCalculationMessage(Stack<Double> result, String expressionId) {
        this.result = result;
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return TYPE_RESULT;
    }
    @Override
    public String id() {
        return expressionId;
    }
}