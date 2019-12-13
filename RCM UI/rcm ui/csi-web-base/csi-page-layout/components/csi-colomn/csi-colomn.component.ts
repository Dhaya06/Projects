import { Component, OnInit, Input, Inject, ViewContainerRef, ChangeDetectorRef } from '@angular/core';
import { ComponentRegistry } from 'csi-base';

@Component({
  selector: 'csi-colomn',
  template: '<csi-dynamic-component [component]="_content"></csi-dynamic-component>',
  styleUrls: ['./csi-colomn.component.scss']
})
@ComponentRegistry({
  componentId: "ca96c9e0-0285-4eb8-bef9-07bf1c8a4799"
})
export class CsiColomnComponent implements OnInit {
  
  @Input("cellId") _cellId: string;
  @Input("content") _content: any;
  
  constructor(private cdRef: ChangeDetectorRef) {
  }
  
  ngOnInit() {
    // console.log("_cellId", this._cellId);
    // console.log("_content", this._content);
    this.cdRef.detectChanges();
  }


  ngOnChanges() {
    console.log("changed from csi-page-layout-colomn");
    console.log(this._content);
  }

  
};
