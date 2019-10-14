package ind.xwm.learn.javafx.screen;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class UseScreen extends Application {

    public static void main(String[] args) {
        Screen screen = Screen.getPrimary();
        System.out.println("获取屏幕的dpi：" + screen.getDpi());
        System.out.println("获取屏幕的x轴方向缩放比例？：" + screen.getOutputScaleX());
        System.out.println("获取屏幕的y轴方向缩放比例？：" + screen.getOutputScaleY());
        Rectangle2D bounds = screen.getBounds();
        System.out.println("屏幕左上角座标： x=" + bounds.getMinX() + ", y=" + bounds.getMinY());
        System.out.println("屏幕后下角座标： x=" + bounds.getMaxX() + ", y=" + bounds.getMaxY());
        System.out.println("屏幕宽和高： 宽带=" + bounds.getWidth() + ", 高度=" + bounds.getHeight());

        Rectangle2D vBounds = screen.getVisualBounds();
        System.out.println("可视区域左上角座标： x=" + vBounds.getMinX() + ", y=" + vBounds.getMinY());
        System.out.println("可视区域后下角座标： x=" + vBounds.getMaxX() + ", y=" + vBounds.getMaxY());
        System.out.println("可视区域宽和高： 宽带=" + vBounds.getWidth() + ", 高度=" + vBounds.getHeight());

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.close();
        Platform.exit();
    }
}
