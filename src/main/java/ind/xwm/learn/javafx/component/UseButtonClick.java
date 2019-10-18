package ind.xwm.learn.javafx.component;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UseButtonClick extends Application {

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

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
            String kName = event.getButton().name();
            System.out.println("鼠标按下键：" + kName);
            if (event.getClickCount() == 2 && kName.equals(MouseButton.PRIMARY.name())) {
                System.out.println("触发双击事件：" + kName);
            }
        });

        btn.setOnKeyPressed(event -> {
            String kName = event.getCode().name();
            System.out.println("键盘按下：" + kName);
            if(kName.equals(KeyCode.A.name())) {
                System.out.println("按键A按下对应动作");
            }
        });

        btn.setOnKeyReleased(event -> {
            String kName = event.getCode().name();
            System.out.println("键盘释放：" + kName);
            if(kName.equals(KeyCode.A.name())) {
                System.out.println("按键A释放对应动作");
            }
        });
    }
}
