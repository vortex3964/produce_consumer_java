import java.util.ArrayList;

public class resource {
    private ArrayList<Integer> al;

    public resource(ArrayList<Integer> al) {
        this.al = al;
    }

    public resource() {
        this.al=new ArrayList<>();
    }


    public String getAl() {
        return al.toString();
    }

    public  synchronized void add(int elem)
    {
        Thread t=Thread.currentThread();

        try{
            Thread.sleep(1000);
            System.out.println("\n"+t+" added data:"+elem);

        }catch (InterruptedException e)
        {
            System.out.println(e);
        }
        //this.al.add(elem);

            this.al.add(elem);
            notify();

    }

    public synchronized int  remove() throws InterruptedException
    {
        Thread t=Thread.currentThread();

        if(al.isEmpty())
        {
            System.out.println("not yet");
            wait();//throws the exception
        }
        int elem=this.al.removeFirst();
        System.out.println(t+" removing data:"+elem);
        return elem;
    }
}
