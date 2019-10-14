package ind.xwm.learn.javafx.platform;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author xuweiman
 * Platform.runLater 被非JavaFX Application Thread 调用，便于向JavaFX Application Thread 的队列推送UI更新指令
 * Platform.setImplicitExit(false); 作用是 关闭所有窗口后，程序仍保持运行状态
 * 使用场景： 将程序最小化为任务栏小图标？
 */
public class UsePlatForm extends Application {
    private static final String SUBMIT = "确认";
    private static final String CANCEL = "取消";
    private static boolean isSubmit = false;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button(SUBMIT);
        btn.setOnAction((event -> {
            isSubmit = !isSubmit;
            Button sourceBtn = (Button) event.getSource();
            sourceBtn.setText(isSubmit ? CANCEL : SUBMIT);
        }));

        Text text = new Text();
        text.setFont(new Font(30));
        text.setFill(Color.BLUE);


        VBox vBox = new VBox();
        vBox.getChildren().add(btn);
        vBox.getChildren().add(text);
        Scene scene = new Scene(vBox, 800, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        counter++;
                        Platform.runLater(() -> text.setText("计数：" + counter));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        Platform.setImplicitExit(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
