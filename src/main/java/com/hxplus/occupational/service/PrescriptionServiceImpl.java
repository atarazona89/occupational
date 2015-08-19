package com.hxplus.occupational.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.repositories.PrescriptionRepository;
import com.hxplus.occupational.request.PrescriptionRequest;

public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	PrescriptionRepository prescriptionRepository;

	@Override
	public Prescription findById(Long id) {
		return prescriptionRepository.findOne(id);
	}

	@Override
	public List<Prescription> findAll() {
		return prescriptionRepository.findAll();
	}

	@Override
	public Prescription savePrescription(PrescriptionRequest prescriptionRequest) {
		return prescriptionRepository.save(fromReq(new Prescription(),
				prescriptionRequest));
	}

	@Override
	public Prescription updatePrescription(Long id,
			PrescriptionRequest prescriptionRequest) {
		return prescriptionRepository.save(fromReq(findById(id),
				prescriptionRequest));
	}

	@Override
	public ResponseEntity<Object> deletePrescription(Long id) {
		try {
			prescriptionRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Prescription fromReq(Prescription prescription,
			PrescriptionRequest prescriptionRequest) {
		prescription.setDate(new Date());
		prescription.setDoctor(prescriptionRequest.getDoctor());
		prescription.setDrugs(prescriptionRequest.getDrugs());
		prescription.setIndications(prescriptionRequest.getIndications());
		return prescription;
	}
}