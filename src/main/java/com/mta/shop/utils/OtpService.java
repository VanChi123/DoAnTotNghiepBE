package com.mta.shop.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

@Description(value = "Service responsible for handling OTP related functionality.")
@Service
public class OtpService {

    private final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);

    @Autowired
    private OtpGenerator otpGenerator;

//    @Autowired
//    private com.mta.shop.services.utils.EmailService emailService;

    /**
     * Method for generate OTP number
     *
     * @param user - provided key (username in this case)
     * @return boolean value (true|false)
     */
    public Integer generateOtp(String key)
    {
        // generate otp
        Integer otpValue = otpGenerator.generateOTP(key);
        if (otpValue == -1) LOGGER.error("OTP generator is not working...");
        LOGGER.info("Generated OTP: {}", otpValue);
        return otpValue;
    }

    /**
     * Method for validating provided OTP
     *
     * @param key - provided key
     * @param otpNumber - provided OTP number
     * @return boolean value (true|false)
     */
    public Boolean validateOTP(String key, Integer otpNumber)
    {
        // get OTP from cache
        Integer cacheOTP = otpGenerator.getOPTByKey(key);
        if (cacheOTP.equals(otpNumber))
        {
            otpGenerator.clearOTPFromCache(key);
            return true;
        }
        return false;
    }
}
