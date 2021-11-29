package com.codecool.spingboot_tasks.error_handling.model;

public class BackendError {
    private String msg;
    private int level; //1 - critical(red), 2 - high(orange), 3 - low(yallow)

    public BackendError(String message, int i) {
        this.msg = message;
        this.level = i;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
