package rpn.message;

import static rpn.constantes.Constantes.TYPE_EOT;

public class EndOfToken implements Message {
    public final String expressionId;
    public EndOfToken(String expressionId) {
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return TYPE_EOT;
    }
    @Override
    public String id() {
        return expressionId;
    }
}