module com.example.internsavy_java_programming_project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.internsavy_java_programming_project2 to javafx.fxml;
    exports com.example.internsavy_java_programming_project2;
}