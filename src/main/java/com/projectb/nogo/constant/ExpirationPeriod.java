package com.projectb.nogo.constant;

public enum ExpirationPeriod {
    ONE_YEAR(1), THREE_YEAR(3), UNTIL_WITHDRAWAL(-1);

    private int period;

    ExpirationPeriod(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }
}
