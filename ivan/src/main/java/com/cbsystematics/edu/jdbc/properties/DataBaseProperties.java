package com.cbsystematics.edu.jdbc.properties;

public enum DataBaseProperties {
    JDBC_DRIVER("org.postgresql.Driver"),
    HOST("ec2-54-75-231-3.eu-west-1.compute.amazonaws.com"),
    DATABASE("d2ho8agt7vhqtq"),
    USER("ooytnjvmtqeubm"),
    PORT("5432"),
    PASSWORD("a0f09fb79c301eb9f2110e6011cdf5a8c4d7c3db40d1c4b3e6630ae1bb1b4b45"),
    SSL("true"),
    SSL_FACTORY("org.postgresql.ssl.NonValidatingFactory"),

    DATA_BASE_URL("postgres://" + DataBaseProperties.USER.getPropertyValue() +
            DataBaseProperties.PASSWORD.getPropertyValue() + ":@" +
            DataBaseProperties.HOST.getPropertyValue() + ":" +
            DataBaseProperties.PORT.getPropertyValue() + "/" +
            DataBaseProperties.DATABASE.getPropertyValue() +
            "?ssl=" + DataBaseProperties.SSL.getPropertyValue() +
            "&sslfactory=" + DataBaseProperties.SSL_FACTORY.getPropertyValue());

    private String propertyValue;

    DataBaseProperties(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }
}
