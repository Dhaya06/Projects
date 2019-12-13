import { Component, OnInit, TemplateRef } from '@angular/core';
import { CsiGridColumn } from '../../../../csi-web-base/csi-grid/csi-grid.model';
import { TaskListService } from './task-list.service';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { ViewChild } from '@angular/core';
import { Router, ActivatedRoute} from "@angular/router";
import { Event } from '@angular/router/src/events';
import {URLSearchParams} from '@angular/http'
import { FormGroup, FormControl } from '@angular/forms';
import { DateConvertService } from '../../_shared/date-convert.service';
import { CsiAlertService } from 'csi-alert';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { CsiToastsServiceService } from 'csi-toastr';

@Component({
  selector: 'rcm-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})

@ComponentRegistry({
  componentId: "b879ce40-9c28-4489-a871-17fd970af091"
  }) 
export class TaskListComponent  extends CsiBaseComponent {
  
  constructor(private taskListService: TaskListService,private router: Router,
    private dateConverter:DateConvertService,private csiAlertService: CsiAlertService,private modalService: BsModalService,
    private toastr: CsiToastsServiceService) { 
    super();
  }


  users:any[];
  dataSet:any[] = [];
  columns:CsiGridColumn[] = [];
  selectedWorklistId:number;
  worklistname:string = "";

  @ViewChild('process') private process: TemplateRef<any>;
  @ViewChild('review') private review: TemplateRef<any>;
  @ViewChild('submission') private submission: TemplateRef<any>;
  @ViewChild('reSubmission') private reSubmission: TemplateRef<any>;
  @ViewChild('claimFilters') private claimFilters: TemplateRef<any>;
  @ViewChild('updateDelete') private updateDelete: TemplateRef<any>;
  @ViewChild('deletemodel') private deletemodel: TemplateRef<any>;
  modalRef: BsModalRef

  ngOnInit() {
    
    //Define grid columns
    this.columns = [
      {
        field : "name", // -> fields from database array
        title: "Worklist Name"     // -> Display name of the columns
      }, {
        field: "claimFilters",
        title: "Combinations",
        template: this.claimFilters
      }, {
        field: "assignPeriod",
        title: "Assign Period"
      },{
        field: "process",
        title: "Process",
        template: this.process
      }, {
        field: "review",
        title: "Review",
        template: this.review
      },{
        field: "submission",
        title: "Submission",
        template: this.submission
      },{
        field: "reSubmission",
        title: "Re Submission",
        template: this.reSubmission
      },{
        field: "status",
        title: "Status"
      },{
        field:"status",
        title: "",
        template: this.updateDelete
      }
      
    ];
    
    this.users =[{name:"Ameen",id:1},{name:"Raheel",id:2},{name:"Muhammed",id:3}]

    /// Define dataSet
    this.dataSet = []; // data from your back-end service
    
    this.loadData()
    
  }

  loadData(){
    this.taskListService.GetTaskList().subscribe(res => {
      this.dataSet = res;
    });
  }

  getUserFromId(id:any){
    for(let user of this.users){
      if(user.id == id){
        return user;
      }
    }
  }

  update(id:number){
    this.router.navigate(['/taskmanager/'+id]);
  }
  
  delete(id:number,worklistname:string){
    this.selectedWorklistId = id;
    this.worklistname = worklistname;
    this.openModal(this.deletemodel);
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModel(){
    this.modalRef.hide();
  }

  deleteWorklist(){
    this.closeModel();
    this.taskListService.Delete(this.selectedWorklistId).subscribe(
      data => {
        this.toastr.success("Worklist deleted successfully","Worklist", {timeOut: 3000,progressBar: true,closeButton : true,});
        this.loadData();
      },
      err => {
        // alert(JSON.stringify(err.error));
        // const errorMessage = err.error.errors.map(function(obj){return obj.defaultMessage;}).join(', ');
        this.csiAlertService.warning("Error","Failed to delete worklist","Ok")
      }
    );
    
    
  }

  searchWorkList(options:any){

    let params = new URLSearchParams();
    params.append("name", options["name"]);

    if(options["dateRange"] != null){
      let fromDateString = this.dateConverter.convertDateToString(options["dateRange"][0],"/"); 
      let toDateString = this.dateConverter.convertDateToString(options["dateRange"][1],"/"); 

      params.append("dateFrom", fromDateString);
      params.append("dateTo", toDateString);
    }
    let facilities:any = options["facilities"];
    if(facilities != null ){
      for(let facility of facilities){
        params.append("facilities", facility.id);
      }
    }

    let insuranceGroups = options["insuranceGroup"];
    if(insuranceGroups != null ){
      for(let insuranceGroup of insuranceGroups){
        params.append("insuranceGroup", insuranceGroup.id);
      }
    }

    let companies = options["company"];
    if(insuranceGroups != null ){
      for(let company of companies){
        params.append("company", company.id);
      }
    }

    let users = options["assignee"];
    if(users != null ){
      for(let user of users){
        params.append("assignee", user.id);
      }
    }

    this.taskListService.SearchTaskList(params).subscribe(res => {
      this.dataSet = res;
    });
  }

}
