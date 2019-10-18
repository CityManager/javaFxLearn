package ind.xwm.learn.javafx.component;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;


/**
 * 知识点1: Stage窗体必须设置Scene，在Scene下方可放置组件
 * 知识点2: Url资源获取方法
 * URL url = this.getClass().getClassLoader().getResource("icon.png");
 * String path = url.toExternalForm();
 *
 * 知识点3: 浏览器打开网页
 * HostServices hostServices = this.getHostServices();
 * hostServices.showDocument("https://www.baidu.com");
 */
public class UseScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = this.getClass().getClassLoader().getResource("icon.png");
        assert url != null;
        String path = url.toExternalForm();
        Button btn = new Button("打开百度");
        btn.setPrefSize(200, 100);
        btn.setCursor(Cursor.cursor(path));
        btn.setOnAction(actionEvent -> {
            HostServices hostServices = getHostServices();
            hostServices.showDocument("https://www.baidu.com");
        });

        Group group = new Group();
        group.getChildren().add(btn);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Learn JavaFx Scene");
        primaryStage.show();
    }
}
