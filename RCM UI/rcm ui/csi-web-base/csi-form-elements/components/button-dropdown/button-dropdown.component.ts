import { Component, OnInit, Input, Output, Injector, ChangeDetectorRef, SimpleChanges, EventEmitter } from '@angular/core';
import { CsiButtonDropdown, ComponentId } from './button-dropdown.model';
import { ButtonDropdownService } from './button-dropdown.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-button-dropdown',
  templateUrl: './button-dropdown.component.html',
  styleUrls: ['./button-dropdown.component.css'],
})
@ComponentRegistry({
  componentId: ComponentId,
  service: ButtonDropdownService
})
export class ButtonDropdownComponent extends CsiBaseComponent {
  
  // Input Variables
  @Input() id: string = "";
  @Input() name: string = "";
  @Input() text: string = "";
  @Input() classes: string = "";
  @Input() disabled: boolean = false;
  @Input() items: any[] = [];
  
  // Output variables
  @Output() itemClicked = new EventEmitter();
  
  constructor(private injector: Injector, private cdRef: ChangeDetectorRef) {
    super();
  }
  
  /// Detect on input changes
  ngOnChanges(changes: SimpleChanges) {
    
    // if(changes._id) this.config.id =  changes._id.currentValue;
    // if(changes._name) this.config.name =  changes._name.currentValue;
    // if(changes._text) this.config.text =  changes._text.currentValue;
    // if(changes._classes) this.config.classes =  changes._classes.currentValue;
    // if(changes._disabled) this.config.disabled =  changes._disabled.currentValue;
    // if(changes._items) this.config.items =  changes._items.currentValue;
    
  }
  
  ngOnInit() {
    
    // Get values from injectors - Inputs
    // this.config.id =  this.injector.get('id', this._id);
    // this.config.name =  this.injector.get('name', this._name);
    // this.config.classes =  this.injector.get('classes', this._classes);
    // this.config.text =  this.injector.get('text', this._text);
    // this.config.disabled =  this.injector.get('disabled', this._disabled);
    // this.config.items =  this.injector.get('items', this._items);
    
    // // Get values from injectors - Outputs
    // this.config.events.itemClicked = this.injector.get('itemClicked', this._itemClicked);
    
  }
  
  // Initialize configuration object
  // config: CsiButtonDropdown = {
  //   componentId: ComponentId,
  //   id: null,
  //   name: null,
  //   type: "buttonDropdown",
  //   disabled: false,
  //   classes: "",
  //   text: "DROPDOWN",
  //   items: [],
  //   events: {
  //     itemClicked: new EventEmitter()
  //   }
  // }
  
  // On item click event method
  onItemClick(event, item){
    if(this.itemClicked != null){
      this.itemClicked.emit({event: event, item: item});
    }
  }
  
}
