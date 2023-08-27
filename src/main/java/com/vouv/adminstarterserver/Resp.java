package com.vouv.adminstarterserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resp {
    private Integer code;
    private String message;
    private Object data;

    public static Resp ok() {
        return new Resp(20000, "ok", null);
    }

    public static Resp fail(String msg) {
        return new Resp(30000, msg, null);
    }

    public static Resp data(Object data) {
        return new Resp(20000, "data", data);
    }

    public static Resp needLogin(String msg) {
        return new Resp(40000, msg, null);
    }

}
