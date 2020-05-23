package com.example.myapplication.DangKiTOTP;

public class XacThucOTPTruyenra_Model {
    private String requestid;
    private String ec;
    private String em;
    private Detail detail;

    public XacThucOTPTruyenra_Model(String requestid, String ec, String em, Detail detail) {
        this.requestid = requestid;
        this.ec = ec;
        this.em = em;
        this.detail = detail;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public Detail getDetail() {
        return detail;
    }

    public  void setDetail(Detail detail) {
        this.detail = detail;
    }
    public static class Detail {
        private String type;
        private String authid;
        private String token;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAuthid() {
            return authid;
        }

        public void setAuthid(String authid) {
            this.authid = authid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
