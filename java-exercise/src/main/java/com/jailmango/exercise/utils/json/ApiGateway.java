package com.jailmango.exercise.utils.json;

import com.google.gson.Gson;
import org.apache.commons.lang3.reflect.TypeUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ApiGateway<T> {

    protected Result<T> sendRequest() {
        String respJson = "{\"code\":200,\"data\":\"\",\"message\":\"\"}";

        Gson gson = new Gson();
        Type dataType = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type = TypeUtils.parameterizeWithOwner(null, Result.class, dataType);
        Result<T> resp = gson.fromJson(respJson, type);
        return resp;
    }
}
