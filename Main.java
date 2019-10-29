package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;


public class Main extends Application {
	private FermiConnector base = new FermiConnector();
	
	@Override
	public void start(Stage Stage) {
		BorderPane root = new BorderPane();
		
		TableView<FermiEntry> dataTable = createTable();
		
		root.setCenter(dataTable);
		
		Scene scene = new Scene(root, 600, 400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage.setScene(scene);
		Stage.setTitle("Data Table");
		Stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unchecked")
	private TableView<FermiEntry> createTable() {
		
		TableView<FermiEntry> table = new TableView<>();
		table.setItems(FXCollections.observableArrayList(base.getData()));
		
		TableColumn<FermiEntry, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(50);
		nameCol.setCellValueFactory(new PropertyValueFactory<FermiEntry, String>("name"));
		
		TableColumn<FermiEntry, String> phoneCol = new TableColumn<>("Phone Number");
		phoneCol.setMinWidth(100);
		phoneCol.setCellValueFactory(new PropertyValueFactory<FermiEntry, String>("phone"));
		
		TableColumn<FermiEntry, Double> overCol = new TableColumn<>("Overtime Offered(hrs.)");
		overCol.setMinWidth(140);
		overCol.setCellValueFactory(new PropertyValueFactory<FermiEntry, Double>("overtime"));
		overCol.setSortType(TableColumn.SortType.DESCENDING);
		
		TableColumn<FermiEntry, Integer> senCol = new TableColumn<>("Intradep. Seniority");
		senCol.setMinWidth(120);
		senCol.setCellValueFactory(new PropertyValueFactory<FermiEntry, Integer>("seniority"));
		
		TableColumn<FermiEntry, Boolean> bisonCol = new TableColumn<>("In Bison Feeding Program");
		bisonCol.setMinWidth(170);
		bisonCol.setCellValueFactory(new PropertyValueFactory<FermiEntry, Boolean>("inBison"));
		
		table.getColumns().addAll(nameCol, phoneCol, overCol, senCol, bisonCol);
		return table;
	}
}