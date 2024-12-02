package day02;

import util.AdventUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Day2Task1Main {

	public static void main(String[] args) {
		AtomicInteger valid = new AtomicInteger(0);

		AdventUtils.getStringInput(2).stream().map(s -> s.split(" ")).map(s ->
			Arrays.stream(s).map(Integer::valueOf).toList()
		).forEach(r -> {

			Boolean asc = null;

			int previous = r.get(0);

			for (int i = 1; i < r.size(); i++) {
				int current = r.get(i);

				if (Math.abs(current - previous) > 3) {
					return;
				}

				if (asc == null) {
					asc = previous < current;
				}

				if (asc && previous >= current) {
					return;
				}

				if (!asc && previous <= current) {
					return;
				}

				previous = current;
			}

			valid.incrementAndGet();
		});

		AdventUtils.publishResult(2, 1, valid.get());
	}
}
