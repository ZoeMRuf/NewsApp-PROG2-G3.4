package at.ac.fhcampuswien;

import downloader.ParallelDownloader;
import downloader.SequentialDownloader;

import java.util.Scanner;

public class Menu {
    private AppController controller; //Instance of AppController

    //Attributes
    private static final String INVALID_INPUT_MESSAGE = "Your input was invalid. Pleas try again. READ THE F***ING MENU.";
    private static final String EXIT_MESSAGE = "Bye bye! AND DON'T FORGET TO SUBSCRIBE";

    //Methods
    public void start() {

        controller = AppController.getInstanceAppController();

        printMenu();
        Scanner s = new Scanner(System.in);
        String input;

        //first do-while loop so that the program only stops if "q" is entered
        do {
            //second do-while loop for input validation.
            do {
                input = s.nextLine().toLowerCase(); // no numbers because of .nextLine
                this.handleInput(input);
                if(!input.equals("q") && !input.equals("")){
                    printMenu();
                }
            }
            while(!input.equals("a") && !input.equals("b") && !input.equals("y") && !input.equals("q") && !input.equals("h"));
        }while (!input.equals("q"));
    }

    private void handleInput(String input){

        switch (input){
            case "a":
                getTopHeadlinesAustria(controller);
                System.out.println();
                break;
            case "b":
                getAllNewsBitcoin(controller);
                System.out.println();
                break;
            case "y":
                getArticleCount(controller);
                System.out.println();
                break;
            case "q":
                printExitMessage();
                System.out.println();
                break;
            case "h":
                downloadURLs(controller);
                System.out.println();
                break;
            default:
                if (!input.equals("")){
                    printInvalidInputMessage();
                    System.out.println();
                }
        }

    }

    private void getArticleCount(AppController ctrl){
        System.out.println("Number of articles: " + ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        ctrl.getTopHeadlinesAustria().forEach(System.out::println);
    }

    private void getAllNewsBitcoin(AppController ctrl){
        ctrl.getAllNewsBitcoin().forEach(System.out::println);
    }

    private void downloadURLs(AppController ctrl){
        try {
            int resultSequential = ctrl.downloadURLs(new SequentialDownloader());
            // TODO print time in ms it took to download URLs sequentially

            // TODO implement the process() function in ParallelDownloader class
            //int resultParallel = ctrl.downloadURLs(new ParallelDownloader());

            // TODO print time in ms it took to download URLs parallel

        } catch (NewAPIException e){
            System.out.println(e.getMessage());
        }
    }

    //this static Methods can only be used in this Class
    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage(){
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printMenu() {

        System.out.println("******************************");
        System.out.println("  *   Welcome to NewsApp   *  ");
        System.out.println("******************************");
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("h: Download URLs");
        System.out.println("q: Quit program");
        System.out.println();

    }

}
