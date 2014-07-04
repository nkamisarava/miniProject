package com.springapp.config.enums;

public enum DBEnum {

    PROP_DATABASE_DRIVER("db.driver"),
    PROP_DATABASE_PASSWORD("db.password"),
    PROP_DATABASE_URL("db.url"),
    PROP_DATABASE_USERNAME("db.username"),
    PROP_HIBERNATE_DIALECT("db.hibernate.dialect"),
    PROP_HIBERNATE_SHOW_SQL("db.hibernate.show_sql"),
    PROP_ENTITYMANAGER_PACKAGES_TO_SCAN("db.entitymanager.packages.to.scan"),
    PROP_HIBERNATE_HBM2DDL_AUTO("db.hibernate.hbm2ddl.auto"),
    PROP_HIBERNATE_QUOTED_IND("hibernate.globally_quoted_identifiers");

    private String field;

    public String toSring(){
        return field;
    }

     DBEnum(String value) {
         this.field = value;
    }

}
