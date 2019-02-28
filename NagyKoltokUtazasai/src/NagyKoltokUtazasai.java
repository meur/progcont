import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NagyKoltokUtazasai {

	public static void main(String[] args) {
		HashMap<String, TreeSet<String>> jelenesek = new HashMap<>();
		
		(new BufferedReader(new InputStreamReader(System.in))).lines()
		.forEach(line -> {
			ArrayList<String> splitted = new ArrayList<>();
			splitted.addAll(Arrays.asList(line.split(":|;")));
			jelenesek.put(splitted.remove(0), new TreeSet<>(splitted.stream()
					.map(darab -> darab.split(",")[0])
					.collect(Collectors.toList())));
			;
		});
		
		jelenesek.forEach((key, value) -> {
			System.out.println(key + " (" + value.size() + "):");
			value.forEach(varos -> System.out.println(varos));
		});
	}

}
