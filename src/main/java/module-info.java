module org.example.csc311_hw3_groupbased {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.csc311_hw3_groupbased to javafx.fxml;
    exports org.example.csc311_hw3_groupbased;
}