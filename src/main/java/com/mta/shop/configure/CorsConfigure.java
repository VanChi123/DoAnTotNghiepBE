//package com.mta.shop.configure;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class CorsConfigure extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.cors().configurationSource(new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                return new CorsConfiguration().applyPermitDefaultValues();
//            }
//        });
//    }
//}
