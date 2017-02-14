import com.epam.task3.controller.Controller;
import com.epam.task3.view.View;

public class Main {
    public static void main(String [] args) {
        View view = View.getInstance();
        Controller controller = Controller.getInstance();
        controller.start();
        System.out.println(view.request("addnews" + " \"" + "Book" + "\" \"" + "Lord of the ring" + "\" \"" + "One Ring To Rule Them ALL\""));
        System.out.println(view.request("addnews" + " \"" + "film" + "\" \"" + "Jaws" + "\" \"" + "Shark, very big Shark.\""));
        System.out.println(view.request("addnews" + " \"" + "Disc" + "\" \"" + "Diablo II" + "\" \"" + "Immortal Classic\""));
        System.out.println(view.request("addnews" + " \"" + "film" + "\" \"" + "film" + "\" \"" + "film\""));
        System.out.println(view.request("Category \"film\""));
        System.out.println(view.request("Name \"film\""));
        System.out.println(view.request("Title \"film\""));
        controller.finish();
    }

}
