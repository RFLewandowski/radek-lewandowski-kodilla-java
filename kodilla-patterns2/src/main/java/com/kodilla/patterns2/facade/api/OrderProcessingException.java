package com.kodilla.patterns2.facade.api;

public class OrderProcessingException extends Exception {
    public static String ERR_NOT_AUTHORISED = "";
    public static String ERR_PAYMENT_REJECTED = "";
    public static String ERR_VERIFICATION_ERROR = "";
    public static String ERR_SUBMITTING_ERROR = "";

    public OrderProcessingException(String message) {
        super(message);
    }
}