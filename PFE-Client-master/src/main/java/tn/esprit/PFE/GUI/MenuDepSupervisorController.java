package tn.esprit.PFE.GUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Notification;
import javax.management.NotificationBroadcaster;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.controlsfx.control.Notifications;

import entities.Category;
import entities.Employee;
import entities.PFE_Form;
import iservice.CategoryFacadeRemote;
import iservice.EmployeeFacadeRemote;
import iservice.PFE_FormFacadeRemote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Cell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuDepSupervisorController {
	@FXML
	AnchorPane MenuDepSupervisorPane;

	//Categories

	@FXML
	AnchorPane imgPane;
	@FXML
	AnchorPane CategoryPane;
	@FXML
	TableView<Category> tableCategory;
	@FXML
	TableColumn<Category,String> col_nameCategory;
	@FXML
	JFXButton btn_acceptCategory;
	@FXML
	JFXButton btn_refuseCategroy;

	//internship:OUSSAMA:Without notes

	@FXML
	AnchorPane IntershipFormUpdatePane;
	@FXML
	AnchorPane updateToSavePane;
	@FXML
	AnchorPane IntershipFormPane1;
	@FXML
	TableView<PFE_Form> tableInternshipForm1;
	@FXML
	TableColumn<PFE_Form,String> problematic;
	@FXML
	TableColumn<PFE_Form,String> Responsable_Lname;
	@FXML
	TableColumn<PFE_Form,String> Responsable_mail;
	@FXML
	TableColumn<PFE_Form,String> createdon;
	@FXML
	TableColumn<PFE_Form,String> defensedate;
	@FXML
	TableColumn<PFE_Form,String> modifiedon;
	@FXML
	TableColumn<PFE_Form,String> title;
	@FXML
	JFXTextField Sup_mark;
	@FXML
	JFXTextField rep_mark;
	@FXML
	JFXTextField category;
	@FXML
	JFXComboBox<String> sup_nom;
	@FXML
	JFXComboBox<String>rep_nom;
	@FXML
	JFXTextField Rep_mail;
	@FXML
	JFXTextField Sup_mail;
	@FXML
	JFXButton btn_sup;
	@FXML
	JFXButton btn_rep;
	@FXML
	JFXTextField secret;

	//Internship Sup+Rep no assign :SIRINE
	@FXML
	JFXButton btn_sms_r;
	@FXML
	JFXButton btn_sms_s;
	@FXML
	AnchorPane IntershipFormPane;
	@FXML
	AnchorPane paneAssignReporter;
	@FXML
	TableView<PFE_Form> tableInternshipForm;
	@FXML
	TableColumn <PFE_Form,String>Responsable_Lname_s;
	@FXML
	TableColumn <PFE_Form,String> Responsable_mail_s;
	@FXML
	TableColumn <PFE_Form,String>createdon_s;
	@FXML
	TableColumn <PFE_Form,String>defensedate_s;
	@FXML
	TableColumn <PFE_Form,Date> modifiedon_s;
	@FXML
	TableColumn <PFE_Form,String> problematic_s;
	@FXML
	TableColumn <PFE_Form,String> title_s;
	@FXML
	TableView<PFE_Form> tableInternshipForm12;
	@FXML
	TableColumn <PFE_Form,String>Responsable_Lname1;
	@FXML
	TableColumn <PFE_Form,String> Responsable_mail1;
	@FXML
	TableColumn <PFE_Form,String>createdon1;
	@FXML
	TableColumn <PFE_Form,String>defensedate1;
	@FXML
	TableColumn <PFE_Form,Date> modifiedon1;
	@FXML
	TableColumn <PFE_Form,String> problematic1;
	@FXML
	TableColumn <PFE_Form,String> title1;
	@FXML
	TableView<PFE_Form> tableInternshipForm11;
	@FXML
	TableColumn <PFE_Form,String>Responsable_Lname11;
	@FXML
	TableColumn <PFE_Form,String> Responsable_mail11;
	@FXML
	TableColumn <PFE_Form,String>createdon11;
	@FXML
	TableColumn <PFE_Form,String>defensedate11;
	@FXML
	TableColumn <PFE_Form,Date> modifiedon11;
	@FXML
	TableColumn <PFE_Form,String> problematic11;
	@FXML
	TableColumn <PFE_Form,String> title11;
	@FXML
	AnchorPane Paneall;
	@FXML
	Button btn_showallForm;
	@FXML
	AnchorPane paneNoReporter;
	@FXML
	AnchorPane paneNoSupervisor;
	@FXML
	JFXButton btn_save_reporter;
	@FXML
	JFXButton btn_save_supervisor;
	@FXML
	AnchorPane paneAssignSupervisor;
	@FXML
	JFXComboBox<String> combo_emp;
	@FXML
	JFXTextField category_s;
	@FXML
	JFXTextField mail;
	@FXML
	JFXTextField role;
	@FXML
	JFXTextField secret_s;
	@FXML
	JFXTextField secret_emp;
	@FXML
	JFXComboBox<String> combo_emp1;
	@FXML
	JFXTextField category1;
	@FXML
	JFXTextField mail1;
	@FXML
	JFXTextField role1;
	@FXML
	JFXTextField secret1;
	@FXML
	JFXTextField secret_emp1;


	//Statistic Affichage

	@FXML
	AnchorPane statiistic_pane;
	@FXML
	BarChart<String, Long> barChart;
	@FXML
	CategoryAxis categoryAxis;
	@FXML
	NumberAxis numberAxis;
	@FXML
	JFXButton btn_del;

	//Piechart



	@FXML
	AnchorPane piechartpane;
	@FXML
	PieChart piechart;
	@FXML
	TableView<PFE_Form> table_inacc_acc_pfe;
	@FXML
	TableColumn<PFE_Form, String>title_in_a;
	@FXML
	TableColumn<PFE_Form, String>desc_i_a;
	@FXML
	TableColumn<PFE_Form, String> prob_i_a;
	@FXML
	TableColumn<PFE_Form, String>cat_i_a;


	//CategorieActions
	@FXML
	void handleAcceptCategroyAction(ActionEvent evt)
	{
		//System.out.println(tableCategory.getSelectionModel().getSelectedItems().get(0));
		String name_category=tableCategory.getSelectionModel().getSelectedItems().get(0).getCategory_name();
		String jndiName="PFE-ear/PFE-ejb/CategoryFacade!iservice.CategoryFacadeRemote";
		Context context;
		try {
			context = new InitialContext();
			CategoryFacadeRemote proxy =(CategoryFacadeRemote) context.lookup(jndiName);
			Category c=proxy.findByName(name_category);

			if(c!=null){
				System.out.println(c);
				if(c.isCategory_available()==false){
					proxy.accept_category_proposed(c.getCategory_id());
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Category information");
					alert.setHeaderText(null);
					alert.setContentText("Category saved ,Thanks!");
					alert.show();
					handleShowCategoryAction(null);

				}
				else{
					tableCategory.setVisible(false);
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Category information");
					alert.setHeaderText(null);
					alert.setContentText("Category is already saved!");
					alert.show();
				}		}
			else{
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Category information");
				alert.setHeaderText(null);
				alert.setContentText("Select first!");
				alert.show();
			}}
		catch (NamingException e) {
			e.printStackTrace();}
	}


	@FXML
	void handleRefuseCategoryAction(ActionEvent evt)
	{		System.out.println(tableCategory.getSelectionModel().getSelectedItems().get(0));
	String name_category=tableCategory.getSelectionModel().getSelectedItems().get(0).getCategory_name();
	String jndiName="PFE-ear/PFE-ejb/CategoryFacade!iservice.CategoryFacadeRemote";
	Context context;
	try {
		context = new InitialContext();
		CategoryFacadeRemote proxy =(CategoryFacadeRemote) context.lookup(jndiName);
		Category c=proxy.findByName(name_category);
		System.out.println(c);
		System.out.println(c.getCategory_id());
		proxy.refuse_category_proposed(c.getCategory_id());
		tableCategory.refresh();
		handleShowCategoryAction(null);
	}
	catch (NamingException e) {
		e.printStackTrace();}
	}

	@FXML
	void handleShowCategoryAction(ActionEvent evt)
	{

		CategoryPane.setVisible(true);
		btn_acceptCategory.setVisible(true);
		btn_refuseCategroy.setVisible(true);
		IntershipFormUpdatePane.setVisible(false);
		IntershipFormPane.setVisible(false);
		statiistic_pane.setVisible(false);
		piechartpane.setVisible(false);


		try{

			String jndiName="PFE-ear/PFE-ejb/CategoryFacade!iservice.CategoryFacadeRemote";
			Context context=new InitialContext();
			CategoryFacadeRemote proxy =(CategoryFacadeRemote) context.lookup(jndiName);

			List<Category> list ;
			ObservableList<Category> list1 = FXCollections.observableArrayList();
			list=proxy.listCategorie();
			System.out.println(list.size());
			if(list.size()!=0){

				System.out.println("hahahahahaa");
				list1.addAll(list);
				for(int i=0;i<list.size();i++)
					System.out.println(list.get(i).getCategory_name());

				//category_name.setText(list.get(i));
				col_nameCategory.setCellValueFactory(new PropertyValueFactory<Category,String>("category_name"));
				tableCategory.setItems(list1);}
			else{
				CategoryPane.setVisible(false);
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Category information");
				alert.setHeaderText(null);
				alert.setContentText("Sorry, There isn't new category to show !");
				alert.show();

				//page_categories.setVisible(false);

			}
		} catch (NamingException e) {
			e.printStackTrace();
		}}


	//Internship whithout Marks:OUSSAMA


	@FXML
	void handleShowInternshipFormsNoNoteAction(ActionEvent evt) throws NamingException{
		statiistic_pane.setVisible(false);
		IntershipFormPane.setVisible(false);
		IntershipFormUpdatePane.setVisible(true);
		IntershipFormPane1.setVisible(true);
		CategoryPane.setVisible(false);
		updateToSavePane.setVisible(false);
		piechartpane.setVisible(false);
		// derive(-fx-secondary, 20%);
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		List<PFE_Form> list ;
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();

		list=proxy.Form_pfe_without_note();
		System.out.println(list.size());
		if(list.size()!=0){
			System.out.println(list);
			list2.addAll(list);
			for(int i=0;i<list.size();i++){
				Responsable_Lname.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleFirstName"));
				Responsable_mail.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleEmail"));
				createdon.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("createdOn"));
				defensedate.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("defenseDate"));
				modifiedon.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("modifiedOn"));
				problematic.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));
				title.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));
				tableInternshipForm1.setItems(list2);
			}}
		else{	
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();
			//page_categories.setVisible(false);
		}
	}

	@FXML
	void handleShowDetailsAction(MouseEvent evt) throws NamingException{
		System.out.println(tableInternshipForm1.getSelectionModel().getSelectedItems().get(0));
		PFE_Form f=tableInternshipForm1.getSelectionModel().getSelectedItems().get(0);

		IntershipFormPane1.setVisible(false);
		secret.setText(Long.toString(f.getForm_id()));
		updateToSavePane.setVisible(true);
		category.setText(f.getCategory().getCategory_name());

		if((f.getReporter()!=null)&&(f.getNote_reporter()!=null)){
			System.out.println("rep existe");
			rep_nom.setPromptText(f.getReporter().getFirstName()+"  "+f.getReporter().getLastName());
			rep_nom.setDisable(true);
			rep_mark.setText(f.getNote_reporter().toString());
			Rep_mail.setText(f.getReporter().getEmail());
		}
		else {
			rep_nom.setDisable(false);
			String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
			Context context=new InitialContext();
			PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
			category.setText(f.getCategory().getCategory_name());
			//secret.setText(Long.toString(pfe.getForm_id()));
			List<Employee> l=proxy.Employe_de_category(f);
			System.out.println(l);
			for(int i=0;i<l.size();i++){
				rep_nom.getItems().addAll(l.get(i).getLastName());
			}}
		if((f.getSupervisor()!=null)&&(f.getNote_supervisor()!=null)){
			System.out.println("sup existe");
			sup_nom.setPromptText(f.getReporter().getLastName());
			sup_nom.setDisable(true);
			Sup_mark.setText(f.getNote_supervisor().toString());
			Sup_mail.setText(f.getSupervisor().getEmail());
		}
		else{
			System.out.println("sup absent");
			sup_nom.setDisable(false);
			String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
			Context context=new InitialContext();
			PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
			category.setText(f.getCategory().getCategory_name());
			//secret.setText(Long.toString(pfe.getForm_id()));
			List<Employee> l=proxy.Employe_de_category(f);
			System.out.println(l);
			for(int i=0;i<l.size();i++){
				System.out.println(l.get(i));
				sup_nom.getItems().addAll(l.get(i).getLastName());
			}}
	}

	@FXML
	void handlechoisirSupervisorAction(ActionEvent evt) throws NamingException{
		String LName=sup_nom.getValue();
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		Employee e=proxy.returnEmpByName(LName);
		Sup_mail.setText(e.getEmail());
		btn_sup.setDisable(false);
	}

	@FXML
	void handlechoisirReporterAction(ActionEvent evt) throws NamingException{
		String LName=rep_nom.getValue();
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		Employee e=proxy.returnEmpByName(LName);
		Rep_mail.setText(e.getEmail());
		btn_rep.setDisable(false);
	}

	@FXML
	void handleSaveSupAction(ActionEvent evt) throws NamingException{
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		long id_form=Long.parseLong(secret.getText());
		PFE_Form f=proxy.find(id_form);
		String LName=sup_nom.getValue();
		Employee e=proxy.returnEmpByName(LName);
		long id_emp=e.getEmployee_id();
		proxy.Assign_emp_sup_Form(id_form, id_emp);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("PFE Form Information");
		alert.setHeaderText(null);
		alert.setContentText("Supervisor saved for this Intership form, Thank you !");
		alert.show();
	}

	@FXML
	void handleSaveRepAction(ActionEvent evt) throws NamingException{
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		long id_form=Long.parseLong(secret.getText());
		String LName=rep_nom.getValue();
		Employee e=proxy.returnEmpByName(LName);
		long id_emp=e.getEmployee_id();
		proxy.Assign_emp_Form(id_form, id_emp);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("PFE Form Information");
		alert.setHeaderText(null);
		alert.setContentText("Reporter saved for this Intership form, Thank you !");
		alert.show();
	}

	@FXML
	void handlego_back_intershipAction(ActionEvent evt) throws NamingException{
		IntershipFormPane1.setVisible(true);
		updateToSavePane.setVisible(false);
	}

	//Internship Action Sirine


	@FXML
	void handleShowInternshipFormsAction(ActionEvent evt) throws NamingException{
		paneNoReporter.setVisible(false);
		IntershipFormPane.setVisible(true);
		CategoryPane.setVisible(false);
		IntershipFormUpdatePane.setVisible(false);
		IntershipFormPane1.setVisible(false);
		updateToSavePane.setVisible(false);
		paneAssignReporter.setVisible(false);
		paneAssignSupervisor.setVisible(false);
		paneNoSupervisor.setVisible(false);
		statiistic_pane.setVisible(false);
		piechartpane.setVisible(false);


		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		List<PFE_Form> list ;
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();

		list=proxy.FindAll_PfeForm();
		System.out.println(list.size());
		if(list.size()!=0){
			Paneall.setVisible(true);
			System.out.println(list);
			list2.addAll(list);
			for(int i=0;i<list.size();i++){
				Responsable_Lname_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleFirstName"));
				Responsable_mail_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleEmail"));
				createdon_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("createdOn"));
				defensedate_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("defenseDate"));
				modifiedon_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,Date>("modifiedOn"));
				problematic_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));
				title_s.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));

				tableInternshipForm.setItems(list2);
			}					
		}
		else{	
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();
			//page_categories.setVisible(false);
		}
	}
	@FXML
	void handleShowFormsNoReporterAction(ActionEvent evt) throws NamingException{

		Paneall.setVisible(false);
		paneNoSupervisor.setVisible(false);
		paneAssignSupervisor.setVisible(false);
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		List<PFE_Form> list ;
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();
		list=proxy.Form_without_reporter();
		if(list.size()!=0){
			paneNoReporter.setVisible(true);

			System.out.println(list);
			list2.addAll(list);
			for(int i=0;i<list.size();i++){
				Responsable_Lname1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleFirstName"));
				Responsable_mail1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleEmail"));
				createdon1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("createdOn"));
				defensedate1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("defenseDate"));
				modifiedon1.setCellValueFactory(new PropertyValueFactory<PFE_Form,Date>("modifiedOn"));
				problematic1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));
				title1.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));

				tableInternshipForm12.setItems(list2);
			}}
		else{	
			paneAssignReporter.setVisible(false);

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();

		}
	}
	@FXML
	void handleShowFormsNoSupervisorAction(ActionEvent evt) throws NamingException{
		Paneall.setVisible(false);
		paneNoReporter.setVisible(false);
		paneAssignReporter.setVisible(false);

		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		List<PFE_Form> list ;
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();
		list=proxy.Form_without_supervisor();
		if(list.size()!=0){
			paneNoSupervisor.setVisible(true);
			System.out.println(list);
			list2.addAll(list);
			for(int i=0;i<list.size();i++){
				Responsable_Lname11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleFirstName"));
				Responsable_mail11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("responsibleEmail"));
				createdon11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("createdOn"));
				defensedate11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("defenseDate"));
				modifiedon11.setCellValueFactory(new PropertyValueFactory<PFE_Form,Date>("modifiedOn"));
				problematic11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));
				title11.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));
				tableInternshipForm11.setItems(list2);
			}
		}else{	
			paneAssignSupervisor.setVisible(false);
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();}
	}
	@FXML
	void handleAssignReporterAction() throws NamingException{
		PFE_Form pfe=tableInternshipForm12.getSelectionModel().getSelectedItems().get(0);
		if(pfe==null){
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("PFE Form Information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry,First you must select an intership form  !");
			alert.show();
		}
		else{
			paneAssignReporter.setVisible(true);
			String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
			Context context=new InitialContext();
			PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
			category_s.setText(pfe.getCategory().getCategory_name());
			secret_s.setText(Long.toString(pfe.getForm_id()));
			List<Employee> l=proxy.Employe_de_category(pfe);
			//System.out.println(l);
			for(int i=0;i<l.size();i++){
				combo_emp.getItems().addAll(l.get(i).getLastName());
			}
		}


	}
	@FXML
	void handleSaveReporterAction(ActionEvent evt) throws NamingException{
		long id_form=Long.parseLong(secret_s.getText());
		long id_emp=Long.parseLong(secret_emp.getText());
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		proxy.Assign_emp_Form(id_form, id_emp);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("PFE Form Information");
		alert.setHeaderText(null);
		alert.setContentText("Reporter saved for this Intership form, Thank you !");
		alert.show();

	}
	@FXML
	void handleAssignSupervisorAction(ActionEvent evt) throws NamingException{
		PFE_Form pfe=tableInternshipForm11.getSelectionModel().getSelectedItems().get(0);
		if(pfe==null){
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("PFE Form Information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry,First you must select an intership form  !");
			alert.show();
		}
		else{
			paneAssignSupervisor.setVisible(true);
			String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
			Context context=new InitialContext();
			PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
			category1.setText(pfe.getCategory().getCategory_name());
			secret1.setText(Long.toString(pfe.getForm_id()));
			List<Employee> l=proxy.Employe_de_category(pfe);
			System.out.println(l);
			for(int i=0;i<l.size();i++){
				combo_emp1.getItems().addAll(l.get(i).getLastName());
			}
		}
	}
	@FXML
	void handleSaveSupervisorAction(ActionEvent evt) throws NamingException{
		long id_form=Long.parseLong(secret1.getText());
		long id_emp=Long.parseLong(secret_emp1.getText());
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		proxy.Assign_emp_sup_Form(id_form, id_emp);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("PFE Form Information");
		alert.setHeaderText(null);
		alert.setContentText("Supervisor saved for this Intership form, Thank you !");
		alert.show();
	}
	@FXML
	void handleselectEmployeAction(ActionEvent evt) throws NamingException{
		String LName=combo_emp.getValue();
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		Employee e=proxy.returnEmpByName(LName);
		role.setText(e.getRole().toString());
		mail.setText(e.getEmail());
		secret_emp.setText(Long.toString(e.getEmployee_id()));
		btn_save_reporter.setDisable(false);
		btn_sms_r.setDisable(false);

	}
	@FXML
	void handleselectEmploye1Action(ActionEvent evt) throws NamingException{
		String LName=combo_emp1.getValue();
		String jndiName="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		Context context=new InitialContext();
		PFE_FormFacadeRemote proxy=(PFE_FormFacadeRemote) context.lookup(jndiName);
		Employee e=proxy.returnEmpByName(LName);
		role1.setText(e.getRole().toString());
		mail1.setText(e.getEmail());
		secret_emp1.setText(Long.toString(e.getEmployee_id()));
		btn_save_supervisor.setDisable(false);
		btn_sms_s.setDisable(false);
	}

	///Affichage des statistic:BARRES


	@FXML
	void handleaffichergrapheAction(ActionEvent evt) throws NamingException{

		statiistic_pane.setVisible(true);
		paneNoReporter.setVisible(false);
		IntershipFormPane.setVisible(false);
		CategoryPane.setVisible(false);
		IntershipFormUpdatePane.setVisible(false);
		IntershipFormPane1.setVisible(false);
		updateToSavePane.setVisible(false);
		paneAssignReporter.setVisible(false);
		paneAssignSupervisor.setVisible(false);
		paneNoSupervisor.setVisible(false);
		piechartpane.setVisible(false);



		barChart.setTitle("Employee");
		numberAxis.setLabel("Supervision number");
		categoryAxis.setLabel("Employee name");
		XYChart.Series<String, Long> series1 = new XYChart.Series<>();

		Context context=new InitialContext();
		String jndiName1="PFE-ear/PFE-ejb/EmployeeFacade!iservice.EmployeeFacadeRemote";
		EmployeeFacadeRemote proxy1=(EmployeeFacadeRemote) context.lookup(jndiName1);
		List<Employee> list=proxy1.orderby_supervisions();
		System.out.println(list);
		List<String> l=new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			l.add(list.get(i).getFirstName());}
		System.out.println("les employees "+l);
		ObservableList<String>l1=FXCollections.observableArrayList();
		l1.addAll(l);
		categoryAxis.setCategories(l1);
		List<Long> list_nb=new ArrayList<>();

		for(int i=0;i<list.size();i++){
			long nb=proxy1.nbre_supervisions(list.get(i).getEmployee_id());
			list_nb.add(nb);
		}
		for(int i=0;i<list.size();i++){
			series1.getData().add(new XYChart.Data<>(l.get(i),list_nb.get(i)));


		}

		barChart.getData().add(series1);
		Notifications notification = Notifications.create()
				.title("Welcome!")
				.text("Welcome ,the statistic of the day are available !")
				.graphic(null)
				.hideAfter(Duration.seconds(30))
				.position(Pos.BASELINE_CENTER);


		notification.darkStyle();
		notification.show();

	}
	///Piechartttttt
	@FXML
	void handleafficherpieAction(ActionEvent evt) throws NamingException{
		piechartpane.setVisible(true);
		statiistic_pane.setVisible(false);
		paneNoReporter.setVisible(false);
		IntershipFormPane.setVisible(false);
		CategoryPane.setVisible(false);
		IntershipFormUpdatePane.setVisible(false);
		IntershipFormPane1.setVisible(false);
		updateToSavePane.setVisible(false);
		paneAssignReporter.setVisible(false);
		paneAssignSupervisor.setVisible(false);
		paneNoSupervisor.setVisible(false);

		Context context=new InitialContext();
		String jndiName2="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		PFE_FormFacadeRemote proxy2=(PFE_FormFacadeRemote) context.lookup(jndiName2);
		long nb_inv=proxy2.nb_Form_pfe_accepted();
		System.out.println(nb_inv);
		long nb_v=proxy2.nb_Form_pfe_non_accepted();
		if(nb_inv!=0||nb_v!=0){


			long p_inv=nb_inv*100/(nb_inv+nb_v);
			long p_v=nb_v*100/(nb_inv+nb_v);
			System.out.println("v= "+p_v+"iv="+p_inv);
			piechart.setTitle("PFE Form");
			ObservableList<PieChart.Data> piechartData=FXCollections.observableArrayList(new PieChart.Data("Inaccepted PFE Form", p_inv),
					new PieChart.Data("Accepted PFE Form",p_v )
					);
			piechart.setData(piechartData);

		}
		else{

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle(" Information");
			alert.setHeaderText(null);
			alert.setContentText("No Data To Show");
			alert.show();

		}}

	@FXML
	void handleAutreaffAction(MouseEvent evt){
		paneAssignReporter.setVisible(false);
	}

	@FXML
	void handleAutreaff2Action(MouseEvent evt){
		paneAssignSupervisor.setVisible(false);

	}
	@FXML
	void handleSendSmsReporterAction(ActionEvent evt) throws NamingException{
		long id_form=Long.parseLong(secret_s.getText());
		Context context=new InitialContext();
		String jndiName2="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		PFE_FormFacadeRemote proxy2=(PFE_FormFacadeRemote) context.lookup(jndiName2);
		String t=proxy2.find(id_form).getTitle();
		Twilio.init( "AC577b83652e652cfc84e0b5501c6a2be4","c87f5a1c6aa382b34d8b7f194b05847d");
		System.out.println("oussama");
		Message message = Message
				.creator(new PhoneNumber("+21629072808"), 
						new PhoneNumber("+12015155237"), 
						"You are assigned as a reporter for the pfe internship title :" +t)
				.create();

		System.out.println(message.getSid());
	}
	@FXML
	void handleSendSmsSupervisorAction(ActionEvent evt) throws NamingException{
		long id_form=Long.parseLong(secret_s.getText());
		Context context=new InitialContext();
		String jndiName2="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		PFE_FormFacadeRemote proxy2=(PFE_FormFacadeRemote) context.lookup(jndiName2);
		String t=proxy2.find(id_form).getTitle();
		Twilio.init( "AC577b83652e652cfc84e0b5501c6a2be4","c87f5a1c6aa382b34d8b7f194b05847d");
		System.out.println("oussama");
		Message message = Message
				.creator(new PhoneNumber("+21629072808"), 
						new PhoneNumber("+12015155237"), 
						"You are assigned as a suprvisor for the pfe internship title :" +t)
				.create();

		System.out.println(message.getSid());
	}

	@FXML
	void handleimgAction(ActionEvent evt) {
		//imgPane.setVisible(true);
	}


	@FXML
	void handleShowpfeInacceptedAction(ActionEvent evt) throws NamingException {
		table_inacc_acc_pfe.refresh();
		Context context=new InitialContext();
		String jndiName2="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		PFE_FormFacadeRemote proxy2=(PFE_FormFacadeRemote) context.lookup(jndiName2);
		List<PFE_Form> l=proxy2.Form_pfe_non_accepted();
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();
		if(l.size()!=0){
			table_inacc_acc_pfe.setVisible(true);
			list2.addAll(l);
			for(int i=0;i<l.size();i++){
				title_in_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));
				desc_i_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("description"));
				prob_i_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));

				table_inacc_acc_pfe.setItems(list2);
			}}
		else{	
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();}
	}


	@FXML
	void handleShowpfeAcceptedAction(ActionEvent evt) throws NamingException {
		table_inacc_acc_pfe.refresh();

		Context context=new InitialContext();
		String jndiName2="PFE-ear/PFE-ejb/PFE_FormFacade!iservice.PFE_FormFacadeRemote";
		PFE_FormFacadeRemote proxy2=(PFE_FormFacadeRemote) context.lookup(jndiName2);
		List<PFE_Form> l=proxy2.Form_pfe_accepted();
		ObservableList<PFE_Form> list2 = FXCollections.observableArrayList();
		if(l.size()!=0){
			table_inacc_acc_pfe.setVisible(true);
			list2.addAll(l);
			for(int i=0;i<l.size();i++){
				title_in_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("title"));
				desc_i_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("description"));
				prob_i_a.setCellValueFactory(new PropertyValueFactory<PFE_Form,String>("problematic"));

				table_inacc_acc_pfe.setItems(list2);
			}}
		else{	
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Internship Form information");
			alert.setHeaderText(null);
			alert.setContentText("Sorry, There isn't Internship Form to show !");
			alert.show();}


	}
}
