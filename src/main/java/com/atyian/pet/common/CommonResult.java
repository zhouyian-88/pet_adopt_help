package com.atyian.pet.common;

import javafx.stage.StageStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.OMGVMCID;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-02-17:38
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult {
    private final static String SUCCESS_CODE = "200";
    private final static String FAIL_CODE = "300";
    private String code;
    private String message;
    private Object Data;

    public static CommonResult success(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        return commonResult;
    }
    public static CommonResult success(Object data){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setData(data);
        return commonResult;
    }

    public static CommonResult fail(String message){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(FAIL_CODE);
        commonResult.setMessage(message);
        return commonResult;
    }


}
