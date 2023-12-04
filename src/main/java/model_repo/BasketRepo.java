package model_repo;

import java.util.HashMap;
import java.util.Map;

public class BasketRepo {
    public static Map<Long, Map<Long, Integer>> BASKET_MAP = new HashMap<>();

    public static void add(long chatId, long productId, int quantity) {
        if (BASKET_MAP.get(chatId) != null) {
            BASKET_MAP.get(chatId).put(productId, quantity);
        } else {
            Map<Long, Integer> map = new HashMap<>();
            map.put(productId, quantity);
            BASKET_MAP.put(chatId, map);
        }
    }


}
