public class HomeWorkThread {
    public HomeWorkThread() throws InterruptedException {
        Run run = new Run();
        Thread1 thread1 = new Thread1(run);
        Thread2 thread2 = new Thread2(run, "5");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        HomeWorkThread homeWorkThread = new HomeWorkThread();
    }

    class Thread1 extends Thread {
        private Run counter;

        public Thread1(Run counter) {
            this.counter = counter;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.counter.add();
            }
        }
    }

    class Thread2 extends Thread {
        private Run app;
        private String message;

        public Thread2(Run app, String message) {
            this.app = app;
            this.message = message;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                int second;
                try {
                    second = app.last();
                    System.out.println(second);
                    if (second % 5 == 0)
                        System.out.println(message + " seconds have passed");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class Run {
        private int d = 0;

        public synchronized void add() {
            this.d++;
            notify();
        }

        public synchronized int last() throws InterruptedException {
            wait();
            return this.d;
        }
    }
}








