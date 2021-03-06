package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.repositories.SoapNoteRepository;
import com.hxplus.occupational.request.SoapNoteRequest;

@Service
public class SoapNoteServiceImpl implements SoapNoteService {

	@Autowired
	SoapNoteRepository soapNoteRepository;
	@Autowired
	ConsultService consultService;

	@Override
	public SoapNote findById(Long id) {
		return soapNoteRepository.findOne(id);
	}

	@Override
	public List<SoapNote> findAll() {
		return soapNoteRepository.findAll();
	}

	@Override
	public SoapNote saveSoapNote(SoapNoteRequest soapNoteRequest) {
		return soapNoteRepository
				.saveAndFlush(fromReq(new SoapNote(), soapNoteRequest));
	}

	@Override
	public SoapNote updateSoapNote(Long id, SoapNoteRequest soapNoteRequest) {
		return soapNoteRepository.save(fromReq(findById(id), soapNoteRequest));
	}

	@Override
	public ResponseEntity<Object> deleteSoapNote(Long id) {
		try {
			soapNoteRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private SoapNote fromReq(SoapNote soapNote, SoapNoteRequest soapNoteRequest) {
		soapNote.setComments(soapNoteRequest.getComments());
		soapNote.setObjective(soapNoteRequest.getObjective());
		soapNote.setSubjective(soapNoteRequest.getSubjective());

		return soapNote;
	}

}
