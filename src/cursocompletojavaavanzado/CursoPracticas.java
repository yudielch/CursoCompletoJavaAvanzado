package cursocompletojavaavanzado;

import java.util.ArrayList;
import java.util.List;

public class CursoPracticas {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Guisa");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");

//        for (int i = 0; i < cities.size(); i++) {
//            System.out.println(cities.get(i));
//        }
//        for (String cyti:cities) {
//            System.out.println(cyti);
//        }
// Expresion Lambda
//cities.stream().forEach(tycs -> System.out.println(tycs));
//cities.forEach(tycs -> System.out.println(tycs));
// Refercia de Metodos
//        cities.stream().forEach(Main::prinCity);
//        cities.forEach(Main::prinCity)
//cities.stream().forEach(System.out::println);
//        cities.forEach(System.out::println);
//        cities.stream().parallel().forEach(System.out::println);
//Filtrar x ciudades 
        cities.stream().filter(city -> city.startsWith("G"))
                //.filter(city -> city.contains("N"))
                .forEach(System.out::println);

//    public static void prinCity(String city) {
//        System.out.println(city);
//    }
    }

    public static boolean filerCity(String city) {
        return city.startsWith("B");
    }
}
