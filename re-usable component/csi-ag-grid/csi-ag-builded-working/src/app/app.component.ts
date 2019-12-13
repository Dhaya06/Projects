import { Component } from '@angular/core';
import { CsiAgGridColumn, CsiAgGridOptions } from './csi-ag-grid/csi-ag-grid-service';
import { CellRenderComponent } from './cell-render/cell-render.component';
import { CellEditorComponent } from './cell-editor/cell-editor.component';
import { GridService } from './grid-service';
import { CellRenderer2Component } from './cell-renderer-2/cell-renderer-2.component';

import { GridOptions } from "ag-grid/main";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  colDef: CsiAgGridColumn[] = [];
  public gridOptions: CsiAgGridOptions;
  dataSet: any = [];
  private gridApi;
  private gridColumnApi;

  private selectedRows: any[] = [];
  private selectedNode: any[] = [];
  private selectedItemaBeforeEditClick: any[] = [];

  private columnTypes;
  testing: any;
  constructor(private gridService: GridService) {
    this.testing = "Test Text";
    this.colDef = [
      {
        headerName: "ID",
        field: "id",
        width: 200,
        editable: true,
        checkboxSelection: true,
        headerTooltip: 'Test ID',
        filter: 'agTextColumnFilter',
        // cellEditorFramework: CellEditorComponent,
        type: "valueColumn"

      },
      {
        headerName: "value",
        field: "value",
        width: 200,
         cellRendererFramework: CellRenderer2Component,
        headerTooltip: 'Description',
        filter: 'agNumberColumnFilter',
        type: "valueColumn"
      },{
        headerName: "Total",
        type: "totalColumn",
        valueGetter: 'getValue("id") + getValue("value")'
      }
    ];

    //this is column types 
    this.columnTypes = {
      valueColumn: {
        editable: true,
        valueParser: "Number(newValue)",
        cellClass: "number-cell",
        // cellRenderer: "agAnimateShowChangeCellRenderer",
        filter: "agNumberColumnFilter"
      },
      totalColumn: {
        cellRenderer: "agAnimateShowChangeCellRenderer",
        cellClass: "number-cell"
      }
    };
    this.dataSet = [
      { id: 5, value: 3434 },
      { id: 10, value: 15 },
      { id: 15, value: 20 },
      { id: 16, value: 21 },
      { id: 17, value: 22 },
      { id: 18, value: 25 }
    ]
    this.gridOptions =
      {
        rowSelection: 'multiple',
        showToolPanel: false,
        suppressClickEdit: false,
        singleClickEdit: false,
        enableColResize:false,
        floatingFilter: true,
        getRowStyle: function (params) {
          if (params.node.data.value == 15) {
            return { background: '#F46F6F' }
          }
          else {
            return { background: '' }
          }
        },
        getRowHeight:function(params)
        {
          if(params.node.data.value==20){
            return 50;
          }
          else return 30;
        },
        isRowSelectable:(data=>{
          if(data.value==22)
          return false;
          else
          return true;
        }),
        suppressRowClickSelection:true,
        pagination:true,
        columnTypes:this.columnTypes
      };
      
      // getRowHeight:(data=>{
      //   if(data.id==16)
      //   return 50;
      //  })
    this.secondCtor();
  }//end of ctor

  onRowClick() {
    console.log('row clicked');
  }
  myCustomAggFunc(values )
  {
    values;
   return '12';

  }
  isSelectedR: boolean = false;
  onRowSelect($event) {
    console.log($event);

    // if ($event.node.selected) {
    //   console.log('selected');
    // }
    // else {
    //   console.log('un-selected');
    // }

    if ($event.node.selected) {

      if (this.gridService.isEditClicked) {
        $event.node.setSelected(false);
        alert('you cant select this');
      }
      else {
        this.selectedRows.push($event.data);
        this.selectedNode.push($event);
        if (!this.gridService.isEditClicked) {
          this.selectedItemaBeforeEditClick.push($event.data);
        }
      }
    }
    else if ($event.node.selected == undefined) {
      //do nothing  
    }
    else {
      if (this.selectedRows.length < 1) {
        //do nothing
      }
      else {
        var count: number = 0;

        for (let item of this.selectedRows) {
          if (item.id == $event.data.id)
            break;

          count++;
        }

        this.selectedRows.splice(count, 1); //[$event.data];
        this.selectedNode.splice(count, 1);
        this.selectedItemaBeforeEditClick.splice(count, 1);

        console.log('deselected');
        this.selectedRows; //[$event.data];
        this.selectedNode;
        this.selectedItemaBeforeEditClick;

      }

    }

    if (this.selectedRows.length > 0) {
      this.isSelectedR = true;
    }
    else {
      this.isSelectedR = false;
    }


  }

  getRowStlye(params) {
    if (params.node.data.value == 20) {
      return { background: '#F46F6F' }
    }
    else {
      return { background: '' }
    }
  }



  griReadyEvent(params) {
    this.gridApi = params.api;
    this.gridApi.selectAll();
    this.gridColumnApi = params.columnApi;
    debugger;
  }

