package generactive.util;

import generactive.model.Group;
import generactive.model.Item;

import java.util.Scanner;

public class ConsoleManager {
    private static Scanner scanner = new Scanner(System.in);
    private static String userCommand = "";

    private ConsoleManager() {
    }

    //At first in console we create groups hierarchy
    public static Group createGroup() {
        Group group = new Group();

        System.out.println("Please Enter the name of Group");
        String name = scanner.nextLine();
        group.setName(name);
        group.setId(GroupsManager.getId());

        System.out.println("Please Enter the ID of the parent group, or press 'Enter'");
        String id = scanner.nextLine();
        if (!id.isEmpty()) {
            group.setParentGroup(GroupsManager.getByID(Integer.parseInt(id)));
        }

        System.out.println("Please input 'continue' if You want to finish creation of groups, and go to next step, or press 'Enter'");
        userCommand = scanner.nextLine();
        return group;
    }

    //Then we create an Item and add it to defined group
    public static Item createItem() {
        Item item = new Item();

        System.out.println("Please Enter the name of Item");
        String name = scanner.nextLine();
        System.out.println("Please Enter the price of Item");
        int price = Integer.parseInt(scanner.nextLine());

        item.setName(name);
        item.setPrice(price);

        System.out.println("Please input 'exit' if You want to finish adding Items, or press 'Enter'");
        userCommand = scanner.nextLine();
        return item;
    }

    public static String getUserCommand() {
        return userCommand;
    }
}
