package Stacks_Queues;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }

    @Override
    public void push(int item){
        if (isFull()){
//            double the array size
            int[] temp = new int[data.length*2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }


        super.push(item);
    }

}