colState:any;
groupState:any;
sortState:any;
filterState:any;
  saveState() {
    this.colState = this.gridColumnApi.getColumnState();
    this.groupState = this.gridColumnApi.getColumnGroupState();
    this.sortState = this.gridApi.getSortModel();
    this.filterState = this.gridApi.getFilterModel();
    console.log("column state saved");
    debugger;
  }
  restoreState()
  {debugger;
    this.gridColumnApi.setColumnState(this.colState);
    this.gridColumnApi.setColumnGroupState(this.groupState);
    this.gridApi.setSortModel(this.sortState);
    this.gridApi.setFilterModel(this.filterState);
    console.log("column state restored");
    
  }

  btStartEdit() {
    // this.gridService.isEditClicked=true;
    this.gridService.countofClick++;
    if (this.gridService.isEditClicked) {

      this.gridService.selectedItemsBeforeEditClick = this.selectedRows;
    }
    else {
      this.gridService.selectedItemsBeforeEditClick = this.selectedItemaBeforeEditClick;
      this.gridService.EditClicked();
    }

  }

  //++++++++++++++++++++++++2nd TABLE RCM Practice
  //++++++++++++++AG Grid Properties

  private AggridOptions: GridOptions;
  private AgColumnDef: any[];
  private agGridData: any[];
  public rowData: any[];
  selectedRows2: any[] = [];
  private gridApi2;
  public columnDefs: any[];
  private gridColumnApi2;
  private getDataPath;
  private defaultColDef;
  private autoGroupColumnDef;
  private rowSelection;
  private columnTypes2;
  //++++++++++++++AG Grid Properties
  secondCtor() {

    // this.AggridOptions.treeData = true;

    // this.AggridOptions.enableFilter = true;

    this.AgColumnDef = [
      // { field: "invoiceNo", headerName: "Invoice No", editable: false, width: 80,rowGroupIndex: 1},
      { field: "invoiceNo", headerName: "Invoice No", editable: false, width: 80},
      {
        field: "orderDate", headerName: "Order Date", editable: false, width: 100,
        headerTooltip: "Order Date"
      },
      { field: "id", headerName: "Activity", editable: false, width: 100, headerTooltip: "Activity" },
      { field: "performedStatus", headerName: "Is Performed", editable: false, width: 100, headerTooltip: "Is Performed" },
      { field: "servicePerformedDate", headerName: "Service Date", editable: false, width: 100, headerTooltip: "Service Date" },
      { field: "isCovered", headerName: "Is Covered", editable: false, width: 100, headerTooltip: "Is Covered" },
      { field: "isApproved", headerName: "Is Approved", editable: false, width: 100, headerTooltip: "Is Approved" },
      { field: "activityCode", headerName: "CPT", editable: false, width: 100, headerTooltip: "CPT" },
      { field: "procedureDescription", headerName: "Procedure Description", editable: false, width: 150, headerTooltip: 'Procedure Description' },
      { field: "procedurePrice", headerName: "Procedure Price",  width: 150, headerTooltip: 'Procedure Price',type:'valueColumn' },
      // { field: "procedurePrice", headerName: "Procedure Price",  width: 150, headerTooltip: 'Procedure Price' },
      { field: "quantity", headerName: "Quantity", editable: false, width: 100, headerTooltip: 'Quantity' },
      { field: "grossAmount", headerName: "Gross Amount", width: 100, headerTooltip: 'Gross Amount',type:'valueColumn' },
      // { field: "grossAmount", headerName: "Gross Amount", width: 100, headerTooltip: 'Gross Amount'},
      { field: "discount", headerName: "Discount", editable: false, width: 100, headerTooltip: 'Discount' },
      { field: "discountPercentage", headerName: "Discount Percentage (%)", editable: false, width: 100, headerTooltip: 'Discount Percentage (%)' },
      { field: "netAmount", headerName: "Net Amount", editable: false, width: 100, headerTooltip: 'Net Amount' },
      { field: "companyShare", headerName: "Company Share", editable: false, width: 100, headerTooltip: 'Company Share' },
      { field: "companySharePercentage", headerName: "Company Share (%)", editable: false, width: 100, headerTooltip: 'Company Share Percentage %' },
      { field: "patientShare", headerName: "Patient Share", editable: false, width: 100, headerTooltip: 'Patient Share' },
      { field: "patientSharePercentage", headerName: "Patient Share (%)", editable: false, width: 100, headerTooltip: 'Patient Share (%)' },
      { field: "approvalCode", headerName: "Approval Code", editable: false, width: 100, headerTooltip: 'Approval Code' },
      { field: "observationRemarks", headerName: "Observation Remarks", editable: false, width: 100, headerTooltip: 'Observation Remarks' },
      { field: "userRemarks", headerName: "User Remarks", editable: false, width: 100, headerTooltip: 'User Remarks' },
      // { field: "appointmentNo", headerName: "App No", editable: false, width: 80,  rowGroupIndex: 0 },
       { headerName: "Total", type: "totalColumn",  valueGetter:'getValue("grossAmount") + getValue("procedurePrice")' },
     
       
    ];

    var tempData;
    var tempJson = this.getJson();
    this.rowData = this.FormatTableData(tempJson);


    this.AggridOptions = {
     
      autoGroupColumnDef: {
        headerName: "App_>No",
        field: "appointmentNo",
        cellRenderer: "agGroupCellRenderer",
        aggFunc: this.myCustomAggFunc,
        cellRendererParams: {
          checkbox: true,
          footerValueGetter: '"Total (" + x + ")"',
         suppressCount:true,
          padding: 19
        }
      },
      defaultColDef : {
        width: 150,
        editable: true,
        filter: "agTextColumnFilter"
      },
      rowSelection: "multiple",
  
      groupSelectsChildren: true,
      treeData: true,
      getDataPath: (data => {
        return data.appointmentNo;
      }),
      columnTypes:this.columnTypes2
    }

    
    this.columnTypes2 = {
      valueColumn: {
        editable: true,
        aggFunc: this.myCustomAggFunc,
        valueParser: "Number(newValue)",
        cellClass: "number-cell",
        cellRenderer: "agAnimateShowChangeCellRenderer",
        filter: "agNumberColumnFilter"
      },
      totalColumn: {
        cellRenderer: "agAnimateShowChangeCellRenderer",
        cellClass: "number-cell"
      }
    };

    }//end of ctor


    onRowSelected2($event)
    {
      console.log($event);
      if ($event.node.level && $event.node.level == 1) {// api.selectAll();
        if ($event.node.selected) {
          for (let item of $event.node.allLeafChildren) {
            {
              item.setSelected(true);
            }
          }
        }
        else if (!$event.node.selected) {
          for (let item of $event.node.allLeafChildren) {
            {
              item.setSelected(false)
            }
          }
        }
      }

      var a = this.gridApi.getSelectedNodes()
      var b = this.gridApi.getSelectedRows()
      
    }
    onRowClick2($event)
    {
      console.log($event);
    }
    getSelectedRowsAG()
    {

    }
    griReadyEvent2(params) {

      this.gridApi = params.api;
      this.gridApi.selectAll();
      this.gridColumnApi = params.columnApi;

      //  var tempData;
      //  var tempJson=this.getJson();
      //  tempData= this.FormatTableData( tempJson);

      // this.agGridData   = 
      //  params.api.setRowData(tempData);

      // console.log(params);
      // this.http.get('../../assets/dataJson.json').subscribe(data => {
      //   params.api.setRowData(data);
      // });
    }

    FormatTableData(dataArray: any): any {
      var resultArray = [];
      var sometryArray = [];
      for (let item of dataArray) {

        var newData = {

          appointmentNo: [item.appointmentNo],
          invoiceNo: "",
          orderDate: "",
          id: "",
          performedStatus: "",
          servicePerformedDate: "",
          isCovered: "",
          isApproved: "",
          activityCode: "",
          procedureDescription: "",
          procedurePrice: "",
          quantity: "",
          grossAmount: "",
          discount: "",
          discountPercentage: "",
          netAmount: "",
          companyShare: "",
          companySharePercentage: "",
          patientShare: "",
          patientSharePercentage: "",
          approvalCode: "",
          observationRemarks: "",
          userRemarks: '',
        };
        resultArray.push(newData);
        for (let invoices of item.invoices) {

          var c = '<p>bababba</p>';
          var newData2 = {
            appointmentNo: [item.appointmentNo, invoices.invoiceNo],
            invoiceNo: invoices.invoiceNo,
            orderDate: "",
            id: "",
            performedStatus: "",
            servicePerformedDate: "",
            isCovered: "",
            isApproved: "",
            activityCode: "",
            procedureDescription: "",
            procedurePrice: "",
            quantity: "",
            grossAmount: "",
            discount: "",
            discountPercentage: "",
            netAmount: "",
            companyShare: "",
            companySharePercentage: "",
            patientShare: "",
            patientSharePercentage: "",
            approvalCode: "",
            observationRemarks: "",
            userRemarks: '',
          };
          resultArray.push(newData2);
          for (let encounter of invoices.encounterActivities) {
            var newData3 = {

              appointmentNo: [item.appointmentNo, invoices.invoiceNo, encounter.id],
              invoiceNo: invoices.invoiceNo,
              orderDate: encounter.orderDate,
              id: encounter.id,
              performedStatus: encounter.performedStatus,
              servicePerformedDate: encounter.servicePerformedDate,
              isCovered: encounter.isCovered,
              isApproved: encounter.isApproved,
              activityCode: encounter.activityCode,
              procedureDescription: encounter.procedureDescription,
              procedurePrice: encounter.procedurePrice,
              quantity: encounter.quantity,
              grossAmount: encounter.grossAmount,
              discount: encounter.discount,
              discountPercentage: encounter.discountPercentage,
              netAmount: encounter.netAmount,
              companyShare: encounter.companyShare,
              companySharePercentage: encounter.companySharePercentage,
              patientShare: encounter.patientShare,
              patientSharePercentage: encounter.patientSharePercentage,
              approvalCode: encounter.approvalCode,
              observationRemarks: encounter.observationRemarks,
              userRemarks: encounter.userRemarks,
            };

            var SomeTry = {

              appointmentNo: item.appointmentNo,
              invoiceNo: invoices.invoiceNo,
              orderDate: encounter.orderDate,
              id: encounter.id,
              performedStatus: encounter.performedStatus,
              servicePerformedDate: encounter.servicePerformedDate,
              isCovered: encounter.isCovered,
              isApproved: encounter.isApproved,
              activityCode: encounter.activityCode,
              procedureDescription: encounter.procedureDescription,
              procedurePrice: encounter.procedurePrice,
              quantity: encounter.quantity,
              grossAmount: encounter.grossAmount,
              discount: encounter.discount,
              discountPercentage: encounter.discountPercentage,
              netAmount: encounter.netAmount,
              companyShare: encounter.companyShare,
              companySharePercentage: encounter.companySharePercentage,
              patientShare: encounter.patientShare,
              patientSharePercentage: encounter.patientSharePercentage,
              approvalCode: encounter.approvalCode,
              observationRemarks: encounter.observationRemarks,
              userRemarks: encounter.userRemarks,
            };
            sometryArray.push(SomeTry);
            resultArray.push(newData3);
          }
        }
      }
      // return sometryArray;
      return resultArray;
    }



    getJson(): any {

      return [
        {
          "id": "5750",
          "createdDate": "2018/02/20",
          "modifiedDat": "2018/03/08",
          "appointmentNo": "APP015",
          "encounterDiagnosis": [

          ],
          "invoices": [
            {
              "id": "5150",
              "createdDate": "2018/02/20",
              "modifiedDat": "2018/03/08",
              "invoiceNo": "INC200",
              "grossAmount": 60000.0,
              "netAmount": 50000.0,
              "discount": 10000.0,
              "companyShare": 41800.0,
              "patientShare": 8200.0,
              "quantity": 3.0,
              "encounterActivities": [
                {
                  "id": "5207",
                  "createdDate": "2018/02/20",
                  "modifiedDat": "2018/03/08",
                  "activityType": "2",
                  "activityCode": "CPT-10.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Not-Performed",
                  "servicePerformedDate": "2018/02/16",
                  "procedurePrice": 20000.0,
                  "quantity": 2.0,
                  "netAmount": 32000.0,
                  "grossAmount": 40000.0,
                  "patientShare": 6400.0,
                  "companySharePercentage": 80.0,
                  "patientSharePercentage": 20.0,
                  "companyShare": 25600.0,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 20.0,
                  "discount": 8000.0,
                  "approvalCode": "PA-101",
                  "observationRemarks": "observation remarks 6600",
                  "userRemarks": "user remarks 6600",
                  "procedureDescription": "procedureDescription 11",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                },
                {
                  "id": "6500",
                  "createdDate": "2018/02/20",
                  "activityType": "2",
                  "activityCode": "CPT-10.2",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Not-Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 20000.0,
                  "quantity": 1.0,
                  "netAmount": 18000.0,
                  "grossAmount": 20000.0,
                  "patientShare": 1800.0,
                  "companySharePercentage": 90.0,
                  "patientSharePercentage": 10.0,
                  "companyShare": 16200.0,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 10.0,
                  "discount": 2000.0,
                  "approvalCode": "PA-100",
                  "observationRemarks": "observation remarks 6500",
                  "userRemarks": "user remarks 6500",
                  "procedureDescription": "procedureDescription 10",
                  "observations": [

                  ]
                }
              ]
            },
            {
              "id": "5250",
              "createdDate": "2018/02/20",
              "modifiedDat": "2018/03/08",
              "invoiceNo": "INC210",
              "grossAmount": 41600.0,
              "netAmount": 33280.0,
              "discount": 8320.0,
              "companyShare": 26624.0,
              "patientShare": 6656.0,
              "quantity": 13.0,
              "encounterActivities": [
                {
                  "id": "5800",
                  "createdDate": "2018/02/20",
                  "modifiedDat": "2018/03/08",
                  "activityType": "2",
                  "activityCode": "CPT-22.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Performed",
                  "servicePerformedDate": "2018/01/17",
                  "procedurePrice": 1800.0,
                  "quantity": 12.0,
                  "netAmount": 17280.0,
                  "grossAmount": 21600.0,
                  "patientShare": 3456.0,
                  "companySharePercentage": 80.0,
                  "patientSharePercentage": 20.0,
                  "companyShare": 13824.0,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 20.0,
                  "discount": 4320.0,
                  "approvalCode": "PA-502",
                  "observationRemarks": "observation remarks 5800",
                  "userRemarks": "user remarks 5800",
                  "procedureDescription": "procedureDescription 12",
                  "serviceCategory": "01",
                  "observations": [

                  ]
                },
                {
                  "id": "5900",
                  "createdDate": "2018/02/20",
                  "activityType": "7",
                  "activityCode": "CPT-12.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 20000.0,
                  "quantity": 1.0,
                  "netAmount": 16000.0,
                  "grossAmount": 20000.0,
                  "patientShare": 3200.0,
                  "companySharePercentage": 80.0,
                  "patientSharePercentage": 20.0,
                  "companyShare": 12800.0,
                  "orderingClinician": "EN50039",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 20.0,
                  "discount": 4000.0,
                  "approvalCode": "PA-503",
                  "observationRemarks": "observation remarks 5900",
                  "userRemarks": "user remarks 5900",
                  "procedureDescription": "procedureDescription 13",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                }
              ]
            }
          ],
          "grossAmount": 101600.0,
          "netAmount": 83280.0,
          "discount": 18320.0,
          "companyShare": 68424.0,
          "patientShare": 14856.0,
          "quantity": 16.0
        },
        {
          "id": "5201",
          "createdDate": "2018/02/19",
          "modifiedDat": "2018/03/09",
          "appointmentNo": "APP011",
          "encounterDiagnosis": [

          ],
          "invoices": [
            {
              "id": "5305",
              "createdDate": "2018/02/19",
              "modifiedDat": "2018/03/09",
              "invoiceNo": "INC070",
              "grossAmount": 20000.0,
              "netAmount": 13400.0,
              "discount": 6600.0,
              "companyShare": 9020.0,
              "patientShare": 4380.0,
              "quantity": 4.0,
              "encounterActivities": [
                {
                  "id": "5410",
                  "createdDate": "2018/02/19",
                  "modifiedDat": "2018/03/09",
                  "activityType": "2",
                  "activityCode": "CPT-13.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Performed",
                  "servicePerformedDate": "2018/01/17",
                  "procedurePrice": 7000.0,
                  "quantity": 2.0,
                  "netAmount": 9800.0,
                  "grossAmount": 14000.0,
                  "patientShare": 2940.0,
                  "companySharePercentage": 70.0,
                  "patientSharePercentage": 30.0,
                  "companyShare": 6860.0,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 30.0,
                  "discount": 4200.0,
                  "approvalCode": "PA-502",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 501",
                  "procedureDescription": "LAB",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                },
                {
                  "id": "5511",
                  "createdDate": "2018/02/19",
                  "modifiedDat": "2018/03/09",
                  "activityType": "5",
                  "activityCode": "CPT-10.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 3000.0,
                  "quantity": 2.0,
                  "netAmount": 3600.0,
                  "grossAmount": 6000.0,
                  "patientShare": 1440.0,
                  "companySharePercentage": 60.0,
                  "patientSharePercentage": 40.0,
                  "companyShare": 2160.0,
                  "orderingClinician": "EN50039",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 40.0,
                  "discount": 2400.0,
                  "approvalCode": "PA-503",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 502",
                  "procedureDescription": "LAB",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                }
              ]
            },
            {
              "id": "5403",
              "createdDate": "2018/02/19",
              "modifiedDat": "2018/03/09",
              "invoiceNo": "INC110",
              "grossAmount": 4500.0,
              "netAmount": 2835.0,
              "discount": 1665.0,
              "companyShare": 1498.5,
              "patientShare": 1336.5,
              "quantity": 3.0,
              "encounterActivities": [
                {
                  "id": "5401",
                  "createdDate": "2018/02/19",
                  "modifiedDat": "2018/03/09",
                  "activityType": "8",
                  "activityCode": "CPT-10.2",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Not-Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 900.0,
                  "quantity": 1.0,
                  "netAmount": 675.0,
                  "grossAmount": 900.0,
                  "patientShare": 472.5,
                  "companySharePercentage": 30.0,
                  "patientSharePercentage": 70.0,
                  "companyShare": 202.5,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 25.0,
                  "discount": 225.0,
                  "approvalCode": "PA-100",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 5100",
                  "procedureDescription": "pre anesthesia evaluation",
                  "serviceCategory": "01",
                  "observations": [

                  ]
                },
                {
                  "id": "5402",
                  "createdDate": "2018/02/19",
                  "modifiedDat": "2018/03/09",
                  "activityType": "3",
                  "activityCode": "CPT-10.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Not-Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 1800.0,
                  "quantity": 2.0,
                  "netAmount": 2160.0,
                  "grossAmount": 3600.0,
                  "patientShare": 864.0,
                  "companySharePercentage": 60.0,
                  "patientSharePercentage": 40.0,
                  "companyShare": 1296.0,
                  "orderingClinician": "EN50029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 40.0,
                  "discount": 1440.0,
                  "approvalCode": "PA-101",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 5001",
                  "procedureDescription": "ultrasound",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                }
              ]
            },
            {
              "id": "1301",
              "createdDate": "2018/02/19",
              "modifiedDat": "2018/03/08",
              "invoiceNo": "INC001",
              "grossAmount": 1250.0,
              "netAmount": 1025.0,
              "discount": 225.0,
              "companyShare": 825.0,
              "patientShare": 225.0,
              "quantity": 11.0,
              "encounterActivities": [
                {
                  "id": "1412",
                  "createdDate": "2018/02/19",
                  "modifiedDat": "2018/03/08",
                  "activityType": "1",
                  "activityCode": "CPT-14.3",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Not-Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 1000.0,
                  "quantity": 1.0,
                  "netAmount": 800.0,
                  "grossAmount": 1000.0,
                  "patientShare": 200.0,
                  "companySharePercentage": 80.0,
                  "patientSharePercentage": 20.0,
                  "companyShare": 600.0,
                  "orderingClinician": "EN10029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 20.0,
                  "discount": 200.0,
                  "approvalCode": "PA-101",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 1",
                  "procedureDescription": "LAB",
                  "serviceCategory": "02",
                  "observations": [

                  ]
                },
                {
                  "id": "1411",
                  "createdDate": "2018/02/19",
                  "activityType": "3",
                  "activityCode": "CPT-10.1",
                  "orderDate": "2018/01/16",
                  "performedStatus": "Performed",
                  "servicePerformedDate": "2018/01/16",
                  "procedurePrice": 25.0,
                  "quantity": 10.0,
                  "netAmount": 225.0,
                  "grossAmount": 250.0,
                  "patientShare": 25.0,
                  "companySharePercentage": 90.0,
                  "patientSharePercentage": 10.0,
                  "companyShare": 225.0,
                  "orderingClinician": "EN10029",
                  "isCovered": "1",
                  "isApproved": "1",
                  "discountPercentage": 10.0,
                  "discount": 25.0,
                  "approvalCode": "PA-100",
                  "observationRemarks": "observation remarks",
                  "userRemarks": "user remarks 1",
                  "procedureDescription": "procedureDescription 4",
                  "serviceCategory": "01",
                  "observations": [

                  ]
                }
              ]
            }
          ],
          "grossAmount": 25750.0,
          "netAmount": 17260.0,
          "discount": 8490.0,
          "companyShare": 11343.5,
          "patientShare": 5941.5,
          "quantity": 18.0
        }
      ];
    }

  }
