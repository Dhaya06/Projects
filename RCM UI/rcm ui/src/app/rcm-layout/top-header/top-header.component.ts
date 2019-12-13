import { Component, OnInit, ElementRef } from '@angular/core';

@Component({
  selector: 'rcm-top-header',
  templateUrl: './top-header.component.html',
  styleUrls: ['./top-header.component.scss'],
  host: {
    '(document:click)': 'onClick($event)',
  }
})
export class TopHeaderComponent implements OnInit {

  constructor(private _el: ElementRef) { }

  ngOnInit() {
  }

  toggleNav() {
    var element = document.getElementById("sidebar");
    if (element.style.left == "0px") {
      element.style.left = "-250px";
    } else {
      element.style.left = "0px";
    }
  }

  onClick(event) {
    if (!this._el.nativeElement.contains(event.target)) {// similar checks}
      var element = document.getElementById("sidebar");
      if (element.style.left == "0px") {
        element.style.left = "-250px";
      }
    }

  }

}
