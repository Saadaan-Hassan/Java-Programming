import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Aggregator {

    private static final ArrayList<Map<String, Integer>> maps = new ArrayList<>();
    private static final Map<String, Integer> concatMap = new HashMap<>();

    public static void collectMaps(Map<String, Integer> map){
        maps.add(map);
    }

    public static void concatenate() {
        for (Map<String, Integer> m :
                maps) {
            m.forEach(
                    (key, value) -> concatMap.merge(key, value, Integer::sum));
        }
    }


    public static void writeInFile(String fileName){
        getMaps();

//        for (Map.Entry<String, Integer> entry :
//                concatMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        FileHandling.writeToFile(fileName,getConcatMap());

    }

    public static ArrayList<Map<String, Integer>> getMaps() {
        concatenate();
        return maps;
    }

    public static Map<String, Integer> getConcatMap(){
        return concatMap;
    }
}
