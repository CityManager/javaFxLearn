module ind.javafx {
    requires javafx.controls;
    exports ind.xwm.learn.javafx;
    opens ind.xwm.learn.javafx to javafx.graphics;
}