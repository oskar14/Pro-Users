package com.example.demo.Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.Document.Comentario;
import com.example.demo.Document.Post;
import com.mongodb.MapReduceCommand.OutputType;
import com.mongodb.client.result.UpdateResult;

@Repository
public class PostRep {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Post save(Post usuarios) {
		return mongoTemplate.save(usuarios);
	}
	
	public UpdateResult addComentario(String idPost, Comentario comentario) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where("_id").is(idPost)),
				new Update().addToSet("comentarios", comentario),
				Post.class
		);
	}
	
	public List<Post> finaAll(){
		return mongoTemplate.findAll(Post.class);
	}
	
	public Post find(String idPost) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("_id").is(idPost)), Post.class).get(0);
	}
	
	public List<Post> search(String search){
		return mongoTemplate.aggregate(Aggregation.newAggregation(
				Aggregation.match(new Criteria().orOperator(
						Criteria.where("nombres").regex(search),
						Criteria.where("apellidos").regex(search),
						Criteria.where("nit").regex(search),
						Criteria.where("email").regex(search),
						Criteria.where("telefono").regex(search)
				))
		), "Post", Post.class).getMappedResults();
	}
}
