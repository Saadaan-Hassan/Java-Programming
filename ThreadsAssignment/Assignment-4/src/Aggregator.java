import java.util.HashMap;
import java.util.Map;


public class Aggregator {

    private static final Map<String, Integer> concatMap = new HashMap<>();
    private static long count1 = 0;
    private static long count2 = 0;
    public static void concatenate(Map<String, Integer> map){
            for (Integer v :
                    map.values()) {
//                System.out.println(v);
                count1 += v;
            }
            map.forEach(
                    (key, value) -> concatMap.merge(key, value, (v1,v2) -> v1+v2));

//        if (concatMap.isEmpty()){
//            concatMap = map;
//        }else {
//            for (Map.Entry<String, Integer> entry :
//                    map.entrySet()) {
//                for (Map.Entry<String, Integer> concEntry :
//                        concatMap.entrySet()) {
//                    if (entry.getKey().equals(concEntry.getKey()))
//                        concEntry.setValue(entry.getValue() + concEntry.getValue());
//                    else
//                        concatMap.put(entry.getKey(), entry.getValue());
//                }
//            }
//        }

    }
    public static void display(){

//        for (Map.Entry<String, Integer> entry :
//                concatMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        System.out.println(concatMap);
        System.out.printf("Total words are: %d\n", count1);

        for (Integer v :
                concatMap.values()) {
            count2+=v;
        }
        System.out.printf("Total words are: %d", count2);

    }
}
