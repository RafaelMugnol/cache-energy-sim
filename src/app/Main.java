package app;

import controllers.MainController;

public class Main {

    public static void main(String[] args) {

        if(args.length == 0){
            new MainController();
        }
        else if (args[0].equals("--cmd")) {
            //
        } 
        // -- help
    }

}
