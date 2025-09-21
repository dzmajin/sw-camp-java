package com.dzmajin.comprehensive.domain;

public enum Status {
    NOT_STARTE(0,"시작 전"),
    IN_PROGRESS(1,"진행 중"),
    COMPLETED (2,"완료");

    private final int order;
    private final String label;   // 화면 표기

    Status(int order,String label ) {
        this.order = order;
        this.label = label;
    }

    public int order() {return order;}
    public String label() {return label;}
}
