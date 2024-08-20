import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LayoutAdminComponent } from './layout-admin/layout-admin.component';
import { AdminDashboardComponent } from './Views/admin-dashboard/admin-dashboard.component';
import { AjouterAgentComponent } from './Views/ajouter-agent/ajouter-agent.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    LayoutAdminComponent,
    AdminDashboardComponent,
    AjouterAgentComponent,
  ],
  imports: [CommonModule, AdminRoutingModule, ReactiveFormsModule],
})
export class AdminModule {}
