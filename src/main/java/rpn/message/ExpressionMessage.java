package rpn.message;

import static rpn.constantes.Constantes.TYPE_EXPRESSION;

public class ExpressionMessage implements Message {
    private final String expression;
    private final String expressionId;
    public ExpressionMessage(String expression, String expressionId) {
        this.expression = expression;
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return TYPE_EXPRESSION;
    }
    @Override
    public String id() {
        return expressionId;
    }
    public String expression() {
        return expression;
    }
    public String expressionId() {
        return expressionId;
    }
}