package com.jailmango.exercise.utils.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CreateRequest {

    private Integer status;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        CreateRequest request = new CreateRequest();

        // Gson gson = new Gson();
        // Type dataType = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        // Type type = TypeUtils.parameterizeWithOwner(null, ApiResponse.class, dataType);
        // ApiResponse<T> resp = gson.fromJson(respJson, type);

        switch (request.getStatus()) {
            case 1:
                log.info("1");
                break;
            case 2:
                log.info("2");
                break;
            default:
                log.info("null");
                break;
        }
    }
}
