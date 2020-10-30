package com.mta.shop.repository;

import com.mta.shop.controllers.message.GetOTPRequest;
import com.mta.shop.controllers.message.GetOTPResponse;
import com.mta.shop.entities.TaiKhoanEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
    private final UserRepository userRepository;

//    @Autowired
//    private OtpService otpService;

    @Autowired
    private JavaMailSender emailSender;

//    @Autowired
//    private EmailService emailService;

    public TaiKhoanEntity checkLogin(String userName, String password) {
        Optional<TaiKhoanEntity> taiKhoanEntity = userRepository.findByTenDangNhapAndMatKhau(userName, password);
        return taiKhoanEntity.isPresent() ? taiKhoanEntity.get() : null;
    }

    public GetOTPResponse generateOtp(GetOTPRequest request, String purpose) throws ServiceException, MessagingException {

        //Integer otpValue = otpService.generateOtp(user.get().getUsername() + (purpose.equals(Constant.OTP_LOGIN) ? Constant.LOGIN : Constant.FORGOT_PASSWORD));
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(10000);
        // Sent mail
        if (-1 != rand_int1) {
            // fetch user e-mail from database
            List<String> recipients = new ArrayList<>();
            //recipients.add(user.get().getEmail());
            recipients.add("chibuivan97@gmail.com");
            // generate emailDTO object
//                EmailDto emailDTO = new EmailDto();
//                emailDTO.setSubject("WebOnThi - Thi trắc nghiệm trực tuyến miễn phí 2020");
//                emailDTO.setBody("
//                emailDTO.setRecipients(recipients);
//                emailDTO.setIsHtml(true);

            // send generated e-mail
//                emailService.sendMessage(emailDTO);

            String content = "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\"bgcolor=\"#f0f0f0\">\n" +
                        "        <tr>\n" +
                        "        <td style=\"padding: 30px 30px 20px 30px;\">\n" +
                        "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" bgcolor=\"#ffffff\" style=\"max-width: 650px; margin: auto;\">\n" +
                        "            <tr>\n" +
                        "                <td colspan=\"2\" align=\"center\" style=\"background-color: #f3f8fd; padding: 40px;\">\n" +
                        "                    <a href=\"http://cwatch.com/\" target=\"_blank\"><img src=\"https://hoctot.com/images/logo.png\" border=\"0\" /></a>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td colspan=\"2\" align=\"center\" style=\"padding: 50px 50px 0px 50px;\">\n" +
                        "                    <h1 style=\"padding-right: 0em; margin: 0; line-height: 40px; font-weight:300; font-family: 'Nunito Sans', Arial, Verdana, Helvetica, sans-serif; color: #666; text-align: left; padding-bottom: 1em;\">\n" +
                        "                        Email OTP\n" +
                        "                    </h1>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td style=\"text-align: left; padding: 0px 50px;\" valign=\"top\">\n" +
                        "                    <p style=\"font-size: 18px; margin: 0; line-height: 24px; font-family: 'Nunito Sans', Arial, Verdana, Helvetica, sans-serif; color: #666; text-align: left; padding-bottom: 3%;\">\n" +
                        "                        Chào bạn " + request.getUsername() + ", \n" +
                        "                    </p>\n" +
                        "                    <p style=\"font-size: 18px; margin: 0; line-height: 24px; font-family: 'Nunito Sans', Arial, Verdana, Helvetica, sans-serif; color: #666; text-align: left; padding-bottom: 3%;\">\n" +
                        "                        ĐỂ " + purpose + ", mã xác minh là <span style=\"background-color: #F0F0F0; font-size: 20px; color: #3DA9F5\">" + rand_int1 + "</span>. Có hiệu lực trong 1 phút. KHÔNG chia sẻ mã này cho bất kì ai khác.\n" +
                        "                    </p>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td style=\"text-align: left; padding: 30px 50px 50px 50px\" valign=\"top\">\n" +
                        "                    <p style=\"font-size: 18px; margin: 0; line-height: 24px; font-family: 'Nunito Sans', Arial, Verdana, Helvetica, sans-serif; color: #505050; text-align: left;\">\n" +
                        "                        Thanks,<br/>CWatch Website\n" +
                        "                    </p>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td colspan=\"2\" align=\"center\" style=\"padding: 20px 40px 40px 40px;\" bgcolor=\"#f0f0f0\">\n" +
                        "                    <p style=\"font-size: 12px; margin: 0; line-height: 24px; font-family: 'Nunito Sans', Arial, Verdana, Helvetica, sans-serif; color: #777;\">\n" +
                        "                        &copy; 2020\n" +
                        "                        <a href=\"http://cwatch.com/\" target=\"_blank\" style=\"color: #777; text-decoration: none\">cwatch.com</a>\n" +
                        "                        <br>\n" +
                        "                        29A Đỗ Nhuận, P. Xuân Đỉnh, Q. Bắc Từ Liêm, Tp. Hà Nội.\n" +
                        "                    </p>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            </table>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "</table>";

            MimeMessage mailMessage = emailSender.createMimeMessage();
            boolean multipart = true;
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, multipart, "UTF-8");

//        helper.setTo(emailDTO.getRecipients().stream().collect(Collectors.joining(",")));
//        mailMessage.setSubject(emailDTO.getSubject());
//        mailMessage.setContent(emailDTO.getBody(), "text/html;charset=UTF-8");

            helper.setTo(recipients.stream().collect(Collectors.joining(",")));
            mailMessage.setSubject("Chi Shop Watch xin chào!!!");
            mailMessage.setContent(content, "text/html;charset=UTF-8");

            Boolean isSent = false;
            emailSender.send(mailMessage);
            isSent = true;

        }
        return new GetOTPResponse(true, Base64.getEncoder().encodeToString(String.valueOf(rand_int1).getBytes()));
    }
}

//    public ChangeForgotPassResponse changeForgotPassword(ChangeForgotPassRequest request) throws ServiceException {
//        try {
//            if (null == request) ServiceUtil.generateEmptyPayloadError();
//            if (null == request.getOtp())
//                throw ServiceExceptionBuilder.newBuilder()
//                        .addError(new ValidationErrorResponse("Otp", ValidationError.NotNull))
//                        .build();
//            if (null == request.getUsername() && null == request.getEmail())
//                throw ServiceExceptionBuilder.newBuilder()
//                        .addError(new ValidationErrorResponse("Username or email", ValidationError.NotNull))
//                        .build();
//            if (null != request.getUsername() && null != request.getEmail()) {
//                throw ServiceExceptionBuilder.newBuilder()
//                        .addError(new ValidationErrorResponse("You must be use", "username or email"))
//                        .build();
//            }
//            if (null != request.getEmail()) {
//                Optional<User> user = Optional.ofNullable(userRepository.findByEmail(request.getEmail()));
//                if (user.isPresent()) request.setUsername(user.get().getUsername());
//            }
//
//            if (true == otpService.validateOTP(request.getUsername() + Constant.FORGOT_PASSWORD, request.getOtp())) {
//                User user = userRepository.findByUsername(request.getUsername());
//                user.setPassword(bcryptEncoder.encode(request.getNewPassword()));
//                userRepository.save(user);
//                return new ChangeForgotPassResponse(true);
//            } else {
//                throw ServiceExceptionBuilder.newBuilder()
//                        .addError(new ValidationErrorResponse("OTP", ValidationError.Invalid))
//                        .build();
//            }
//        } catch (ServiceException e) {
//            throw e;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
