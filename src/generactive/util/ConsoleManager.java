package generactive.util;

import generactive.model.Group;

import java.util.Scanner;

public class ConsoleManager {
    private static Scanner scanner = new Scanner(System.in);
    private static String userCommand = "";

    //Group fields
    private static String groupName;
    private static Group parentGroup;

    //Item fields
    private static String itemName;
    private static int price;

    private ConsoleManager() {
    }

    //At first in console we collect some mandatory information about Group
    public static void readGroup() {
        System.out.println("Please Enter the name of Group");
        groupName = scanner.nextLine();

        System.out.println("Please Enter the ID of the parent group, or press 'Enter'");
        String id = scanner.nextLine();
        if (!id.isEmpty()) {
            int groupID = Integer.parseInt(id);
            parentGroup = GroupsManager.getByID(groupID);
        }

        System.out.println("Please input 'continue' if You want to finish creation of groups, and go to next step, or press 'Enter'");
        userCommand = scanner.nextLine().toUpperCase();
    }

    //Then we collect some mandatory information about Item
    public static void readItem() {

        System.out.println("Please Enter the name of Item");
        itemName = scanner.nextLine();
        System.out.println("Please Enter the price of Item");
        price = Integer.parseInt(scanner.nextLine());

        System.out.println("Please input 'exit' if You want to finish adding Items, or press 'Enter'");
        userCommand = scanner.nextLine().toUpperCase();
    }

    public static String getUserCommand() {
        return userCommand;
    }

    public static String getGroupName() {
        return groupName;
    }

    public static Group getParentGroup() {
        return parentGroup;
    }

    public static String getItemName() {
        return itemName;
    }

    public static int getPrice() {
        return price;
    }
}
