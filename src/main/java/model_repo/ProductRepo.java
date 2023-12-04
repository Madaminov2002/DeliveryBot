package model_repo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    public static final List<ProductModel> PRODUCT_LIST = new ArrayList<>();

    static {
        PRODUCT_LIST.addAll(List.of(ProductModel.builder().id(1).name(" Classic burger\n")
                        .description("Soft bun, tender chicken fillet (Halal), fresh tomatoes, pickled cucumbers, salad leaves, mayonnaise and ketchup sauces \n" + "\n").price(22000F).build(),
                ProductModel.builder().id(2).name(" Chicken cheese \n").description("Soft bun, juicy chicken cutlet (Halal), cheddar cheese, fresh tomatoes, iceberg lettuce, mayonnaise and ketchup sauces \n" +
                        "\n").price(23000F).build(),
                ProductModel.builder().id(3).name(" BBQ burger \n").description("Soft bun,juicy chucken cutlet (Halal) in author’s breading, fresh tomatoes, Iceberg lettuce, mayonnaise and BBQ sauce \n" + "\n")
                        .price(24000F).build(),
                ProductModel.builder().id(4).name(" Double chicken cheese \n").description("Soft bun,two juicy chucken cutlets (Halal), cheddar cheese, fresh tomatoes, pickles, iceberg lettuce, mayonnaise and ketchup \n" + "\n")
                        .price(30000F).build(),
                ProductModel.builder().id(5).name("Montella \n").price(3000F).build(),
                ProductModel.builder().id(6).name("Fanta \n").price(6000F).build(),
                ProductModel.builder().id(7).name("Sprite \n").price(5000F).build(),
                ProductModel.builder().id(8).name("Caesar \n").description("Сhicken fillet (Halal), Parmesan cheese, cherry tomaotes, croutons, iceberg lettuce, caesar sauce \n")
                        .price(26000F).build(),
                ProductModel.builder().id(9).name("Sezam \n").description("Iceberg lettuce, chicken fillet, served with seeds and Teriyaki sauce  \n")
                        .price(22000F).build(),
                ProductModel.builder().id(10).name("Greek\n").description(" A traditional Greek salad consists of sliced cucumbers, tomatoes, green bell pepper, red onion, olives, and feta cheese\n").price(25000F)
                        .build()
        ));
    }

    public static ProductModel getById(long id) {
        return PRODUCT_LIST.stream().filter(product -> product.getId() == id).findFirst().orElseThrow();
    }
}
