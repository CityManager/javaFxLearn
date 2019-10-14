package ind.xwm.learn.javafx;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author xuweiman
 */
public class L1HelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        stage.setWidth(1000);
        stage.setHeight(600);

//        stage.setMinWidth(500);
//        stage.setMinHeight(300);
//        stage.setMaxWidth(1500);
//        stage.setMaxHeight(900);
        // 设置可调整大小
//        stage.setResizable(false);
        stage.getIcons().add(new Image("icon.png"));

        // 设置为最小化
//        stage.setIconified(true);
        // 设置为最大化
//        stage.setMaximized(true);

        // 参数监听
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue + "-" + newValue);
        });
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue + "-" + newValue);
        });

        // 透明度
        stage.setOpacity(0.8);
        stage.setAlwaysOnTop(true);

        stage.show();

        // 设置全屏，需要重新渲染才能起作用？
//        stage.setFullScreen(true);
//        stage.setScene(new Scene(new Group()));
//        stage.hide();
//        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
