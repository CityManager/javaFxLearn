package ind.xwm.learn.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author xuweiman
 * StageStyle.UTILITY 只有关闭按钮
 * StageStyle.UNIFIED 只有最大化和关闭按钮，不允许最小化
 * Modality.WINDOW_MODAL  模特框只会阻止其拥有者stage接收输入事件
 * Modality.APPLICATION_MODAL 模态框会组织应用中其他stage接收输入事件
 */
public class ModalStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("显示模态框");
        btn.setOnAction(event -> {
            Stage stage = new Stage();
            stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
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
