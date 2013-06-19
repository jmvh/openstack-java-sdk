package com.woorea.openstack.ceilometer;

import java.io.Serializable;

public class QueryFilter implements Serializable {
    private String field;
    private String op;
    private String value;

    public QueryFilter(String field, String op, String value) {
        this.field = field;
        this.op = op;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String toString() {
        return "q.field=" + field + "&q.op="+op + "&q.value=" + value;
    }
}
