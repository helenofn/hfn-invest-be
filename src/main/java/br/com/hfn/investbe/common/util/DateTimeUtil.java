package br.com.hfn.investbe.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {

	public static Date getNowDate() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		return Date.from(now.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
	}
	
	public static Date getNowSumTimeDate(Long timeToSumSec) {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).plusSeconds(timeToSumSec);
		return Date.from(now.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
	}
	
}
