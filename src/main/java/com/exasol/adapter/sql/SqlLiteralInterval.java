package com.exasol.adapter.sql;

import com.exasol.adapter.AdapterException;
import com.exasol.adapter.metadata.DataType;

public class SqlLiteralInterval extends SqlNode {
    private final String value;   // stored as YYYY-MM-DD HH:MI:SS.FF6
    private final DataType type;

    public SqlLiteralInterval(final String value, final DataType type) {
        this.value = value;
        this.type = type;
    }
    
    public String getValue() {
        return value;
    }

    public DataType getDataType() {
        return type;
    }

    @Override
    public String toSimpleSql() {
        if (type.getIntervalType() == DataType.IntervalType.YEAR_TO_MONTH) {
            return "INTERVAL '" + value + "' YEAR (" + type.getPrecision() + ") TO MONTH";
        } else {
            return "INTERVAL '" + value + "' DAY (" + type.getPrecision()
                    + ") TO SECOND (" + type.getIntervalFraction() + ")";
        }
    }

    @Override
    public SqlNodeType getType() {
        return SqlNodeType.LITERAL_TIMESTAMP;
    }

    @Override
    public <R> R accept(final SqlNodeVisitor<R> visitor) throws AdapterException {
        return visitor.visit(this);
    }
}
