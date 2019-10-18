package ind.xwm.learn.javafx.component;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UseKeyCombination extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        primaryStage.show();

        Button btn = new Button("按钮事件");
        btn.setPrefSize(300, 120);
        btn.setLayoutX(200);
        btn.setLayoutY(120);
        group.getChildren().add(btn);

        btn.setOnAction(event -> {
            showNotification();
        });

        // 组合快捷键 方式1 -- 缺点: win10不起作用。
        KeyCombination kc = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
        scene.addMnemonic(new Mnemonic(btn, kc));

        // 组合快捷键 方式2, 并不具体作用在某个控件上
        KeyCombination kc2 = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);
        scene.getAccelerators().put(kc2, this::showNotification);

        // 控件的 fire方法， 会触发多个绑定在该控件的监听器
    }

    public void showNotification() {
        Text text = new Text("快捷键触发事件通知");
        text.setFont(Font.font(28));
        text.setFill(Paint.valueOf("#337ab7"));

        VBox vBox = new VBox();
        vBox.getChildren().add(text);
        vBox.setStyle("-fx-background:transparent;");
        Scene scene = new Scene(vBox,300, 50);
        scene.setFill(null);

        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(50);
        stage.setX(1400);
        stage.setY(800);
        stage.initModality(Modality.NONE);
        stage.show();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                Platform.runLater(stage::close);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
