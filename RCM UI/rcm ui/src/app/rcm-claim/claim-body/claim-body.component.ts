import { Component, ViewChild, ElementRef, Renderer2, ViewContainerRef, TemplateRef, SimpleChanges, AfterViewInit } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { DiagnosisModalComponent } from '../_modal/diagnosis-modal/diagnosis-modal.component';
import { DiagnosisRemarkModalComponent } from '../_modal/diagnosis-remark-modal/diagnosis-remark-modal.component';
import { CsiGridColumn, CsiGridOptions } from '../../../../csi-web-base/csi-grid/csi-grid.model';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { ClaimBodyService } from './claim-body.service';
import { FormGroup, FormControl } from '@angular/forms';
import { GridComponent } from '@progress/kendo-angular-grid';

@Component({
  selector: 'rcm-claim-body',
  templateUrl: './claim-body.component.html',
  styleUrls: ['./claim-body.component.scss'],
  providers: [ClaimBodyService]
})

@ComponentRegistry({
  componentId: "327717ff-6db6-45aa-a937-35f9c707012c"
})

export class ClaimBodyComponent extends CsiBaseComponent {

  loading = true;
  albumLoading = true;
  dataSet: any = [];
  dataSet2: any = [];
  dataSet3: any = [];
  
  selectedItems: any[] = []
  selectedItems2: any[] = []
  selectedItems3: any[] = []
  albumsDataList: any = [];
  cptCodeList: any = [];
  bsModalRef: BsModalRef;
  observationRemarks: string = "";
  userRemarks: string = "";
  appointments: any[];
  totalNumberOfInvoices = 0.00;
  public gridOptions: CsiGridOptions;
  public gridOptions2: CsiGridOptions;
  private gridOptionArray={};
  public gridOptions3: CsiGridOptions;
  // initialize colomns
  public columns: CsiGridColumn[] = [];
  public columns2: CsiGridColumn[] = [];
  public columns3: CsiGridColumn[] = [];

  @ViewChild('thumbnailTemplate') private thumbnailTemplateTpl: TemplateRef<any>;
  @ViewChild('albumCellTemplate') private albumCellTemplateTpl: TemplateRef<any>;
  @ViewChild('albumCellEditTemplate') private albumCellEditTemplateTpl: TemplateRef<any>;
  @ViewChild('layer1Template') private layer1TemplateTpl: TemplateRef<any>;
  @ViewChild('layer2Template') private layer2TemplateTpl: TemplateRef<any>;
  @ViewChild('cellDisplayTemplate') private cellDisplayTemplate: TemplateRef<any>;
  @ViewChild('cellEditTemplate1') private cellEditTemplate1: TemplateRef<any>;
  @ViewChild('cellEditTemplate2') private cellEditTemplate2: TemplateRef<any>;
  @ViewChild('cellEditTemplate3') private cellEditTemplate3: TemplateRef<any>;
  @ViewChild('cellEditTemplate4') private cellEditTemplate4: TemplateRef<any>;
  @ViewChild('cellEditTemplate5') private cellEditTemplate5: TemplateRef<any>;
  @ViewChild('cellEditTemplate6') private cellEditTemplate6: TemplateRef<any>;
  @ViewChild('cellEditTemplate7') private cellEditTemplate7: TemplateRef<any>;
  @ViewChild('cellEditTemplate8') private cellEditTemplate8: TemplateRef<any>;
  @ViewChild('cellHideTemplate') private cellHideTemplate: TemplateRef<any>;
  @ViewChild('cellBoldTemplate1') private cellBoldTemplate1: TemplateRef<any>;
  @ViewChild('cellBoldTemplate2') private cellBoldTemplate2: TemplateRef<any>;
  @ViewChild('cellLinkTemplate1') private cellLinkTemplate1: TemplateRef<any>;
  @ViewChild('cellLinkTemplate2') private cellLinkTemplate2: TemplateRef<any>;
  @ViewChild('observationRemarksModal') private observationRemarksModal: TemplateRef<any>;
  @ViewChild('emptyTemplate') private emptyTemplate: TemplateRef<any>;

  constructor(private modalService: BsModalService, private claimBodyService: ClaimBodyService, private rd: Renderer2) {
    super();
  }

