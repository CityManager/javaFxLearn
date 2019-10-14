package ind.xwm.learn.javafx.stage;

import javafx.application.Application;
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
 * 缺点： 任务栏仍旧会有多一个窗口
 * 优点： 可以设计一个窗口没有顶部系统自带拖动栏
 */
public class UndecoratedStage extends Application {
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

            Scene scene = new Scene(vBox, 300, 100);
            // 场景 设置为透明
            scene.setFill(null);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED); // 窗口类型设置为无windows自带顶部栏
            stage.show();
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btn);

        Scene scene = new Scene(stackPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
