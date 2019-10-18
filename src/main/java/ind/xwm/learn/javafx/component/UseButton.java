package ind.xwm.learn.javafx.component;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * 控件支持代码方式与css方式设置样式
 */
public class UseButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("这是一个骚气的按钮");
        btn.setPrefSize(300, 100);
        btn.setLayoutX(10);
        btn.setLayoutY(10);

        // 代码方式配置样式
/*        btn.setFont(Font.font(null, 20));
        btn.setTextFill(Paint.valueOf("#E3E3E3"));
        btn.setBackground(new Background(new BackgroundFill(
                Paint.valueOf("#4F94CD"),   // 颜色
                new CornerRadii(10, 10, 10, 10, false),  // 圆角
                new Insets(10, 10, 10, 10)))); // margin
        btn.setBorder(new Border(new BorderStroke(
                Paint.valueOf("#8B2323"),  // 颜色
                BorderStrokeStyle.SOLID,   // 样式： 实线、虚线、无 等
                new CornerRadii(5),    // 圆角
                new BorderWidths(1, 2, 2, 1), // 宽度
                new Insets(-5, -5, -5, -5))));  // margin*/

        // css方式配置样式
        btn.setStyle("-fx-font: bold 20 sans-serif;" +
                "-fx-text-fill: #E3E3E3;" +
                "-fx-background-color: #4F94CD;" +
                "-fx-background-radius: 10 10 10 10;" +
                "-fx-background-insets: 10 10 10 10;" +
                "-fx-border-color: #8B2323;" +
                "-fx-border-width: 2, 3, 3, 2;" +
                "-fx-border-insets: -5, -5, -5, -5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-style: solid;");


        btn.setOnAction(even -> {
            Button sBtn = (Button) even.getSource();
            System.out.println("点击出发事件，并在监听处理器中输出本文：" + sBtn.getText() + "\n\rstyle:" + sBtn.getStyle());
        });
        Group group = new Group();
        group.getChildren().add(btn);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(group));
        primaryStage.show();
    }
}
