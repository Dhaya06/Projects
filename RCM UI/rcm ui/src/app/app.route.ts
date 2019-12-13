import {Routes, RouterModule} from '@angular/router';
import { RcmLayoutComponent } from './rcm-layout/rcm-layout.component';
import { NgModule } from '@angular/core';


export const routes: Routes = [
    {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
    {
        path: '', 
        component: RcmLayoutComponent,
        children: [
            {
                path: 'dashboard',
                loadChildren: './rcm-dashboard/rcm-dashboard.module#RcmDashboardModule'
            },
            {
                path: 'claim/:claim_id',
                loadChildren: './rcm-claim/rcm-claim.module#RcmClaimModule'
            },
            {
                path: 'claims',
                loadChildren: './rcm-claims/rcm-claims.module#RcmClaimsModule'
            },
            {
                path: 'taskmanager',
                loadChildren: './rcm-task-manager/rcm-task-manager.module#RcmTaskManagerModule'
            },
            {
                path: 'taskmanager/:task_id',
                loadChildren: './rcm-task-manager/rcm-task-manager.module#RcmTaskManagerModule'
            },
            {
                path: 'master',
                loadChildren: './rcm-master-data/rcm-master-data.module#RcmMasterDataModule'
            },
            {
                path: 'payerprofile',
                loadChildren: './rcm-payer-profile/rcm-payer-profile.module#RcmPayerProfileModule'
            },
            {
                path: 'payerprofile/:profile_id',
                loadChildren: './rcm-payer-profile/rcm-payer-profile.module#RcmPayerProfileModule'
            },
            {
                path: 'rules',
                loadChildren: './rcm-rules/rcm-rules.module#RcmRulesModule'
            }
            
        ]
    }, {
        path: '**',
        redirectTo: 'dashboard'
    }
];


@NgModule({
    imports: [RouterModule.forRoot(routes,{useHash:true})],
    exports: [RouterModule]
})
export class RcmAppRoutingModule { }
