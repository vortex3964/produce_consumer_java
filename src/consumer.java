public class consumer implements Runnable{
    private resource res;
    int id;

    public consumer( int id,resource res) {
        this.res = res;
        this.id = id;
    }


    @Override
    public void run() {
        Thread t=Thread.currentThread();
        t.setName("consumer "+id);

        try
        {
            while (true)
            {
                this.res.remove();
            }
        }catch (InterruptedException e)
        {
            System.out.println(t+" got interupted");
        }
        System.out.println(t+" finished!");
    }
}
