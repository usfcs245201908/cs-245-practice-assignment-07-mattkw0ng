public class ArrayList<T> implements List<T>{
    private T[] a = (T[]) new Object[10];
    private int size = 0;

    public void add(T item){
        if(size == a.length){
            grow_array();
        }else{
            a[size++]=item;
        }
    }

    public void add(int pos, T item){
        /*
        if(pos>size||pos<0){
            throw new Exception();
        */

        if(size == a.length){
            grow_array();
        }
        if(size==0&&pos==0){
            a[0] = item;
            size++;
        }else{
            for(int i = size ; i>=pos ; i--){
                a[i] = a[i-1];
            }
            a[pos] = item;
            size++;
        }

    }

    public T get(int pos){
        /*
        if(pos<0||pos>=size){
            throw new Exception();
        }
        */
        return a[pos];
    }

    public T remove(int pos) {
        /*
        if(pos<0||pos>=size){
            throw new Exception();
        */
        if(pos==size-1){
            size--;
            return a[pos];
        }else{
            T deleted = a[pos];
            for(int i = pos ; i<size-1; i++){
                a[i] = a[i+1];
            }
            size--;
            return deleted;
        }


    }

    public int size(){
        return size;
    }

    private void grow_array(){
        int len = a.length;
        T[] new_a = (T[]) new Object[len*2];
        for(int i = 0 ; i<len ; i++){
            new_a[i] = a[i];
        }
        a = new_a;
    }
}