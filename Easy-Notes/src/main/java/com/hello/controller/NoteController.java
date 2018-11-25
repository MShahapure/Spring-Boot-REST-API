package com.hello.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hello.model.Note;
import com.hello.repository.NoteRepository;
import com.hello.service.Service;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	/*@Autowired
	 Service service;*/
	
	
	// Get All Notes
	@GetMapping("/getNotes")
	//@RequestMapping(value="/notes", method=RequestMethod.Post) above is its short form
	public List<Note>getAllNotes(){
		
	   return noteRepository.findAll();
	}
	
	// Create a new Note
	@PostMapping("/createNote")
	public Note createNote(@Valid @RequestBody Note note) {
		
		return noteRepository.save(note);
	}
	
	//Get single note
	@GetMapping("/getById/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable(value="id") Long noteId) {
		
		Note note=noteRepository.findOne(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(note);
	}
	
	//update a note
	@PutMapping("/updateNote/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable(value="id") Long noteId,@Valid @RequestBody Note noteDetails){
	
		Note note=noteRepository.findOne(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());
		
		Note updateNote=noteRepository.save(note);
		return ResponseEntity.ok(updateNote);
	}
	
	//update title
	@PostMapping("/updateTitle")
	public ResponseEntity<Note> updateTitle(@RequestBody Note note1) {
		
		Note note = noteRepository.findOne(note1.getId());
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		note.setTitle(note1.getTitle());
		noteRepository.save(note);
		return ResponseEntity.ok(note);
	}
			
	//Update content
	@PostMapping("/updateContent")
	public ResponseEntity<Note> updateContent(@RequestBody Note note1) {
		
		Note note = noteRepository.findOne(note1.getId());
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		note.setContent(note1.getContent());
		noteRepository.save(note);
		return ResponseEntity.ok(note);
	}
	
	//delete a note
	@DeleteMapping("/deleteNote/{id}")
	public ResponseEntity<Note> deleteNote(@PathVariable(value="id") Long noteId){
		
		Note note=noteRepository.findOne(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		noteRepository.delete(note);
		return ResponseEntity.ok().build();
	}
	
	//find by title
	@PostMapping("/findByTitle")
	public ResponseEntity<List<Note>> findByTitle(@RequestBody Note noteDetail){
		List<Note> findNote=noteRepository.findByTitle(noteDetail.getTitle());
		return ResponseEntity.ok().body(findNote);
		}
	
	
	
}
