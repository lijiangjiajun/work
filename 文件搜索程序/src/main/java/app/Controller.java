//package app;
//
//import dao.FileOperatorDAO;
//import task.DBInit;
//import task.FileOperateTask;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.ObservableList;
//import javafx.event.Event;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
////package app;
//
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.DirectoryChooser;
//import javafx.stage.Window;
//import task.FileScanCallback;
//import task.FileScanTask;
//import util.DBUtil;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class Controller implements Initializable {
//
//    @FXML
//    private GridPane rootPane;
//    private Thread t;
//    @FXML
//    private TextField searchField;
//
////    @FXML
//    @FXML
//    private TableView<FileMeta> fileTable;
//
//    @FXML
//    private Label srcDirectory;
//
//    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            DBInit.init();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 添加搜索框监听器，内容改变时执行监听事件
//        searchField.textProperty().addListener(new ChangeListener<String>() {
//
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                freshTable();
//            }
//        });
//    }
//
//    public void choose(Event event) {
//        // 选择文件目录
//        DirectoryChooser directoryChooser=new DirectoryChooser();
//        Window window = rootPane.getScene().getWindow();
//        File file = directoryChooser.showDialog(window);
//        if(file == null)
//            return;
//        // 获取选择的目录路径，并显示
//        String path = file.getPath();
//        srcDirectory.setText(path);
//        if(t!=null) {
//            t.interrupt();
//        }
//        t= new Thread(new Runnable() {
//                @Override
//                public void run() {
//                        FileScanCallback callback = new FileOperateTask();
//                        FileScanTask task = new FileScanTask(callback);
//                        task.startScan(file);//多线程运行扫描任务
////                    //wait()   等待task结束
//                        task.waitFinish();
//                    System.out.println("执行完毕");
////                    synchronized (task){
////                        try {
////                            task.wait();
////                            System.out.println("等待线程结束");
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                    }
//                    freshTable();
//                }
//        });
//        t.start();
//
//    }
//
//    // 刷新表格数据
//    private void freshTable(){
//        ObservableList<FileMeta> metas = fileTable.getItems();
//        metas.clear();
//        List<FileMeta> datas = FileOperatorDAO.search(srcDirectory.getText(),searchField.getText());
//
//
//        metas.addAll(datas);
//    }
//}

package app;

import dao.FileOperatorDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import task.DBInit;
import task.FileOperateTask;
import task.FileScanCallback;
import task.FileScanTask;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;

    private Thread t;

    public void initialize(URL location, ResourceBundle resources) {
        DBInit.init();
        // 添加搜索框监听器，内容改变时执行监听事件
        searchField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                freshTable();
            }
        });
    }

    public void choose(Event event) {
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);
        if(file == null)
            return;
        // 获取选择的目录路径，并显示
        String path = file.getPath();
        srcDirectory.setText(path);
        if(t != null){// TODO 线程执行完毕，t是否为空
            t.interrupt();
        }
        t = new Thread(new Runnable() {
            @Override
            public void run() {

                    FileScanCallback callback = new FileOperateTask();
                    FileScanTask task = new FileScanTask(callback);
                    task.startScan(file);//多线程运行文件扫描任务
                    // 等待task结束
                try {
                    task.waitFinish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完毕, src="+srcDirectory.getText());
                    freshTable();

            }
        });
        t.start();

    }

    // 刷新表格数据
    private void freshTable(){
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
        List<FileMeta> datas = FileOperatorDAO.search(srcDirectory.getText(),
                searchField.getText());
        metas.addAll(datas);
    }
}