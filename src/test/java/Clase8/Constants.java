package Clase8;

import com.github.javafaker.Faker;

public class Constants {

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

}
