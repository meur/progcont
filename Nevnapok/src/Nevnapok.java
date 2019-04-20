import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Nevnapok {

	public static void main(String[] args) throws IOException {
		final Scanner olvas = new Scanner(System.in);
		final Map<Integer, List<String>> nevnapok = new TreeMap<>();
		final Map<String, List<String>> osztalyok = new TreeMap<>();
		
		for (int i = 0; i < 30; i++) {
			String[] nap = olvas.nextLine().split(":");
			nevnapok.put(Integer.parseInt(nap[0]), Arrays.asList(nap[1].split(",")));
		}

		while (olvas.hasNextLine()) {
			String[] osztaly = olvas.nextLine().split(":");
			osztalyok.put(osztaly[0], Arrays.asList(osztaly[1].split(",")));
		}
		olvas.close();
		
		osztalyok.entrySet().stream().forEach(osztaly -> {
			System.out.println(osztaly.getKey() + ":");
			
			nevnapok.entrySet().stream()
				.map(nap -> new AbstractMap.SimpleEntry<Integer, List<String>>(
						nap.getKey(),
						osztaly.getValue().stream()
							.filter(nev -> {
								return nap.getValue().contains(nev.split(" ")[1]);
							})
							.sorted()
							.collect(Collectors.toList())))
				.filter(nap -> !nap.getValue().isEmpty())
				.forEach(nap -> {
					System.out.print(nap.getKey() + ":");
					System.out.print(nap.getValue().remove(0));
					if (nap.getValue().size() > 0) {
						nap.getValue()
							.forEach(nev -> System.out.print("," + nev));
					}
					System.out.println();
				});
		});
	}
}
