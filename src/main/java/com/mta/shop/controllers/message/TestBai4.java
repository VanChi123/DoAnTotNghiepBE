package com.mta.shop.controllers.message;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestBai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean trueFormat = false;
        while (!trueFormat) {
            System.out.println("Nhập vào chuỗi bất kỳ định dạng: yyyy-MM-dd: ");
            String chuoi = scanner.nextLine();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date;

            try {
                date = dateFormat.parse(chuoi);
                try{
                    DateTimeInputException.validateYear(date.getYear());
                }catch (Exception m){
                    System.out.println("lỗi "+ m);
                }
                try{
                    DateTimeInputException.validateMonth(date.getMonth());
                }catch (Exception m){
                    System.out.println("lỗi "+ m);
                }
                try{
                    DateTimeInputException.validateDay(date.getDay());
                }catch (Exception m){
                    System.out.println("lỗi "+ m);
                }
                System.out.println(date);
                trueFormat = true;

            } catch (ParseException e) {
                System.out.println("Lỗi: " + e);
                break;
            }
        }
    }
}

class DateTimeInputException {
    static void validateMonth(int month) throws DateTimeException {
        if (month > 12) {
            throw new DateTimeException("month not valid");
        } else if (month < 1){
            throw new DateTimeException("month not valid");
        }else {
            System.out.println("Month Hợp lệ");
        }
    }

    static void validateDay(int day) throws DateTimeException {
        if (day > 31) {
            throw new DateTimeException("day not valid");
        } else if (day < 1){
            throw new DateTimeException("day not valid");
        }else {
            System.out.println("Day Hợp lệ");
        }
    }

    static void validateYear(int year) throws DateTimeException {
        if (year < 0) {
            throw new DateTimeException("day not valid");
        } else {
            System.out.println("Năm Hợp lệ");
        }
    }
}

class DateTimeException extends Exception{
    DateTimeException(String s){
        super(s);
    }
}
