package ind.xwm.learn.javafx.stage;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author xuweiman
 */
public class DefaultStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("默认窗口类型 DECORATED");
        s1.initStyle(StageStyle.DECORATED);
        s1.show();

        Stage s2 = new Stage();
        s2.setTitle("透明窗口类型 DECORATED");
        s2.initStyle(StageStyle.TRANSPARENT);
        s2.show();
    }
}
