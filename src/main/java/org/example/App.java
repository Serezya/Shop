package org.example;

//S - весь созданный магазин разделен на классы, каждый из которых имеет свою законченную функцию
//O - С помощью наследования, не изменяя Item, добавлены Food и ForHome
//L - Food и ForHome являются расширением Item
//I - интерфейс с одним методом для конкретного назначения
//D - при выборе фильтрации зависим от интерфейса Sort, а не от конкретных реализаций

//  Учтено правило Magics - нет магических чисел в циклах и пр.

//  Учтено правило DRY. Повторяющиеся блоки кода вынесены в отдельные методы.

//  Применен шаблон Builder для User

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Item>> goods = new HashMap<>();
        List<Item> cart = new ArrayList<>();

        addGoods(goods);
        User user = new UserBuilder()
                .setName("Иван")
                .setSurname("Петров")
                .setId(1)
                .build();

        while (true) {
            System.out.println("Выберите категорию товаров");
            printCategories(goods);
            String categoryStr = scanner.nextLine();

            if (!goods.containsKey(categoryStr)) {
                System.out.println("Нет такой категории");
                continue;
            } else {
                System.out.println("Товары, доступные к покупке:");
                printGoods(goods, categoryStr);
            }

            System.out.println("Если хотите отфильтровать товары, напишите \"yes\", если нет, то нажмите enter");
            String ToFilter = scanner.nextLine();
            if (ToFilter.equals("yes")) {
                System.out.println("Фильтрация:\n"
                        + "1 - по цене\n"
                        + "2 - по наименованию\n"
                        + "3 - по рейтингу");
                int filterNum = scanner.nextInt();
                filter(filterNum, goods, categoryStr);
            }

            System.out.println("Введите название товара для добавления в корзину");
            String good = scanner.nextLine();

            if (findGood(goods, categoryStr, good) != null) {
                cart.add(findGood(goods, categoryStr, good));
            } else {
                System.out.println("Такого товара нет");
            }

            user.setCart(cart);

            System.out.println("Закончить покупку? \"да\" или Enter, чтобы продолжить");
            String cont = scanner.nextLine();
            if (cont.equals("да")) {
                printCart(cart);
                Order order = new Order(user, 1);
                adminOrders(order);
                break;
            }
        }
    }

    private static void filter(int filterNum, Map<String, List<Item>> goods, String categoryStr) {
        switch (filterNum) {
            case 1:
                Sort sortByPrice = new SortPrice();
                sortByPrice.sort(goods.get(categoryStr));
                printGoods(goods, categoryStr);
                break;
            case 2:
                Sort sortByName = new SortName();
                sortByName.sort(goods.get(categoryStr));
                printGoods(goods, categoryStr);
                break;
            case 3:
                Sort sortByRating = new SortRating();
                sortByRating.sort(goods.get(categoryStr));
                printGoods(goods, categoryStr);
        }
    }

    private static void addGoods(Map<String, List<Item>> goods) {
        List<Item> foods = new ArrayList<>();
        foods.add(new Food("Яблоки", 60, 5, Food.ItemsCategory.FRUITS));
        foods.add(new Food("Помидоры", 120, 4, Food.ItemsCategory.VEGETABLES));
        goods.put("Продукты", foods);

        List<Item> products = new ArrayList<>();
        products.add(new ForHome("Средство для мытья полов", 350, 5, ForHome.ItemsCategory.CLEAN_AGENT));
        products.add(new ForHome("Керамический нож", 2000, 4, ForHome.ItemsCategory.KITCHEN_APPLIENCES));
        goods.put("Для дома", products);
    }

    private static void adminOrders(Order order) {
        System.out.println("\n\n-----------------------------------");
        System.out.println("Вы находитесь в разделе приема заказа\n");
        order.newOrder(order.getUser(), order.getStatus());
        order.setStatus(Tracking.IN_PROCESSING);
        System.out.println("Заказ находится в обработке!");
        order.setStatus(Tracking.IS_ON_THE_WAY);
        System.out.println("Заказ передан службе доставки!");
        order.setStatus(Tracking.DELIVERED);
        System.out.println("Заказ успешно доставлен!");

        order.printOrders();
    }

    public static void printCart(List<Item> cart) {
        System.out.println("Корзина:");
        for (Item i : cart) {
            System.out.println(i);
        }
        System.out.println("Общая стоимость: " + sumCost(cart));
    }

    public static int sumCost(List<Item> cart) {
        int cost = 0;
        for (Item i : cart) {
            cost += i.getPrice();
        }
        return cost;
    }

    public static void printCategories(Map<String, List<Item>> goods) {
        int i = 0;
        for (String s : goods.keySet()) {
            i++;
            System.out.println(i + ". " + s);
        }
    }

    public static void printGoods(Map<String, List<Item>> goods, String category) {
        for (int i = 0; i < goods.get(category).size(); i++) {
            System.out.println(i + 1 + ". " + goods.get(category).get(i));
        }
    }

    public static Item findGood(Map<String, List<Item>> goods, String category, String good) {
        for (Item item : goods.get(category)) {
            if (item.getName().equals(good)) return item;
        }
        return null;
    }
}