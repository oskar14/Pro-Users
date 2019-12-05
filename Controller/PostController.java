package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Document.Comentario;
import com.example.demo.Document.Post;
import com.example.demo.Repository.PostRep;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin()
public class PostController {
	@Autowired
	private PostRep postRep;
	
	@GetMapping("/posts")
	public List<Post> finaAll(){
		return postRep.finaAll();
	}
	
	@PostMapping("/posts")
	public Post save(@RequestBody Post post) {
		return postRep.save(post);
	}
	
	@PostMapping("/posts/{idPost}/addcomment")
	public UpdateResult addComment(@PathVariable("idPost") String idPost, @RequestBody Comentario comentario) {
		return postRep.addComentario(idPost, comentario);
	}
	
	@GetMapping("/post/{idPost}")
	public Post find(@PathVariable("idPost") String idPost) {
		return postRep.find(idPost);
	}
	
	@GetMapping("/post/search/{serachPost}")
	public List<Post> search(@PathVariable("serachPost") String serachPost){
		return postRep.search(serachPost);
	}
}
