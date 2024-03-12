package com.xust.VO;


import com.xust.core.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ResultJson<T> {

    private Integer code;
    private T content;
    private String message;

    public static <T> ResultJson<T> getInstance(ResultCode resultCode,T content,String message){
        return new ResultJson<>(resultCode.getCode(),content,message);
    }
    public static <T> ResultJson<T> getResultJson(T content,String message){
        return new ResultJson<>(ResultCode.SUCCESS.getCode(),content,message);
    }

    public static <T> ResultJson<T> success(T content,String message){
        return getInstance(ResultCode.SUCCESS,content,message);
    }

    public static <T> ResultJson<T> success(T content){
        return getInstance(ResultCode.SUCCESS,content,null);
    }

    public static <T> ResultJson<T> failed(T content,String message){
        return getInstance(ResultCode.FAILED,content,message);
    }

    public static <T> ResultJson<T> failed(String message){
        return failed(null,message);
    }



}
