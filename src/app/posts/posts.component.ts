import { Component, OnInit } from '@angular/core';
import { PostService } from '../post/post.service';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js'



@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  public posts : any = [];

  constructor(
    private service: PostService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.listar();
    
  }

  listar(){
    this.service.findAll().subscribe(response =>{
      console.log(response)
      this.posts = response;
    });
  }
  
}