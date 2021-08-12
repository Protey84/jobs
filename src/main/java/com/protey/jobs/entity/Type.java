package com.protey.jobs.entity;

public enum Type {
    LAM_STRAIGHT("Ламинат прямая"),
    LAM_DIAG("Ламинат диагональная"),
    PAR_STRAIGHT("Паркет прямая"),
    PAR_DIAG("Паркет диагональная"),
    LIN_WITH("Линолеум с приклеиванием"),
    LIN_WITHOUT("Линолеум без приклеивания"),
    PLIN_PVH("Плинтус ПВХ"),
    PLIN_MDF("Плинтус МДФ");

    private String title;

    Type(String s) {
        this.title=s;
    }

    @Override
    public String toString() {
        return "Type{" +
                "title='" + title + '\'' +
                '}';
    }
}
