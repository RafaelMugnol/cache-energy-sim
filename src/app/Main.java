package app;

import controllers.CmdController;
import controllers.MainController;

public class Main {

    public static void main(String[] args) {

        if(args.length == 0){
            new MainController();
        }
        else if (args[0].equals("--cmd")) {
            new CmdController(args);
        } 
        else if (args[0].equals("--help")) {
            System.out.println("Help:\n\n"
                    + "--cmd  -> Command mode\n"
                    + "--help  -> Help\n"
                    + "--config=...  -> File configuration memory\n"
                    + "--stats=...  -> File stats memory\n"
                    + "--out=...  -> Name of the final file\n\n"
                    + "Order:\n"
                    + "    1º -> Parameters L1 data\n"
                    + "    2º -> Parameters L1 instructions\n"
                    + "    2º -> Parameters L2\n");
        } 
    }

}
