package com.protey.jobs.entity;

public enum Master {
    MASTER_1("Бабин Александр"),
    MASTER_2("Красавин Сергей"),
    MASTER_3("Резерв");

    private String title;

    Master(String s) {
        this.title=s;
    }

    public String getMaster() {
        return title;
    }

    @Override
    public String toString() {
        return name();
    }
}
