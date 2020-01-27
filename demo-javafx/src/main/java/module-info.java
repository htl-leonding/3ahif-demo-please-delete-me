module at.htl.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.derby.client;
    requires org.apache.derby.commons;
    requires org.apache.derby.tools;

    opens at.htl.demo to javafx.fxml;
    exports at.htl.demo;


}