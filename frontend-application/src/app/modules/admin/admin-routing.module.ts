import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutAdminComponent } from './layout-admin/layout-admin.component';
import { AdminDashboardComponent } from './Views/admin-dashboard/admin-dashboard.component';
import { AjouterAgentComponent } from './Views/ajouter-agent/ajouter-agent.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutAdminComponent,
    children: [
      {
        path: 'admin-dashboard',
        component: AdminDashboardComponent,
      },
      {
        path: 'ajouter-agent',
        component: AjouterAgentComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
