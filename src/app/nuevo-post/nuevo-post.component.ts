import { Component, OnInit } from '@angular/core';
import { PostService } from '../post/post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-post',
  templateUrl: './nuevo-post.component.html',
  styleUrls: ['./nuevo-post.component.scss']
})
export class NuevoPostComponent implements OnInit {

  public nombres;
  public apellidos;
  public nit;
  public email;
  public telefono;

  constructor(
    private postService: PostService,
    private router: Router
  ) {}

  ngOnInit() {
  }

  public enviar() {
    const post = {
      'nombres': this.nombres,
      'apellidos': this.apellidos,
      'nit': this.nit,
      'email': this.email,
      'telefono': this.telefono
    };

    this.postService.save(post)
    .subscribe(response => {
      console.log(response);
      //this.router.navigate(['/'])
    });
  }

}
