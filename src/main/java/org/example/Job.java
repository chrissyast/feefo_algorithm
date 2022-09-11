package org.example;

public enum Job {
    ARCHITECT("Architect"),
    SOFTWARE_ENGINEER("Software engineer"),
    QUANTITY_SURVEYOR("Quantity surveyor"),
    ACCOUNTANT("Accountant");

    public final String label;

    private Job(String label) {
        this.label = label;
    }
}
