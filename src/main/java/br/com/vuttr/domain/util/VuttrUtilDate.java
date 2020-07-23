package br.com.vuttr.domain.util;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class VuttrUtilDate {

	public VuttrUtilDate() {

	}

	private ZonedDateTime zoneDateTime;
	private Instant instant;
	private OffsetDateTime offsetDateTime;

	public ZonedDateTime getZoneDateTime() {
		zoneDateTime = ZonedDateTime.now();
		return zoneDateTime;
	}

	public Instant getCurrentInstant() {
		instant = Instant.now();
		return instant;

	}

	public OffsetDateTime getCurrentOffsetDateTime() {
		offsetDateTime = OffsetDateTime.now();
		return offsetDateTime;

	}

}
