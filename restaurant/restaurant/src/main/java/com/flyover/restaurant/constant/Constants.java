package com.flyover.restaurant.constant;

import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;

@Configuration
public class Constants {
    public static DecimalFormat decimalFormat = new DecimalFormat("0.00");
    public enum restaurantType{CAFE,RESTAURANT}
}
