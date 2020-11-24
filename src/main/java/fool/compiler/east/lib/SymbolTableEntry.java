package fool.compiler.east.lib;

import fool.compiler.Visitable;
import fool.compiler.ast.lib.ASTVisitor;
import fool.compiler.east.lib.EASTVisitor;

import java.util.Objects;

/**
 * Entry for any symbol in the program.
 */
public class SymbolTableEntry implements Visitable {
    private final int nestingLevel;

    public SymbolTableEntry(int nl) {
        nestingLevel = nl;
    }

    public int getNestingLevel() {
        return nestingLevel;
    }

    @Override
    public <S> S accept(ASTVisitor<S> visitor) {
        Objects.requireNonNull(visitor);
        if(!visitor.getClass().equals(EASTVisitor.class))
            System.out.println("Class not compatible");
        return ((EASTVisitor<S>) visitor).visit(this);
    }
}