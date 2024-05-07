package app;

import java.util.HashMap;
import java.util.Map;

public class AppMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Argentina", "Messi");
		map.put("Portugal", "Ronaldo");
		map.put("Paraguay", "Romero");
		map.put("Argentina", "Paredes");
		map.put("Brasil", "Neymar");
		map.put("Brasil", "Gabigol");
		map.put("Argentina", "Dybala");
		map.put("Paraguay", "Romera");
		map.put("Argentina", "Martinez");
		
		System.out.println(map.containsKey("Gabigol"));
		System.out.println(map.containsValue("Argentina"));
		System.out.println(map.getOrDefault("Neymar", "No esta"));
		System.out.println();
		
//		for (String string : map.keySet()) {
//			System.out.println(string);
//		}
//		System.out.println();
//		for (String string : map.values()) {
//			System.out.println(string);
//		}
		
		System.out.println(map.size());
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		map.clear();
		System.out.println(map.isEmpty());

	}

}
