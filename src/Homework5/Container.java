package Homework5;

import java.util.Scanner;

public class Container {

    public static void main(String[] args) {
        System.out.println("Welcome to dynamic array application");
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers do you want to add?");
        int length = input.nextInt();
        Container container = new Container(length);

        while (true) {

            System.out.println("Please select a number : ");
            System.out.println("1) insert an item");
            System.out.println("2) Arrange the container");
            System.out.println("3) Reverse arrange the container");
            System.out.println("4) Remove an item by index");
            System.out.println("5) Remove by item");
            System.out.println("6) Search for an item");
            System.out.println("7) Print the elements of the container");
            System.out.println("9) Exit the application");


            int type = input.nextInt();
            switch (type) {
                case 1 -> {
                    System.out.println("=======================================================");
                    for (int i = 0; i < length; i++) {
                        System.out.println("Enter number");
                        int number = input.nextInt();
                        container.insert(number);
                    }
                    System.out.println("=======================================================");
                }

                case 2 -> {
                    System.out.println("=======================================================");
                    container.Arrange();
                    container.print();
                    System.out.println("=======================================================");
                }

                case 3 -> {
                    System.out.println("=======================================================");
                    container.reverseArrange();
                    container.print();
                    System.out.println("=======================================================");
                }

                case 4 -> {
                    System.out.println("========================================================");
                    System.out.println("Enter an index to remove the correspond element");
                    int index = input.nextInt();
                    container.removeByIndex(index);
                    System.out.println("=======================================================");
                }

                case 5 -> {
                    System.out.println("=======================================================");
                    System.out.println("Enter the number that you want to remove from container");
                    int number = input.nextInt();
                    container.removeByItem(number);
                    System.out.println("=======================================================");
                }

                case 6 -> {
                    System.out.println("=======================================================");
                    System.out.println("Enter a number to find its index in the container ");
                    int item = input.nextInt();
                    int index = container.indexOfItem(item);
                    System.out.println("The index = " + index);
                    System.out.println("=======================================================");
                }

                case 7 -> {
                    System.out.println("=======================================================");
                    container.print();
                    System.out.println("=======================================================");
                }

                case 8 -> {
                    System.out.println("=======================================================");
                    System.out.println("Exiting the application");
                    System.exit(0);
                    System.out.println("=======================================================");
                }

                default -> {
                    System.out.println("Incorrect input, Please Enter a correct Number");
                }
            }

        }
    }


    private int[] items;
    private int counter;

    public Container(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < counter; i++) {
            System.out.print(items[i] + " ");
            System.out.println();
        }
    }

    public void insert(int item) {
        if (counter == items.length) {
            int newLength = counter * 2;
            int[] newItems = new int[newLength];
            for (int i = 0; i < counter; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[counter++] = item;
    }

    public void removeByIndex(int index) {
        if (index >= 0 && index <= counter) {
            for (int i = index; i < counter - 1; i++) {
                items[i] = items[i + 1];
            }
            counter--;
        } else
            System.out.println("The index is out of range!");
    }

    public void removeByItem(int item) {
        int numberFrequency = sameNumbersCount(item);
        if(numberFrequency == 1){
            int index = indexOfItem(item);
            if (itemIsExist(item))
                removeByIndex(index);
        } else
            for (int i = 0; i <numberFrequency ; i++) {
                int index = indexOfItem(item);
                if (itemIsExist(item))
                    removeByIndex(index);
            }
    }

    public int indexOfItem(int item) {
        for (int i = 0; i < counter; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public boolean itemIsExist(int item) {
        for (int i = 0; i < counter; i++) {
            return (items[i] == item);
        }
        return false;
    }

    public int sameNumbersCount(int item){
        int sameNumbersCounter = 0;
        for (int i = 0; i <counter; i++) {
            if(items[i] == item)
                sameNumbersCounter++;
        }
        return sameNumbersCounter;
    }

    public int[] Arrange() {
        for (int i = 0; i < counter; i++) {
            for (int j = 1; j < counter; j++) {
                if (items[j] < items[j - 1])
                    swap(j, j - 1, items);
            }
        }
        return items;
    }

    public int[] reverseArrange() {
        for (int i = 0; i < counter; i++) {
            for (int j = 1; j < counter; j++) {
                if (items[j-1] < items[j])
                    swap(j, j - 1, items);
            }
        }
        return items;
    }


    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
