
import java.util.ArrayList;
import java.util.Scanner;
public class GuessGameMain{
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int count = 0;
    
       ArrayList<String> location = new ArrayList<String>();
       location.add("3");
       location.add("4");
       location.add("5");
       
        
        SimpleGuess guessing = new SimpleGuess();
        guessing.setLocation(location);
        boolean isAlive = true;
        while(isAlive){
            System.out.println("Enter a number: ");
            String guess =  scan.nextLine();
            String result =  guessing.checkingSelf(guess);
            count++;
            if (result == "kill"){
                 isAlive = false;
            }
        }
      System.out.println("The no.of guesses you took is: " + count);
        scan.close();

    }
    
}
class SimpleGuess{
   ArrayList<String> locationCells;
    int hit =0;
   
public String checkingSelf(String UserGuess){
   
    String result = "miss";
    int index = locationCells.indexOf(UserGuess);
    
        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
             } else{
                    result = "hit";
                }
            }

            System.out.println(result);

            return result;

        }
        


public void setLocation(ArrayList<String> location){
     this.locationCells = location;


}

}
