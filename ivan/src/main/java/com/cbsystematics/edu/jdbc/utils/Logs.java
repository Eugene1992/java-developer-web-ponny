package com.cbsystematics.edu.jdbc.utils;

public enum Logs {
    DATA_BASE_CONNECTION("Connecting to database..."),
    DSTATEMENT_CREATION("Creating statement...");

    private String logText;

    Logs(String logText) {
        this.logText = logText;
    }

    public String getLogText() {
        return logText;
    }
}
