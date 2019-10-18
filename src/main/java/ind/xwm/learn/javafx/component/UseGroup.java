package ind.xwm.learn.javafx.component;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * group.setAutoSizeChildren(false); //默认true，自动没有设置宽度和高度的控件设置；false，则所有没有设置宽高的控件均为0,0
 * group.setOpacity(0.5) ;  // 父组件设置透明度，则所有子组件会跟随透明度
 * group.contains(0,0);  // 检测坐标点是否存在控件，注意：只检测控件的左上角位点
 */
public class UseGroup extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[] index = new int[]{0};
        Button btn = new Button("Group Btn" + index[0]);
        Group group = new Group();
        group.setOpacity(0.5);
        group.getChildren().add(btn);
        int btnWidth = 200;
        int btnHeight = 100;
        int startX = 10;
        int startY = 10;
        btn.setPrefSize(btnWidth, btnHeight);
        btn.setLayoutX(startX);
        btn.setLayoutY(startY);
        btn.setOnAction(actionEvent -> {
            index[0] = index[0] + 1;
            Button tBtn = new Button("Group Btn" + index[0]);
            tBtn.setPrefWidth(btnWidth);
            tBtn.setPrefHeight(btnHeight);
            tBtn.setLayoutX(startX + btnWidth * index[0]);
            tBtn.setLayoutY(startY + btnHeight * index[0]);

            group.getChildren().add(tBtn);
        });

        System.out.println(group.isAutoSizeChildren());
        System.out.println("btn左上角匹配：" + group.contains(10, 10));
        System.out.println("btn左上角不匹配：" + group.contains(10, 11));
        group.setAutoSizeChildren(true);
        group.getChildren().addListener((ListChangeListener<Node>) change -> {
            while(change.next()) { // 一定要先执行
                if(change.wasPermutated()) {
                    System.out.println("重新排列");
                } else if(change.wasUpdated()) {
                    System.out.println("组件更新");
                } else if(change.wasAdded()) {
                    System.out.println("增加组件");

                } else if(change.wasReplaced()) {
                    System.out.println("替换组件，替换组件是wasAdded， wasRemoved均返回true");
                } else if(change.wasRemoved()) {
                    System.out.println("删除组件");
                }
                System.out.println(change.getAddedSize());
                System.out.println(change.getFrom());
            }

        });

        Scene scene = new Scene(group);
        scene.setFill(null);

        primaryStage.setOpacity(0.5);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
