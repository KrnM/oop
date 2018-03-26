class binarysearch {
    public static void main(String[] args) {
        int data[] = { 3, 6, 7, 10, 34, 56, 60 };
        int numberToFind = 10;
        // PUT YOUR CODE HERE

        int low = 0;
        int high = data.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;

            if (data[middle] == numberToFind)
            {
                System.out.println(middle);
                return;
            }
            else if (data[middle] < numberToFind)
            {
                low = middle + 1;
            }
            else if (data[middle] > numberToFind)
            {
                high = middle - 1;
            }
        }
        System.out.println(-1);
        return;

    }
}