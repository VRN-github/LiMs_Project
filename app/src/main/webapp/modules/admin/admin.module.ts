import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientsComponent } from './clients/clients.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { RenewalsComponent } from './renewals/renewals.component';
import { MasterRenewalsComponent } from './master-renewals/master-renewals.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    DashboardComponent,
    ClientsComponent,
    CertificatesComponent,
    RenewalsComponent,
    MasterRenewalsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    HttpClientModule
  ]
})
export class AdminModule {}
