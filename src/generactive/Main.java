package generactive;

import generactive.util.Storage;
import generactive.util.ItemCreator;

public class Main {
    public static void main(String[] args) {
        ItemCreator.create();
        Storage.printAllGroups();
    }
}
