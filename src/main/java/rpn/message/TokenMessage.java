package rpn.message;

import static rpn.constantes.Constantes.TYPE_MESSAGE;

public class TokenMessage implements Message {
    private final String token;
    public final String expressionId;
    public TokenMessage(String token, String expressionId) {
        this.token = token;
        this.expressionId = expressionId;
    }
    @Override
    public String messageType() {
        return TYPE_MESSAGE;
    }
    @Override
    public String id() {
        return expressionId;
    }
    public String getToken() {
        return token;
    }

}
