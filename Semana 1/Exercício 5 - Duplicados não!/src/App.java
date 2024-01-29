import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String[] array1 = {"Morango", "Banana", "Maçã", "Uva", "Caqui"};
        String[] array2 = {"Manga", "Caqui", "Morango", "Amora"};
        List<String> equalsList = new ArrayList<>();

        for (int i=0; i<array1.length; i++){
            for (int j=0; j<array2.length; j++){
                if(array1[i] == array2[j]){
                    if (!equalsList.contains(array1[j])){
                        equalsList.add(array2[j]);
                    } 
                }
            }
        }
        System.out.print("\n");
        for (int i=0; i<equalsList.size(); i++){
            System.out.println(equalsList.get(i));
        } 
        System.out.print("\n");
    }
}
