package com.yunjisang.afterschool.afterschool.global.common;

import lombok.Data;

@Data
public class SuccessResponse<T> {
    private boolean success;
    private T data;

    public SuccessResponse(boolean success, T data) {
        this.data = data;
        this.success = success;
    }
}