  // On row edit
  UpdateFormGroup = dataItem => new FormGroup({
    'albumId': new FormControl(dataItem.albumId)
  })

  // On row update emit function
  updateRow(updatedRowData) {
    console.log("Row update emit works!", updatedRowData);
  }


  // Get posts
  GetPosts() {
    this.claimBodyService.GetPosts().subscribe(posts => {
      //debugger;
      this.dataSet = posts;

this.dataSet[0].appointment[0].SortablejsModule

      this.loading = false;
    });

    
  }



  public setAppointments(appointments: any[]) {
    this.appointments = appointments;
    for (var appointment of this.appointments) {
      for (var invoice of appointment.invoices) {
        for (var activity of invoice.encounterActivities) {
          activity['invoice'] = invoice;
        }
        invoice['appointment'] = appointment;
      }
    }
    this.renderGridView();
  }

  // Get all albums
  GetAlbums() {
    this.claimBodyService.GetAlbums().subscribe(albums => {
      this.albumsDataList = albums;
      this.albumLoading = false;
    });
  }

  Album(id) {
    return this.albumsDataList.find(alb => alb.id == id);
  }

  isToggled: boolean = false;
  toggleGrid() {
    this.isToggled = !this.isToggled;
  }

  ngOnInit() {

   // console.log(this.dataSet);
    // define grid options
    this.gridOptions = {
      sortable: true,
      pageable: true,
      pageSize: 30,
      scrollable: true,
      filterable: true,
      groupable: true,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows:this.selectedItems,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },
      /*rowDisabled: (dataItem => {
        return dataItem.id == 3;
      }),*/
      rowDetailsTemplate: this.layer1TemplateTpl
    };

