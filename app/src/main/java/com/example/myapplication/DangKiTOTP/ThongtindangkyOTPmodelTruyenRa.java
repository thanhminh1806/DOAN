package com.example.myapplication.DangKiTOTP;

public class ThongtindangkyOTPmodelTruyenRa {
    private String requestid;
    private String ec;
    private String em;
    private Detail detail;

    public ThongtindangkyOTPmodelTruyenRa(String requestid, String ec, String em, Detail detail) {
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
        private String imageBase64;
        private String secretKey;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImageBase64() {
            return imageBase64;
        }

        public void setImageBase64(String imageBase64) {
            this.imageBase64 = imageBase64;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }
    }
}
