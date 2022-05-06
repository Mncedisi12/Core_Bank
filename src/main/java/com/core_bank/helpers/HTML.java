package com.core_bank.helpers;

public class HTML {

    public static String htmlEmailTemplate(String token, int code){

//        Verify Account URL:
        String url = "http://localhost:8070/verify?token=" + token + "&code=" + code;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <!-- <link rel='stylesheet' href='css/email.css'> -->\n" +
                "    <title>Email</title>\n" +
                "    <style>\n" +
                "\n" +
                "        *{\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: Comfortaa;\n" +
                "\n" +
                "            }\n" +
                "            body{\n" +
                "                height: 100vh;\n" +
                "                background-color: rgb(212, 222, 230);\n" +
                "                display: flex;\n" +
                "                align-items: center;\n" +
                "                justify-content: center;\n" +
                "            }\n" +
                "            /* wrapper */\n" +
                "            .wrapper{\n" +
                "\n" +
                "                width: 550px;\n" +
                "                height: auto;\n" +
                "                padding: 15px;\n" +
                "                background-color: white;\n" +
                "                border-radius: 7px;\n" +
                "            }\n" +
                "\n" +
                "            /* email Mdg Header */\n" +
                "            .email-msg-header{\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "            /* company name */\n" +
                "            .company-name{\n" +
                "                width: 100%;\n" +
                "                font-size: 35px;\n" +
                "                color: gray;\n" +
                "                text-align: center;\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            /* Welcome Text */\n" +
                "            .welcome-text{\n" +
                "                text-align: center;\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            /* Verify Account */\n" +
                "            .verify-account-btn{\n" +
                "                padding: 15px;\n" +
                "                background-color: rgb(0, 109, 252); \n" +
                "                text-decoration: none;\n" +
                "                color: white;\n" +
                "                border-radius: 5px;\n" +
                "            }\n" +
                "\n" +
                "            /* Copy Right */\n" +
                "\n" +
                "            .copy-right{\n" +
                "            justify-content: center;\n" +
                "                padding: 15px;\n" +
                "                color: gray;\n" +
                "                font-size: 14px;\n" +
                "                margin: 20px 0px;\n" +
                "                display: flex;\n" +
                "                align-items: center;\n" +
                "            }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <!-- wrapper -->\n" +
                "    <div class=\"wrapper\">\n" +
                "\n" +
                "        <!-- Email MSG Header -->\n" +
                "        <h2 class='email-msg-header'>\n" +
                "            Welcome and Thank you for choosing  \n" +
                "        </h2>\n" +
                "        <!-- End Of Email MSG Header -->\n" +
                "\n" +
                "        <!-- Company Name -->\n" +
                "        <div class='company-name' >Core-Bank </div> \n" +
                "\n" +
                "        <!-- End Of company Name  -->\n" +
                "\n" +
                "        <hr>\n" +
                "        <!-- Welcome Text -->\n" +
                "        <p class='welcome-text'>\n" +
                "            Your Account has been successfully registered, Please click below to verify your account.\n" +
                "        </p>\n" +
                "        <!-- End Of Welcome Text -->\n" +
                "\n" +
                "        <br>\n" +
                "        <br>\n" +
                "        \n" +
                "        <!-- Verify Account  -->\n" +
                "\n" +
                "        <center><a href='"+ url +"' class='verify-account-btn' role='button'>Verify Account</a></center>\n" +
                "\n" +
                "        <!-- End Of Verify Account -->\n" +
                "\n" +
                "        <!-- CopyRight Wrapper  -->\n" +
                "\n" +
                "        <div class='copy-right'>\n" +
                "            &copy; Copy Right 2022. All Right Reserved.\n" +
                "        </div>\n" +
                "        <!-- END Of CopyRight Wrapper -->\n" +
                "    </div>\n" +
                "    <!-- End Of Wrapper -->\n" +
                "    \n" +
                "</body>\n" +
                "</html>";

        return emailTemplate;
    }
}
