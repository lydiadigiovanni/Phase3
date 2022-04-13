package TrueFalse;

import java.util.Random;

public class GenerateQuestions {
    public static void main(String[] args){
        String[] s = generateQuestion();
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        System.out.println(s[3]);
        //generateQuestion(); //run the main thing we tryna run
        
    }
    // There are “ “ *anchors, swords, compasses, coconuts* 
    public static String[] generateQuestion() { //generate the question
        String[] nameOfItems ={"anchors", "compasses", "coconuts"}; //array of what are supposed to be the images
        Random random = new Random();
        String nameOfItem = nameOfItems[random.nextInt(3)];
        int item = random.nextInt(10) + 1; //call generateRandomItems to generate a random num of items aka images
        int randomNumber = random.nextInt(10) + 1; //the random number generated in the question below
        String[] question1 = new String[4]; //question1 array
        question1[0] = "There are " + randomNumber + " " + nameOfItem; //actual question itself
        question1[1] = checkAnswer(randomNumber, item); //calls trueOrFalse to randomly generate whether its gonna be T/F
        question1[2] = Integer.toString(item); //number of random items
        question1[3] = nameOfItem;
        return question1; //return statement bc there will be error w/0 it
      
    }


    public static String checkAnswer(int number, int item) { //hasnt been used yet but checks the answer
        //boolean answer;
        if (number == item) {  //depending on if the number is equal to the number of items
            return "true";  
        }
        else {
            return "false";
        }
    

    }

    

}



