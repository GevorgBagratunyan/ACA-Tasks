package threads;

import java.util.List;

public class Consumer implements Runnable {

    private boolean stop;
    private Resource resource;

    public Consumer(Resource resource) {
        stop = false;
        this.resource = resource;
    }

    @Override
    public void run() {
        while (!stop) {
            resource.consumeQuote();
        }
    }

    public void stop() {
        stop = true;
    }
}
