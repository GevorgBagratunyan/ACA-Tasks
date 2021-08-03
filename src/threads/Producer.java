package threads;

public class Producer implements Runnable{

    private boolean stop;
    private String[] quote;
    private Resource resource;

    public Producer(String[] quote, Resource resource) {
        stop = false;
        this.quote = quote;
        this.resource = resource;
    }

    @Override
    public void run() {
        while(!stop) {
            resource.produceQuote(quote);
        }
    }

    public void stop(){
        stop = true;
    }
}
