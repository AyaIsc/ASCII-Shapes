package g58414.atlg3.ascii.AsciiApplication;

import g58414.atlg3.ascii.controller.Application;
import g58414.atlg3.ascii.model.AsciiPaint;
import g58414.atlg3.ascii.view.AsciiView;

public class Main {
    public static void main(String[] args) { // mettre dans une classe g58414.atlg3.ascii.AsciiApplication
        AsciiPaint paint = new AsciiPaint();
        AsciiView view = new AsciiView();
        Application app = new Application( view , paint  );

        app.start();
    }
}
