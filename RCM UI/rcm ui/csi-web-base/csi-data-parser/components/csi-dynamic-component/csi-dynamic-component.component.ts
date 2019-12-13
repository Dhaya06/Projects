import { Component, OnInit, Input, ViewChild, ViewContainerRef, ComponentFactoryResolver, ReflectiveInjector, EventEmitter, ChangeDetectionStrategy, ChangeDetectorRef,  
  ComponentRef,
  Injector,
  OnChanges,
  Provider,
  SimpleChanges,
  Type, 
  InjectionToken} from '@angular/core';
  import { ComponentParserService } from '../../service/component-parser/component-parser.service';
  import { ComponentRegistry } from 'csi-base';
  
  @Component({
    selector: 'csi-dynamic-component',
    template: '<csi-dynamic [csiDynamicComponent]="currentComponent" [csiDynamicInputs]="inputData" [csiDynamicOutputs]="outputData" ></csi-dynamic>',
    changeDetection: ChangeDetectionStrategy.Default
  })
  @ComponentRegistry({
    componentId: "1ca080fc-40c6-40dc-ba23-894277a6ea36"
  })
  export class CsiDynamicComponentComponent implements OnInit {
    
    ngOnInit() {
      this.loadComponentMetaData()
    }
    componentData: {component:any, iot: {inputs:any, outputs: any}};
    
    currentComponent = null;
    inputData: any = {};
    outputData: any = {};
    
    @Input() component: any = null;
    
    constructor( private componentParserService: ComponentParserService) { }
    
    // On changes
    ngOnChanges(changes: SimpleChanges) {
      if (changes['component']) {
        this.loadComponentMetaData();
      }
    }
    
    // Load component meta data
    loadComponentMetaData(){
      
      if(!this.component){
        return;
      }
      
      // Get component object from component-parser service
      this.componentData = this.componentParserService.GetComponent(this.component);
      // Render component to dynamic child view
      if(this.componentData !== null){
        this.currentComponent = this.componentData.component;
        this.inputData  = this.componentData.iot.inputs;
        this.outputData = this.componentData.iot.outputs;
      }
    }
    
  }
  