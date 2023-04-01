package domain;

public class Vector implements VectorList{
    private int n; //tamaño máximo del vector
    private int data []; //array de elementos tipo enteros
    private int counter; //cantidad de elementos agregados

    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        this.counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.data = new int[n];
        this.counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return counter==0;
    }

    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < counter; i++) {
            if(data[i]==(int)element){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object element) {
        if(counter<n)
            this.data[counter++] = (int)element;
    }

    @Override
    public void add(int index, Object element) {
        if(index<counter)
            this.data[index] = (int)element;
    }

    @Override
    public boolean remove(Object element) {
        int i = -1;
        while(i++ < data.length-1){
            if(element.equals(String.valueOf(data[i]))){
                int n = data.length-2;
                int j = i-1;
                while(j++ < n) {
                    data[j] = data[j+1];
                }
                this.counter--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        int n = data.length-2;
        int i = index;
        int removed = data[index];
        data[i] = data[i+1];
        while(i++ < n) {
            data[i] = data[i+1];
        }
        this.counter--;
        return removed;
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    void bubbleSort() {
        int n = this.data.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (data[j] > data[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < counter; i++) {
            if(data[i]==(int)element){
                return i;
            }
        }
        return 0;
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    public int getN() {
        return n;
    }

    public int[] getData() {
        return data;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        String result = "\nVector content...\n";
        int aux=0; //para cambio de linea
        for (int i = 0; i < counter; i++) {
            if(data[i]!=0){
                if(aux++>=20){
                    result+="\n";
                    aux=0;
                }
                result+=data[i]+" ";
            }
        }
        return result;
    }
}
