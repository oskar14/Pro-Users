import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostsComponent } from './posts/posts.component';
import { NuevoPostComponent } from './nuevo-post/nuevo-post.component';
import { PostComponent } from './post/post.component';


const routes: Routes = [ 
  {
    path: '',
    component: PostComponent,
    //redirectTo: '/post',
    //pathMatch: 'full'
  },
  {
    path: 'posts',
    component: PostsComponent
  },
  {
    path: 'nuevo-post',
    component: NuevoPostComponent
  },
  {
    path: 'post/buscar/:id',
    component: PostsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
