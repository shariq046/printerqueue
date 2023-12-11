public class PrinterQueue {
    private static final int MAX_QUEUE_SIZE = 100; // Maximum size of the printer queue
    private PrintTask[] queue;
    private int front, rear, size;

    public PrinterQueue() {
        this.queue = new PrintTask[MAX_QUEUE_SIZE];
        this.front = this.rear = this.size = 0;
    }

    public void enqueue(PrintTask task) {
        if (size == MAX_QUEUE_SIZE) {
            System.out.println("Queue is full. Cannot enqueue more tasks.");
            return;
        }

        queue[rear] = task;
        rear = (rear + 1) % MAX_QUEUE_SIZE;
        size++;
    }

    public PrintTask dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }

        PrintTask task = queue[front];
        front = (front + 1) % MAX_QUEUE_SIZE;
        size--;
        return task;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public PrintTask peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }

        return queue[front];
    }

    public void clear() {
        front = rear = size = 0;
    }

    public static void main(String[] args) {
        // Example usage
        PrinterQueue printerQueue = new PrinterQueue();

        PrintTask task1 = new PrintTask("Document1.pdf");
        PrintTask task2 = new PrintTask("Document2.doc");

        printerQueue.enqueue(task1);
        printerQueue.enqueue(task2);

        System.out.println("Peek: " + printerQueue.peek().getDocumentName());

        PrintTask dequeuedTask = printerQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedTask.getDocumentName());

        System.out.println("Is empty: " + printerQueue.isEmpty());

        printerQueue.clear();
        System.out.println("Is empty after clearing: " + printerQueue.isEmpty());
    }
}

class PrintTask {
    private String documentName;

    public PrintTask(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }
}
