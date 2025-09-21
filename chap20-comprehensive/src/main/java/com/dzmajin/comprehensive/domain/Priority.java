package com.dzmajin.comprehensive.domain;

public enum Priority {
    P1_HIGH(0, "높음"), // 즉시 처리
    P2_MEDIUM(1, "보통"),
    P3_LOW(2, "낮음");

    private final int rank;     // 낮을수록 더 높은 우선순위
    private final String label; // 화면 표기

    Priority(int rank, String label) {
        this.rank = rank;
        this.label = label;
    }
    public int rank() { return rank; }
    public String label() { return label; }
}

