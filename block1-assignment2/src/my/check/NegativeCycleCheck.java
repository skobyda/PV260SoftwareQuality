package my.check;

import com.puppycrawl.tools.checkstyle.api.*;

public class NegativeCycleCheck extends AbstractCheck {

    private boolean insideCycle;
    // private String mustNotContain;

    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.FOR_ITERATOR, TokenTypes.POST_DEC, TokenTypes.MINUS_ASSIGN, TokenTypes.DEC, TokenTypes.MINUS};
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }

    @Override
    public void visitToken(DetailAST aAST) {
        if (aAST.getType() == TokenTypes.FOR_ITERATOR) {
            insideCycle = true;
        } else if (insideCycle) {
            log(aAST, "Cannot use cycle with negative decrement");
        }
    }

    @Override
    public void leaveToken(DetailAST aAST) {
        if (aAST.getType() == TokenTypes.FOR_ITERATOR)
            insideCycle = false;
    }
    /* private boolean checkExpression(DetailAST aAST) {
        String Iteratoor = aAST.getText();
        if (iteratorIsDecreasing()) {
            log(aAST, "ERRROR MESSAGE");
        }
    } */
}