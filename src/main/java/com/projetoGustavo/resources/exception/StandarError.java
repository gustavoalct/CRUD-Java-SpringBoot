package com.projetoGustavo.resources.exception;

import java.io.Serializable;

public class StandarError implements Serializable { // serializable Basicamente ela serve para habilitar que um objeto de uma determinada classe possa ter seu estado persistido pela api padrão do java.

    private  Integer status;
    private String msg;
    private Long timeStamp;

    public StandarError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
