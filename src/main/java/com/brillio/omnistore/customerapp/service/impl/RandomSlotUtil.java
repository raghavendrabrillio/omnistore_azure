package com.brillio.omnistore.customerapp.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public final class RandomSlotUtil {

	public static final int START_HOUR = 9;
	public static final int END_HOUR = 22;

	private RandomSlotUtil() {

	}

	public static Map<Timestamp, Boolean> getSlots(int startHour, int endHour) {
		LocalDateTime start = LocalDate.now().atTime(9, 0);
		LocalDateTime stop = LocalDate.now().atTime(22, 0);
		Set<LocalDateTime> slots = new HashSet<>();
		LocalDateTime ldt = start;
		while (ldt.isBefore(stop)) {
			slots.add(ldt);
			ldt = ldt.plusMinutes(30);
		}
		Collection<LocalDateTime> sortedSlots = slots.stream().collect(Collectors.toCollection(TreeSet::new));
		Map<Timestamp, Boolean> result = new LinkedHashMap<>();
		sortedSlots.stream().forEach((time) -> {
			result.put(Timestamp.valueOf(time), new Random().nextBoolean());
		});
		return result;
	}

	public static void main(String[] args) {
		Map<Timestamp, Boolean> scheduleSlotsDtos = getSlots(START_HOUR, END_HOUR);
		scheduleSlotsDtos.forEach((k, v) -> {
			System.out.println("available=" + v + ", slot=" + k);
		});
	}

	/*
	 * private static int getRandomMinutes(int low, int high) { Random r = new
	 * Random(); int result = r.nextInt(high - low) + low; int rounded = (int)
	 * Math.ceil(result / 5) * 5; return rounded; }
	 */

}
