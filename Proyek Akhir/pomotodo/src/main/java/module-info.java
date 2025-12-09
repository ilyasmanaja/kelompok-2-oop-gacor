module com.kelompok4.pomotodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.base;
    requires transitive javafx.graphics;

    opens com.kelompok4.pomotodo to javafx.fxml;
    
    exports com.kelompok4.pomotodo;
}
