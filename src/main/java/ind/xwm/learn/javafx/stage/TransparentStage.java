package ind.xwm.learn.javafx.stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author xuweiman
 * 透明窗口使用场景： 提示语
 * 缺点： 任务栏仍旧会有多一个窗口
 * 优点： 可以设计一个窗口没有顶部系统自带拖动栏
 */
public class TransparentStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("显示透明stage");
        btn.setOnAction(event -> {
            Text text = new Text("透明stage显示提示语");
            text.setFont(new Font(20));
            text.setFill(Color.GREEN);

            VBox vBox = new VBox();
            // 布局背景设置为透明
            vBox.setStyle("-fx-background:transparent;");
            vBox.getChildren().add(text);

            Scene scene = new Scene(vBox, 300, 200);
            // 场景 设置为透明
            scene.setFill(null);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT); // 窗口类型设置为透明
            stage.show();
            System.out.println("setOnAction:" + Thread.currentThread().getName());

            new Thread(new Task<Object>() {
                @Override
                protected Object call() throws Exception {
                    System.out.println("task:" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    // 无效果，非JavaFX Application Thread 无法操作UI组件？
//                    stage.hide();
//                    stage.close();
                    // 必须使用平台方式, 返回JavaFX Application Thread 线程执行
                    // Platform 向JavaFX Application Thread 线程的队列推送UI更新指令（runnable）
                    Platform.runLater(() -> {
                        System.out.println("Platform:" + Thread.currentThread().getName());
                        stage.close();
                    });
                    return null;
                }
            }).start();
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btn);

        Scene scene = new Scene(stackPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
