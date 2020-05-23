package com.example.myapplication.DangKiTOTP;

public class XacThucOTPTruyenvao_Model {
    private String requestid;
    private String method;
    private Detail detail;

    public XacThucOTPTruyenvao_Model(String requestid, String method, Detail detail) {
        this.requestid = requestid;
        this.method = method;
        this.detail = detail;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public static class Detail {

        private String type;
        private String registerid;
        private String token;

        public Detail(String type, String registerid, String token) {
            this.type = type;
            this.registerid = registerid;
            this.token = token;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRegisterid() {
            return registerid;
        }

        public void setRegisterid(String registerid) {
            this.registerid = registerid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
