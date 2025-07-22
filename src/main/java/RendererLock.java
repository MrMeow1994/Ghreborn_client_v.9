import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class RendererLock {
    public static final boolean MULTI = false;
    private static Object lock = new Object();
    static boolean active = false;
    static ExecutorService software_pool = null;
    static AtomicInteger post_cntr = new AtomicInteger(0);
    static AtomicInteger pre_cntr = new AtomicInteger(0);
    static boolean finished = false;
    static boolean started = false;

    static void completed() {
        int num = post_cntr.incrementAndGet();
        if(started && !finished && num == pre_cntr.get()) {
            Object var1 = lock;
            synchronized(lock) {
                finished = true;
                lock.notify();
            }
        }

    }

    public static void prepare() {
        pre_cntr.set(0);
        post_cntr.set(0);
        started = false;
        finished = false;
    }

    public static synchronized void startSoftware() {
        started = true;
    }

    public static void endSoftware() {
        if(active) {
            Object var0 = lock;
            synchronized(lock) {
                if(!finished && (!started || pre_cntr.get() != post_cntr.get())) {
                    try {
                        lock.wait(500L);
                    } catch (InterruptedException var2) {
                        var2.printStackTrace();
                    }
                }
            }
        }

    }

    public static void kill() {
        if(software_pool != null) {
            software_pool.shutdownNow();
            software_pool = null;
            System.gc();
        }

    }

    public static void init() {
    }

    public static void submit(Runnable runnable) {
        pre_cntr.incrementAndGet();
        software_pool.submit(runnable);
    }
}

