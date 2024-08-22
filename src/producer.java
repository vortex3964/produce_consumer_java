public class producer  implements Runnable
{
    private int init;
    private  resource res;

    public producer(int init, resource res) {
        this.init = init;
        this.res = res;
    }


    @Override
    public void run() {
        Thread t=Thread.currentThread();
        t.setName("producer "+init);
        for (int i = init; i <init+4 ; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                System.out.println(e);
            }
            this.res.add(i);
        }
        System.out.println(t+" finished");
    }



}
