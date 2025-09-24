import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientsComponent } from './clients/clients.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { RenewalsComponent } from './renewals/renewals.component';
import { MasterRenewalsComponent } from './master-renewals/master-renewals.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'clients', component: ClientsComponent },
  { path: 'certificates', component: CertificatesComponent },
  { path: 'renewals', component: RenewalsComponent },
  { path: 'master-renewals', component: MasterRenewalsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {}
