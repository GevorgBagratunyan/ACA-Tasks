package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resource {
    private final List<String> quote = new ArrayList<>();
    private boolean isFinished = false;

    public synchronized void produceQuote(String[] arr) {
        if (isFinished) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        quote.clear();
        Collections.addAll(quote, arr);
        isFinished = true;
        notify();
    }

    public synchronized void consumeQuote() {
        if (!isFinished) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (String s : quote) {
            System.out.print(s);
        }
        System.out.println();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isFinished = false;
        notify();
    }
}
