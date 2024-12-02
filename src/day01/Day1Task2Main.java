package day01;

import util.AdventUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1Task2Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> matches = new HashMap<>();

		AdventUtils.getStringInput(1).stream().map(s -> s.split("   ")).forEach(s -> {
			list.add(Integer.valueOf(s[0]));

			matches.compute(Integer.valueOf(s[1]), (k, v) -> v == null ? 1 : ++v);
		});

		int similarityScore = list.stream().mapToInt(Integer::valueOf).map(i -> i * matches.getOrDefault(i, 0)).sum();

		AdventUtils.publishResult(1, 2, similarityScore);
	}

}
