package q2_arrayList;

public class ArrayList {
    private int[] space;
    private int size;

    public ArrayList() {
        this.space = new int[4];
        this.size = 0;        //last_index == size - 1
    }

    //向数组内添加元素 value
    public void add(int value) {
        if (size < space.length) {
        }
        else if (size == space.length) {
            space = extend(space);
        }
        space[size] = value;
        size ++;
    }

    //返回索引是 index 的元素
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return space[index];
    }

    //返回当前集合大小
    public int size() {
        return size;
    }

    //删除数组的最后一个元素
    public void pop() {
        if (size == 0){
            return;
        }
//        int value = space[size - 1];
        remove(size - 1);
//        return value;
    }

    //在 index 位置上插入元素 value
    public void insert(int index, int value) {
        if (index > size) {
            return;
        }

        if (size == space.length) {
            space = extend(space);
        }

        for (int i = size - 1; i >= index; i--) {
            space[i + 1] = space[i];
        }

        space[index] = value;
        size ++;
    }

    //删除在 index 位置上的元素
    public void remove(int index) {
        if (index >= size) {
            return;
        }

        if (index  < size - 1) {
            for (int i = index; i < size - 1; i++) {
                space[i] = space[i + 1];
            }
        }
        size --;

        if (size <= space.length / 4 && space.length >= 8) {
            space = contract(space);
        }
    }

    private int[] contract(int[] space) {
        int[] arr = new int[space.length / 4];
        System.arraycopy(space, 0, arr, 0, size);
//        System.out.println("contract");
        return arr;
    }

    private int[] extend(int[] space) {
        int[] arr = new int[space.length * 2];
        System.arraycopy(space, 0, arr, 0, size);
//        System.out.println("extend");
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(space[i]);
            }
            else {
                sb.append(space[i]).append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
