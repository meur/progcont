import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NagyKoltokUtazasai {

	public static void main(String[] args) {
		TreeMap<String, TreeSet<String>> jelenesek = new TreeMap<>();
		
		(new BufferedReader(new InputStreamReader(System.in))).lines()
		.forEach(line -> {
			ArrayList<String> splitted = new ArrayList<>(Arrays.asList(line.split(":|;")));
			String varos = splitted.remove(0);
			
			List<String> szemelyek = splitted.stream()
					.map(jelenes -> jelenes.split(",")[0])
					.collect(Collectors.toList());			
			szemelyek.forEach(szemely -> {
				if (!jelenesek.containsKey(szemely)) {
					jelenesek.put(szemely, new TreeSet<>());
				}
				jelenesek.get(szemely).add(varos);
			});
		});
		
		jelenesek.forEach((key, value) -> {
			System.out.println(key + " (" + value.size() + "):");
			value.forEach(szemely -> System.out.println(szemely));
		});
	}

}
