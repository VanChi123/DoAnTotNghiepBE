package com.mta.shop.configure;

public @interface Constant {

    String WEB_MAIL = "noreply.webonthi@gmail.com";
//    String WEB_MAIL = "chishopwatch@gmail.com";
    String WEB_MAIL_PASS = "at14kmateam";
    String OTP_CHANGE_PASSWORD = "THAY ĐỔI MẬT KHẨU";
    String OTP_LOGIN = "ĐĂNG NHẬP TÀI KHOẢN";
    String LOGIN = "LOGIN";
    String FORGOT_PASSWORD = "FORGOT";
    String AUTHORIZATION = "Authorization";
    String BEARER = "Bearer ";
    long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    String ROLE = "ROLE";
    String IP = "ip";
    String USER_AGENT = "userAgent";
    String FULL_NAME = "fullname";
    String ROLE_ADMIN = "ROLE_ADMIN";
    String ROLE_USER = "ROLE_USER";
    Boolean ACTIVE_STATUS = true;
    Boolean DE_ACTIVE_STATUS = false;
    String DO_EXAM = " (Thi lại lần ";
    String IMAGES_DIR_DEFAULT = "src/main/resources/images";
    Integer DEFAULT_PAGE_SIZE = 50;
}