    this.gridOptions2 = {
      sortable: false,
      pageable: false,
      pageSize: 20,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems2,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },
      rowDetailsTemplate: this.layer2TemplateTpl
    };

    this.gridOptions3 = {
      sortable: false,
      pageable: false,
      pageSize: 50,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems3,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      }
    };


  }

  renderGridView() {
    //var jsonString = '[{"id":"101","appointmentNo":"APP001","grossAmount":1200,"netAmount":1000,"discount":1800,"companyShare":8000,"patientShare":2000,"quantity":1,"invoices":[{"id":"201","invoiceNo":"INC001","grossAmount":200,"netAmount":300,"discount":900,"companyShare":800,"patientShare":200,"quantity":1,"encounterActivities":[{"id":"301","activityCode":"CPT-10.1","orderDate":"2018-01-17 15:35:12","performedStatus":"Not-Performed","servicePerformedDate":"2018-01-17 15:35:12","grossAmount":120,"netAmount":100,"discount":700,"companyShare":400,"patientShare":150,"quantity":1,"discountPercentage":150,"companySharePercentage":10,"patientSharePercentage":10.00,"orderingClinician":"EN10029","approvalCode":"PA-100","observationRemarks":"observation remark example1","userRemarks":"user remarks example1"},{"id":"302","activityCode":"CPT-10.1","orderDate":"2018-01-17 15:35:12","performedStatus":"Not-Performed","servicePerformedDate":"2018-01-17 15:35:12","grossAmount":120,"netAmount":100,"discount":10,"companyShare":8000,"patientShare":2000,"quantity":1,"discountPercentage":150,"companySharePercentage":10,"patientSharePercentage":10.00,"orderingClinician":"EN10029","approvalCode":"PA-100","observationRemarks":"observation remark example2","userRemarks":"user remarks example2"}]},{"id":"202","invoiceNo":"INC002","grossAmount":120,"netAmount":100,"discount":10,"patientShare":2000,"companyShare":80000,"quantity":1,"encounterActivities":[{"id":"303","activityCode":"CPT-10.1","orderDate":"2018-01-17 15:35:12","performedStatus":"Not-Performed","servicePerformedDate":"2018-01-17 15:35:12","grossAmount":120,"netAmount":100,"discount":10,"companyShare":8000,"patientShare":2000,"quantity":1,"discountPercentage":150,"companySharePercentage":10,"patientSharePercentage":10.00,"orderingClinician":"EN10029","approvalCode":"PA-100","observationRemarks":"observation remark example3","userRemarks":"user remarks example3"},{"id":"304","activityCode":"CPT-10.1","orderDate":"2018-01-17 15:35:12","performedStatus":"Not-Performed","servicePerformedDate":"2018-01-17 15:35:12","grossAmount":120,"netAmount":100,"discount":10,"companyShare":8000,"patientShare":2000,"quantity":1,"discountPercentage":150,"companySharePercentage":10,"patientSharePercentage":10.00,"orderingClinician":"EN10029","approvalCode":"PA-100","observationRemarks":"observation remark example4","userRemarks":"user remarks example4"}]}]}]';
    //this.appointments = JSON.parse(jsonString);
    let csiGridColumnTitle: string;
    let initialColumns: CsiGridColumn[] = [{ field: "appointmentNo", title: "App No", width: 80 },
    { field: "invoiceNo", title: "Invoice No", width: 80 }];
    for (var initialColumn of initialColumns) {
      this.columns.push(initialColumn);

      let col = JSON.parse(JSON.stringify(initialColumn));
      col.width = null;

      let col2 = JSON.parse(JSON.stringify(initialColumn));
      col2.width = 65;
      this.columns2.push(col2);
      this.columns3.push(col);
    }
    for (var objectFieldNames of Object.keys(this.appointments[0].invoices[0].encounterActivities[0])) {
      csiGridColumnTitle = "";
      /*for (var splittedValue of objectFieldNames.split("_")) {
        csiGridColumnTitle += splittedValue.replace(splittedValue.charAt(0), splittedValue.charAt(0).toUpperCase()) + " ";
      }*/
      /*for (var splittedValue of objectFieldNames.split("\\p{Lu}")) {
        console.log("vlall :::" + splittedValue);
        csiGridColumnTitle += " " + splittedValue.replace(splittedValue.charAt(0), splittedValue.charAt(0).toUpperCase());
      }*/
      //alert(csiGridColumnTitle);

      var columnObject = { field: objectFieldNames, title: objectFieldNames, template: null, width: 100 };
      if (objectFieldNames != "createdDate" && objectFieldNames != "modifiedDat" && objectFieldNames != "invoice" && objectFieldNames != "appointment") {
        this.columns.push(columnObject);
      }

      if (objectFieldNames != "createdDate" && objectFieldNames != "modifiedDat" && objectFieldNames != "invoice" && objectFieldNames != "appointment") {
        let col = JSON.parse(JSON.stringify(columnObject));
        col.width = null;
        this.columns2.push(col);
      }

      if (objectFieldNames == "id") {
        columnObject.template = this.cellHideTemplate;
        columnObject.title = "Activity";
      } else if (objectFieldNames == "performedStatus") {
        columnObject.template = this.cellDisplayTemplate;
        columnObject.title = "Performed Status";
      } else if (objectFieldNames == "discount") {
        columnObject.template = this.cellEditTemplate1;
        columnObject.title = "Discount";
      } else if (objectFieldNames == "companyShare") {
        columnObject.template = this.cellEditTemplate2;
        columnObject.title = "Company Share";
      } else if (objectFieldNames == "patientShare") {
        columnObject.template = this.cellEditTemplate3;
        columnObject.title = "Patient Share";
      } else if (objectFieldNames == "quantity") {
        columnObject.template = this.cellEditTemplate4;
        columnObject.title = "Quantity";
      } else if (objectFieldNames == "discountPercentage") {
        columnObject.template = this.cellEditTemplate5;
        columnObject.title = "Discount Percentage (%)";
      } else if (objectFieldNames == "companySharePercentage") {
        columnObject.template = this.cellEditTemplate6;
        columnObject.title = "Company Share (%)";
      } else if (objectFieldNames == "patientSharePercentage") {
        columnObject.template = this.cellEditTemplate7;
        columnObject.title = "Patient Share (%)";
      } else if (objectFieldNames == "approvalCode") {
        columnObject.template = this.cellEditTemplate8;
        columnObject.title = "Approval Code";
      } else if (objectFieldNames == "grossAmount") {
        columnObject.template = this.cellBoldTemplate1;
        columnObject.title = "Gross Amount";
      } else if (objectFieldNames == "netAmount") {
        columnObject.template = this.cellBoldTemplate2;
        columnObject.title = "Net Amount";
      } else if (objectFieldNames == "observationRemarks") {
        columnObject.template = this.cellLinkTemplate1;
        columnObject.title = "Observation Remarks";
      } else if (objectFieldNames == "userRemarks") {
        columnObject.template = this.cellLinkTemplate2;
        columnObject.title = "User Remarks";
      } else if (objectFieldNames == "orderDate") {
        columnObject.title = "Order Date";
      } else if (objectFieldNames == "servicePerformedDate") {
        columnObject.title = "Performed Date";
      } else if (objectFieldNames == "orderingClinician") {
        columnObject.title = "Clinician";
      } else if (objectFieldNames == "isCovered") {
        columnObject.title = "Is Covered";
      } else if (objectFieldNames == "isApproved") {
        columnObject.title = "Is Approved";
      } else if (objectFieldNames == "procedureDescription") {
        columnObject.title = "Procedure Description";
      } else if (objectFieldNames == "activityCode") {
        columnObject.title = "CPT";
      } else if (objectFieldNames == "procedurePrice") {
        columnObject.title = "Procedure Price";
      }

      if (objectFieldNames != "createdDate" && objectFieldNames != "modifiedDat" && objectFieldNames != "invoice" && objectFieldNames != "appointment") {
        this.columns3.push(columnObject);
      }
    }
    this.cptCodeList = ["9922-Consultation", "9911-X-ray"];
    this.dataSet = this.appointments;


   
//++========================================
// console.log("some");
//     console.log(this.dataSet);
var i=0;
    for(let entry of this.dataSet)
    {
      var index=0;
      for(let invoices of  entry.invoices)
      {
          
            let options:CsiGridOptions= {
              sortable: true,
              pageable: true,
              pageSize: 30,
              scrollable: true,
              filterable: true,
              groupable: true,
              skip: 0,
              selectable: {
                enable: true,
                selectedRows:this.selectedItems,
                width: 40
              },
              editable: {
                enable: false,
                onUpdate: this.updateRow,
                formGroup: this.UpdateFormGroup
              },
              
              rowDetailsTemplate: this.layer1TemplateTpl
            };
            this.gridOptionArray[invoices.id] =(options);
            
        
         
          index++;
      }
      i++;
    }
    console.log("some");
    console.log(this.gridOptionArray);
//+=============================================

    for (var appointment of this.appointments) {
      this.totalNumberOfInvoices = this.totalNumberOfInvoices + appointment.invoices.length;
    }

    this.gridOptions = {
      sortable: true,
      pageable: true,
      pageSize: 30,
      scrollable: true,
      filterable: true,
      groupable: true,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },
      /*rowDisabled: (dataItem => {
        return dataItem.id == 3;
      }),*/
      rowDetailsTemplate: this.layer1TemplateTpl
    };

    this.gridOptions2 = {
      sortable: false,
      pageable: false,
      pageSize: 20,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems2,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },
      rowDetailsTemplate: this.layer2TemplateTpl
    };

    this.gridOptions3 = {
      sortable: false,
      pageable: false,
      pageSize: 50,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems3,
        width: 40
      },
      editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      }
    };

    /*
    this.columns = [
      {
        field: "id",
        title: "Id",
        width: 200
      }, {
        field: "albumId",
        title: "Album Id",
        template: this.albumCellTemplateTpl,
        editor: "numeric",
        editTemplate: this.albumCellEditTemplateTpl
      }, {
        field: "title",
        title: "Title"
      }, {
        field: "thumbnailUrl",
        title: "Thumbnail",
        media: "(min-width: 450px)",
        template: this.thumbnailTemplateTpl
      }
    ];


    this.columns2 = [
      {
        field: "id",
        title: "Id",
        width: 170
      }, {
        field: "albumId",
        title: "Album Id",
        template: this.albumCellTemplateTpl,
        editor: "numeric",
        editTemplate: this.albumCellEditTemplateTpl
      }, {
        field: "title",
        title: "Title"
      }, {
        field: "thumbnailUrl",
        title: "Thumbnail",
        media: "(min-width: 450px)",
        template: this.thumbnailTemplateTpl
      }
    ];
    this.columns3 = [
      {
        field: "id",
        title: ""
      }, {
        field: "albumId",
        title: "",
        template: this.albumCellTemplateTpl,
        editor: "numeric",
        editTemplate: this.albumCellEditTemplateTpl
      }, {
        field: "title",
        title: ""
      }, {
        field: "thumbnailUrl",
        title: "",
        media: "(min-width: 450px)",
        template: this.thumbnailTemplateTpl
      }
    ];

    // Get albums
    this.GetAlbums();

    // get posts
    this.GetPosts();
    */
    /*var columnObject = [{field: "appointmentNo", title: "appointmentNo", width: 500},
    {field: "invoiceNo", title: "invoiceNo", width: 500},
    {field: "activityCode", title: "activityCode", width: 500},
    {field: "orderDate", title: "orderDate", width: 500},
    {field: "activityGross", title: "activityGross", width: 500}];
    this.columns = columnObject;
    this.columns2 = columnObject;
    this.columns3 = columnObject;
    this.dataSet = [
			{
				"appointmentNo":"APP001",
				"activityGross": 1200,
				"invoices":[
					{
						"invoiceNo":"INC001",
						"activityGross": 800,
						"encounterActivities": [
							{
								"activityCode":"CPT-10.1",
								"orderDate":"2017-01-17 15:50",
								"activityGross": 100
							}
						]
					}
				]
			}
];*/
 

}

  // delete data
  delete() {
    this.dataSet = this.dataSet.slice(1);
  }

  // Get selected rows
  getSelectedRows(data) {
    console.log(this.selectedItems);
    this.dataSet[0];
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log("changes", changes);
  }

  rowClicked($event) {
    console.log($event);

  }

  diagnosisForm() {
    this.bsModalRef = this.modalService.show(DiagnosisModalComponent);
    this.bsModalRef.content.closeBtnName = 'Close';
  }

  remarkDiagnosisForm() {
    this.bsModalRef = this.modalService.show(DiagnosisRemarkModalComponent);
    this.bsModalRef.content.closeBtnName = 'Close';
  }

  validateActivity(object) {
    if (object.activityCode != undefined && object.activityCode != "") {
      // console.log("validate : " + true);
      // console.log("validate111 : " + JSON.stringify(object));     
      return true;
    } else {
      // console.log("validate : " + false);
      return false;
    }

  }

  saveObservationRemarks() {
    this.bsModalRef.hide();
    /*this.taskListService.Delete(this.selectedWorklistId).subscribe(
      data => {
        this.toastr.success("Worklist deleted successfully","Worklist", {timeOut: 3000,progressBar: true,closeButton : true,});
        this.loadData();
      },
      err => {
        alert(JSON.stringify(err.error));
        const errorMessage = err.error.errors.map(function(obj){return obj.defaultMessage;}).join(', ');
        this.csiAlertService.warning("Error","Failed to delete worklist","Ok")
      }
    );*/
  }

  openModalObservationRemark(template: TemplateRef<any>, observationRemarks: string) {
    this.bsModalRef = this.modalService.show(template);
    this.observationRemarks = observationRemarks;
  }

  openModalUserRemark(template: TemplateRef<any>, userRemarks: string) {
    this.bsModalRef = this.modalService.show(template);
    this.userRemarks = userRemarks;
  }

  getAppointments(): any[] {
    for (var appointment of this.appointments) {
      for (var invoice of appointment.invoices) {
        for (var activity of invoice.encounterActivities) {
          activity['invoice'] = null;
        }
        invoice['appointment'] = null;
      }
    }
    return this.appointments;
  }

  valueChange(item, field, event) {
   
    this.updateParentObjects(item, field, event);
    item[field] = event.target.value;
  }

  updateParentObjects(item, field, event) {
    
    if (field == 'quantity') {
      // Keeping track of current values 
      var difference = event.target.value - item[field];
      var currentGrossAmount = item.grossAmount;
      var currentCompanyShare = item.companyShare;
      var currentDiscount = item.discount;

      // Updating the record
      item.grossAmount = item.procedurePrice * event.target.value;
      item.discount = item.grossAmount * item.discountPercentage / 100;
      item.netAmount = item.grossAmount - item.discount;
      item.companyShare = item.netAmount * item.companySharePercentage / 100;
      item.patientShare = item.netAmount * item.patientSharePercentage / 100;

      // Cascading the update to the parent records for the same field
      item.invoice.quantity = item.invoice.quantity + difference;
      item.invoice.appointment.quantity = item.invoice.appointment.quantity + difference;

      // Cascading the update to the parent records for the other fields
      item.invoice.grossAmount = item.invoice.grossAmount + item.grossAmount - currentGrossAmount;
      item.invoice.appointment.grossAmount = item.invoice.appointment.grossAmount + item.grossAmount - currentGrossAmount;
      item.invoice.discount = item.invoice.discount + item.discount - currentDiscount;
      item.invoice.appointment.discount = item.invoice.appointment.discount + item.discount - currentDiscount;
      item.invoice.netAmount = item.invoice.grossAmount - item.invoice.discount;
      item.invoice.appointment.netAmount = item.invoice.appointment.grossAmount - item.invoice.appointment.discount;
      item.invoice.companyShare = item.invoice.companyShare + item.companyShare - currentCompanyShare;
      item.invoice.appointment.companyShare = item.invoice.appointment.companyShare + item.companyShare - currentCompanyShare;
      item.invoice.patientShare = item.invoice.netAmount - item.invoice.companyShare;
      item.invoice.appointment.patientShare = item.invoice.appointment.netAmount - item.invoice.appointment.companyShare;
    } else if (field == 'discount') {
      var difference = event.target.value - item[field];
      var currentCompanyShare = item.companyShare;
      item.discountPercentage = event.target.value / item.grossAmount * 100;
      item.netAmount = item.grossAmount - event.target.value;
      item.companyShare = item.netAmount * item.companySharePercentage / 100;
      item.patientShare = item.netAmount * item.patientSharePercentage / 100;

      item.invoice.discount = item.invoice.discount + difference;
      item.invoice.appointment.discount = item.invoice.appointment.discount + difference;
      
      item.invoice.netAmount = item.invoice.grossAmount - item.invoice.discount;
      item.invoice.appointment.netAmount = item.invoice.appointment.grossAmount - item.invoice.appointment.discount;
      item.invoice.companyShare = item.invoice.companyShare + item.companyShare - currentCompanyShare;
      item.invoice.appointment.companyShare = item.invoice.appointment.companyShare + item.companyShare - currentCompanyShare;
      item.invoice.patientShare = item.invoice.netAmount - item.invoice.companyShare;
      item.invoice.appointment.patientShare = item.invoice.appointment.netAmount - item.invoice.appointment.companyShare;
    } else if (field == 'discountPercentage') {
      var difference = event.target.value - item[field];
      var newDiscount = item.grossAmount * event.target.value / 100;
      difference = newDiscount - item.discount;
      item.discount = newDiscount;
      item.netAmount = item.grossAmount - item.discount;
      item.invoice.discount = item.invoice.discount + difference;
      item.invoice.appointment.discount = item.invoice.appointment.discount + difference;
      item.invoice.netAmount = item.invoice.grossAmount - item.invoice.discount;
      item.invoice.appointment.netAmount = item.invoice.appointment.grossAmount - item.invoice.appointment.discount;
    } else if (field == 'companyShare') {
      var difference = event.target.value - item[field];
      item.companySharePercentage = event.target.value / item.netAmount * 100;
      item.patientShare = item.patientShare - event.target.value;
      item.patientSharePercentage = item.patientShare / item.netAmount * 100;
      item.invoice.companyShare = item.invoice.companyShare + difference;
      item.invoice.appointment.companyShare = item.invoice.appointment.companyShare + difference;
      item.invoice.patientShare = item.invoice.netAmount - item.invoice.companyShare;
      item.invoice.appointment.patientShare = item.invoice.appointment.netAmount - item.invoice.appointment.companyShare;
    } else if (field == 'companyShare2') {
      var difference = event.target.value - item[field];
      item.companySharePercentage = event.target.value / item.netAmount * 100;
      item.patientShare = item.patientShare - event.target.value;
      item.patientSharePercentage = item.patientShare / item.netAmount * 100;
      item.invoice.companyShare = item.invoice.companyShare + difference;
      item.invoice.appointment.companyShare = item.invoice.appointment.companyShare + difference;
      item.invoice.patientShare = item.invoice.netAmount - item.invoice.companyShare;
      item.invoice.appointment.patientShare = item.invoice.appointment.netAmount - item.invoice.appointment.companyShare;
    }
  }


}
