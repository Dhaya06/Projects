import { ComponentInjector } from './component-injector';
import {
  Component,
  ComponentFactoryResolver,
  ComponentRef,
  Injector,
  Input,
  OnChanges,
  Provider,
  ReflectiveInjector,
  SimpleChanges,
  Type,
  ViewContainerRef
} from '@angular/core';

@Component({
  selector: 'csi-dynamic',
  template: ''
})
export class DynamicComponent implements OnChanges, ComponentInjector {

  @Input() csiDynamicComponent: Type<any>;
  @Input() csiDynamicInjector: Injector;
  @Input() csiDynamicProviders: Provider[];
  @Input() csiDynamicContent: any[][];

  componentRef: ComponentRef<any> | null;

  constructor(
    private _vcr: ViewContainerRef,
    private _cfr: ComponentFactoryResolver
  ) { }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['csiDynamicComponent']) {
      this.createDynamicComponent();
    }
  }

  createDynamicComponent() {
    this._vcr.clear();
    this.componentRef = null;

    if (this.csiDynamicComponent) {
      this.componentRef = this._vcr.createComponent(
        this._cfr.resolveComponentFactory(this.csiDynamicComponent),
        0, this._resolveInjector(), this.csiDynamicContent
      );
    }
  }

  private _resolveInjector(): Injector {
    let injector = this.csiDynamicInjector || this._vcr.parentInjector;

    if (this.csiDynamicProviders) {
      injector = ReflectiveInjector.resolveAndCreate(this.csiDynamicProviders, injector);
    }

    return injector;
  }

}
