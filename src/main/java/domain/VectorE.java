package domain;

public class VectorE<E> implements VectorList{
    private int n; //tamaño máximo del vector
    private E data []; //array de elementos tipo enteros
    private int counter; //cantidad de elementos agregados

    public VectorE(int n) {
        this.n = n;
        this.data = (E[]) (new Object[n]);
        this.counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.data = (E[]) (new Object[n]);
        this.counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return counter==0;
    }

    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < counter; i++) {
            if(util.Utility.compare(data[i],(E)element)==0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object element) {
        if(counter<n)
            this.data[counter++] = (E)element;
    }

    @Override
    public void add(int index, Object element) {
        if(index<counter)
            this.data[index] = (E)element;
    }

    @Override
    public boolean remove(Object element) {
        int i = -1;
        while(i++ < data.length-1){
            if(util.Utility.compare((E)element,data[i])==0){
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
        E removed = data[index];
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
                if(util.Utility.compare(data[j], data[j + 1])==-1){
                //if (data[j] > data[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    E temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < counter; i++) {
            if(util.Utility.compare(data[i],(E)element)==0){
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

    public E[] getData() {
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
            if(data[i]!=null){
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
