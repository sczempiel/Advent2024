package day02;

import util.AdventUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

//449 l
public class Day2Task2Main {

	public static void main(String[] args) {
		AtomicInteger valid = new AtomicInteger(0);

		AdventUtils.getStringInput(2).stream().map(s -> s.split(" ")).map(s ->
			Arrays.stream(s).map(Long::valueOf).toList()
		).forEach(r -> {

			if (isValid(r)) {
				valid.incrementAndGet();
			} else {
				boolean anyValid = IntStream.range(0, r.size()).mapToObj(i -> {
					List<Long> withRemoved = new ArrayList<>(r);
					withRemoved.remove(i);

					return isValid(withRemoved);
				}).anyMatch(Boolean.TRUE::equals);

				if (anyValid) {
					valid.incrementAndGet();
				}
			}

		});

		AdventUtils.publishResult(2, 2, valid.get());
	}

	private static boolean isValid(List<Long> r) {
		Boolean asc = null;

		long previous = r.get(0);

		for (int i = 1; i < r.size(); i++) {
			long current = r.get(i);

			if (Math.abs(current - previous) > 3) {
				return false;
			}

			if (asc == null) {
				asc = previous < current;
			}

			if (asc && previous >= current) {
				return false;
			}

			if (!asc && previous <= current) {
				return false;
			}

			previous = current;
		}
		return true;
	}

}
