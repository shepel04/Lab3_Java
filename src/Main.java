import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 10;
        int itemNumbers = 30;
        int producerCount = 3;
        int consumerCount = 5;
        main.starter(storageSize, itemNumbers, producerCount, consumerCount);
    }

    private void starter(int storageSize, int itemNumbers, int producerCount, int consumerCount) {
        Manager manager = new Manager(storageSize);
        int remainingItems = itemNumbers;
        //Random random = new Random();

        for (int i = 0; i < producerCount && remainingItems > 0; i++) {
            int producedItems = Math.min(storageSize, remainingItems);
            new Producer(producedItems, manager, i);
            remainingItems -= producedItems;
        }

        remainingItems = itemNumbers;

        for (int i = 0; i < consumerCount && remainingItems > 0; i++) {
            int consumedItems = Math.min(storageSize, remainingItems);
            new Consumer(consumedItems, manager, i);
            remainingItems -= consumedItems;
        }
    }
}
