// import { Component, OnInit } from '@angular/core';
// import "ag-grid-enterprise";
// import { window } from 'rxjs/operators';
// @Component({
//   selector: 'app-tree-data',
//   templateUrl: './tree-data.component.html',
//   styleUrls: ['./tree-data.component.scss']
// })
// export class TreeDataComponent implements OnInit {

//   private gridApi;
//   private gridColumnApi;

//   private columnDefs;
//   private rowData;
//   private components;
//   private groupDefaultExpanded;
//   private getDataPath;
//   private getRowNodeId;
//   private autoGroupColumnDef;

//   constructor() {
//     this.columnDefs = [
//       {
//         field: "dateModified",
//         comparator: function(d1, d2) {
//           return new Date(d1).getTime() < new Date(d2).getTime() ? -1 : 1;
//         }
//       },
//       {
//         field: "size",
//         aggFunc: "sum",
//         valueFormatter: function(params) {
//           return params.value ? Math.round(params.value * 10) / 10 + " MB" : "0 MB";
//         }
//       }
//     ];
//     this.rowData = [
//       {
//         id: 1,
//         filePath: ["Documents"]
//       },
//       {
//         id: 2,
//         filePath: ["Documents", "txt"]
//       },
//       {
//         id: 3,
//         filePath: ["Documents", "txt", "notes.txt"],
//         dateModified: "May 21 2017 01:50:00 PM",
//         size: 14.7
//       },
//       {
//         id: 4,
//         filePath: ["Documents", "pdf"]
//       },
//       {
//         id: 5,
//         filePath: ["Documents", "pdf", "book.pdf"],
//         dateModified: "May 20 2017 01:50:00 PM",
//         size: 2.1
//       },
//       {
//         id: 6,
//         filePath: ["Documents", "pdf", "cv.pdf"],
//         dateModified: "May 20 2016 11:50:00 PM",
//         size: 2.4
//       },
//       {
//         id: 7,
//         filePath: ["Documents", "xls"]
//       },
//       {
//         id: 8,
//         filePath: ["Documents", "xls", "accounts.xls"],
//         dateModified: "Aug 12 2016 10:50:00 AM",
//         size: 4.3
//       },
//       {
//         id: 9,
//         filePath: ["Documents", "stuff"]
//       },
//       {
//         id: 10,
//         filePath: ["Documents", "stuff", "xyz.txt"],
//         dateModified: "Jan 17 2016 08:03:00 PM",
//         size: 1.1
//       },
//       {
//         id: 11,
//         filePath: ["Music", "mp3", "theme.mp3"],
//         dateModified: "Sep 11 2016 08:03:00 PM",
//         size: 14.3
//       },
//       {
//         id: 12,
//         filePath: ["temp.txt"],
//         dateModified: "Aug 12 2016 10:50:00 PM",
//         size: 101
//       }
//     ];
//     this.components = { fileCellRenderer: getFileCellRenderer() };
//     this.groupDefaultExpanded = -1;
//     this.getDataPath = function(data) {
//       return data.filePath;
//     };
//     this.getRowNodeId = function(data) {
//       return data.id;
//     };
//     this.autoGroupColumnDef = {
//       headerName: "Files",
//       width: 250,
//       cellRendererParams: {
//         checkbox: true,
//         suppressCount: true,
//         innerRenderer: "fileCellRenderer"
//       }
//     };
//   }

//   addNewGroup() {
//     var newGroupData = [
//       {
//         id: getNextId(),
//         filePath: ["Music", "wav", "hit.wav"],
//         dateModified: "Aug 23 2017 11:52:00 PM",
//         size: 58.9
//       }
//     ];
//     this.gridApi.updateRowData({ add: newGroupData });
//   }

//   removeSelected() {
//     var selectedNode = this.gridApi.getSelectedNodes()[0];
//     if (!selectedNode) {
//       console.warn("No nodes selected!");
//       return;
//     }
//     this.gridApi.updateRowData({ remove: getRowsToRemove(selectedNode) });
//   }

//   moveSelectedNodeToTarget(targetRowId) {
//     var selectedNode = this.gridApi.getSelectedNodes()[0];
//     if (!selectedNode) {
//       console.warn("No nodes selected!");
//       return;
//     }
//     var targetNode = this.gridApi.getRowNode(targetRowId);
//     var invalidMove = selectedNode.key === targetNode.key || isSelectionParentOfTarget(selectedNode, targetNode);
//     if (invalidMove) {
//       console.warn("Invalid selection - must not be parent or same as target!");
//       return;
//     }
//     var rowsToUpdate = getRowsToUpdate(selectedNode, targetNode.data.filePath);
//     this.gridApi.updateRowData({ update: rowsToUpdate });
//   }

//   onGridReady(params) {
//     this.gridApi = params.api;
//     this.gridColumnApi = params.columnApi;
//   }
// }

// function getNextId() {
//   if (!window.nextId) {
//     window.nextId = 13;
//   } else {
//     window.nextId++;
//   }
//   console.log(window.nextId);
//   return window.nextId;
// }
// function getFileCellRenderer() {
//   function FileCellRenderer() {}
//   FileCellRenderer.prototype.init = function(params) {
//     var tempDiv = document.createElement("div");
//     var value = params.value;
//     var icon = getFileIcon(params.value);
//     tempDiv.innerHTML = icon ? '<i class="' + icon + '"/>' + '<span class="filename">' + value + "</span>" : value;
//     this.eGui = tempDiv.firstChild;
//   };
//   FileCellRenderer.prototype.getGui = function() {
//     return this.eGui;
//   };
//   return FileCellRenderer;
// }
// function getRowsToRemove(node) {
//   var res = [];
//   for (var i = 0; i < node.childrenAfterGroup.length; i++) {
//     res = res.concat(getRowsToRemove(node.childrenAfterGroup[i]));
//   }
//   return node.data ? res.concat([node.data]) : res;
// }
// function isSelectionParentOfTarget(selectedNode, targetNode) {
//   var children = selectedNode.childrenAfterGroup;
//   for (var i = 0; i < children.length; i++) {
//     if (targetNode && children[i].key === targetNode.key) return true;
//     isSelectionParentOfTarget(children[i], targetNode);
//   }
//   return false;
// }
// function getRowsToUpdate(node, parentPath) {
//   var res = [];
//   var newPath = parentPath.concat([node.key]);
//   if (node.data) {
//     node.data.filePath = newPath;
//   }
//   for (var i = 0; i < node.childrenAfterGroup.length; i++) {
//     var updatedChildRowData = getRowsToUpdate(node.childrenAfterGroup[i], newPath);
//     res = res.concat(updatedChildRowData);
//   }
//   return node.data ? res.concat([node.data]) : res;
// }
// function getFileIcon(filename) {
//   return filename.endsWith(".mp3") || filename.endsWith(".wav")
//     ? "fa fa-file-audio-o"
//     : filename.endsWith(".xls")
//       ? "fa fa-file-excel-o"
//       : filename.endsWith(".txt") ? "fa fa fa-file-o" : filename.endsWith(".pdf") ? "fa fa-file-pdf-o" : "fa fa-folder";
// }

