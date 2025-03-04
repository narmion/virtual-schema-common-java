package com.exasol.adapter.sql;

import com.exasol.adapter.AdapterException;

public class SqlPredicateNot extends SqlPredicate {
    private final SqlNode expression;

    public SqlPredicateNot(final SqlNode expression) {
        super(Predicate.NOT);
        this.expression = expression;
        if (this.expression != null) {
            this.expression.setParent(this);
        }
    }

    public SqlNode getExpression() {
        return expression;
    }

    @Override
    public String toSimpleSql() {
        return "NOT (" + expression.toSimpleSql() + ")";
    }

    @Override
    public SqlNodeType getType() {
        return SqlNodeType.PREDICATE_NOT;
    }

    @Override
    public <R> R accept(final SqlNodeVisitor<R> visitor) throws AdapterException {
        return visitor.visit(this);
    }
}
