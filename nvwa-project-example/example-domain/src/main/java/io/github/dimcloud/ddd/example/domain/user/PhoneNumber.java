package io.github.dimcloud.ddd.example.domain.user;

import lombok.Getter;
import lombok.Setter;
import io.github.dimcloud.nvwa.ddd.domain.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * phone number value object
 *
 * @author hehe
 * 2020/10/26 10:29 上午
 **/
public class PhoneNumber implements ValueObject<PhoneNumber> {

    private static final Pattern PHONE_VALIDATE = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");

    @Getter
    @Setter
    private String number;

    public PhoneNumber(String number){
        Matcher matcher = PHONE_VALIDATE.matcher(number);
        if(!matcher.matches()){
            throw new IllegalArgumentException("phone is wrong");
        }
        this.number = number;
    }

    public static PhoneNumber of(String number){
        return new PhoneNumber(number);
    }

    @Override
    public Boolean sameAs(PhoneNumber other) {
        return this.number.equals(other.number);
    }
}
