package cn.houhe.api.loan.service.pay.versionSMS;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Mapping {
	String value();
}
