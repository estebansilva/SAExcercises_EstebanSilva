package Clase5.Constants;

import com.github.javafaker.Faker;

public class AccountConstants {

    public static final String NAME_COMPANY = "Name Company";
    public static final String ACCOUNT_PASSWORD = "Password1234";
    public static final String ACCOUNT_ADDRESS = "addressField 451";
    public static final String ACCOUNT_CITY= "RockSario";
    public static final String ACCOUNT_STATE = "Delaware";
    public static final String ACCOUNT_POSTCODE = "12345";
    public static final String ACCOUNT_PHONE = "4646464";
    public static final String ACCOUNT_MOBILEPHONE = "461616161";
    public static final String ACCOUNT_ALIAS = "Alias";
    public static final String ACCOUNT_BIRTHDAY_DAY = "27";
    public static final String ACCOUNT_BIRTHDAY_MONTH = "9";
    public static final String ACCOUNT_BIRTHDAY_YEAR = "1990";

    public static Faker FAKER = new Faker();

    public static final String ACCOUNT_NAME_PERSON = FAKER.name().firstName();
    public static final String ACCOUNT_LASTNAME_PERSON = FAKER.name().lastName();
    public static final String ACCOUNT_EMAIL = ACCOUNT_NAME_PERSON+ACCOUNT_LASTNAME_PERSON+Math.random()+"@"+"mail.com";

    public static final String EXISTING_ACCOUNT_MSG = "An account using this email address has already been registered. Please enter a valid password or request a new one.";


}
