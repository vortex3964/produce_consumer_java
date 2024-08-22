public class main {
    public static void main(String[] args)
    {

        Thread t=Thread.currentThread();
        t.setName("the parent");
        resource sl=new resource();

        Thread[] producers=new Thread[2];
        for (int i = 0; i <2 ; i++) {
            producers[i]=new Thread(new producer(i*10,sl));
            producers[i].start();
        }

        System.out.println("the consumers came");

        Thread[] consumers=new Thread[3];
        for (int i = 0; i <=2 ; i++) {
            consumers[i]=new Thread(new consumer(i,sl));
            consumers[i].start();
        }

        try {
            for (Thread producer : producers)  producer.join();
            System.out.println("k");
            for (int i = 0; i <consumers.length ; i++) {
                consumers[i].interrupt();
            }

        }catch (InterruptedException e)
        {
            System.out.println(e);
        }

        System.out.println("threads are hard");

    }
}
