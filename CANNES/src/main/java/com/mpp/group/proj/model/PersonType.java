package com.mpp.group.proj.model;
public enum PersonType {

    OPTION_1(1, "DOCTOR"),
    OPTION_2(2, "CUSTOMER"),
    OPTION_3(3, "OTHERS");

    private int id;
    private String description;

    private PersonType(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

    public static PersonType getInstance(final int id) {

        for (final PersonType selectOptions : PersonType.values()) {
            if (selectOptions.id == id) {
                return selectOptions;
            }
        }

        throw new IllegalArgumentException("Select PersonType could not be determined with id [" + id + "]");
    }

    public static PersonType getInstance(final String description) {

        for (final PersonType selectOptions : PersonType.values()) {
            if (selectOptions.description == description) {
                return selectOptions;
            }
        }

        throw new IllegalArgumentException("Select PersonType could not be determined with description [" + description + "]");
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}