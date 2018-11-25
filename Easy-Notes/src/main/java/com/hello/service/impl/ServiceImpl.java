package com.hello.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.hello.controller.NoteController;
import com.hello.model.Note;
import com.hello.repository.NoteRepository;
import com.hello.service.Service;

@org.springframework.stereotype.Service

public class ServiceImpl implements Service {

	private final static Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

	
	@Autowired
	private NoteRepository noteRepository;
	
	/*@Autowired
	NoteController controller;*/
	
	
	/*@Override
	public List<Note> findByTitle(String title) {
		List<Note> list=new ArrayList<>();
		for(Note note : noteRepository.findByTitle(title)) {
			LOG.info(note.toString());
			list.add(note);
	}
		return list;
	}
*/
}
