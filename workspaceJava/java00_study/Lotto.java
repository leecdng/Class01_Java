import java.util.*;


public class Lotto {


    void execute(){
        makeNumber(askGame());
        if(askMoreGame() == true) execute();
    }

    int askGame(){
        System.out.print("게임수=");
        Scanner intScan = new Scanner(System.in);
        return intScan.nextInt();
    }

    void makeNumber(int cnt){
        for(int game=0;game<cnt;game++){
            Set<Integer> set = new HashSet<>();
            while(set.size()<8){
                int ran = (int)((Math.random()*45)+1);
                set.add(ran);
            };
            result(set,game);
        }
    }

    void result(Set set,int game){
        Integer[] array = (Integer[]) set.toArray(new Integer[set.size()]);
        int bonus = array[array.length-1];
        set.remove(bonus);
        Integer[] array1 = (Integer[]) set.toArray(new Integer[set.size()]);
        Arrays.sort(array1);
        System.out.printf("%d게임="+Arrays.toString(array1)+" 보너스="+bonus+"\n",game+1);
    }

    boolean askMoreGame(){
        System.out.print("더하시겠습니까?(1.예 2.아니오)=");
        Scanner intScan = new Scanner(System.in);
        return intScan.nextInt()==1 ? true : false;
    }

    public static void main(String[] args) {
        Lotto lt = new Lotto();
        lt.execute();
    }
}