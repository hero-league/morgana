package com.morgana.common.domain.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 3204676850719722636L;

    private String id;

    private String code;

    private String name;

    private String status;

    private String pwd;

    private List<UserRole> userRoles;

    @Data
    public static class UserRole{

        private String id;

        private String code;

        private String name;
    }

}
