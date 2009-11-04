package org.opennms.client;

public class DatabaseDriverException extends Exception {
    private static final long serialVersionUID = -4320228591412167279L;

    public DatabaseDriverException() {
        super();
    }

    public DatabaseDriverException(String string, Throwable e) {
        super(string, e);
    }

}
