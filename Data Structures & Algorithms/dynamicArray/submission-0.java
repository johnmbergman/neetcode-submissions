class DynamicArray {

    int[] data;
    int size = 0;

    public DynamicArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        if (size == data.length) resize();
        data[size++] = n;
    }

    public int popback() {
        return data[--size];
    }

    private void resize() {
        final int oldCapacity = data.length;
        final int newCapacity = oldCapacity * 2;
        final int[] newData = new int[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }
}
