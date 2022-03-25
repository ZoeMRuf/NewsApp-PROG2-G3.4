package at.ac.fhcampuswien;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private AppController controller = new AppController();//Instance of AppController

    //Attributes
    private static final String INVALID_INPUT_MESSAGE = "Your input was invalid. Pleas try again. READ THE F***ING MENU.";
    private static final String EXIT_MESSAGE = "Bye bye! AND DON'T FORGET TO SUBSCRIBE";

    //Methods
    public void start(){

        printMenu();
        Scanner s = new Scanner(System.in);
        String input;

        //first do-while loop so that the program only stops if "q" is entered
        do {
            //second do-while loop for input validation.
            do {
                input = s.nextLine().toLowerCase(); // no numbers because of .nextLine
                this.handleInput(input);
                if(!input.equals("q")){
                    printMenu();
                }
            }
            while(!input.equals("a") && !input.equals("b") && !input.equals("y") && !input.equals("q"));
        }while (!input.equals("q"));

    }

    private void handleInput(String input){

        switch (input){
            case "a":
                getTopHeadlinesAustria(controller);
                break;
            case "b":
                getAllNewsBitcoin(controller);
                break;
            case "y":
                getArticleCount(controller);
                break;
            case "q":
                printExitMessage();
                break;
            default:
                if (!input.equals("")){
                    printInvalidInputMessage();
                }
        }

    }

    private void getArticleCount(AppController ctrl){
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        System.out.println(ctrl.getTopHeadlinesAustria());
    }

    private void getAllNewsBitcoin(AppController ctrl){
        System.out.println(ctrl.getAllNewsBitcoin());
    }

    //this static Methods can only be used in this Class
    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage(){
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printMenu(){

        System.out.println("******************************");
        System.out.println("  *   Welcome to NewsApp   *  ");
        System.out.println("******************************");
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
        System.out.println();

    }

}
