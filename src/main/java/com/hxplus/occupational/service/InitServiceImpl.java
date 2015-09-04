package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.User;
import com.hxplus.occupational.repositories.DoctorRepository;
import com.hxplus.occupational.repositories.UserRepository;

@Service
public class InitServiceImpl implements InitService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public List<Object> init() {
		List<User> userList = listUsers();
		userRepository.save(userList);

		List<Doctor> doctorList = listDoctors(Long.valueOf(userList.size()));
		doctorRepository.save(doctorList);

		List<Object> objList = new ArrayList<>();
		objList.addAll(doctorList);
		objList.addAll(userList);

		return objList;
	}

	private List<Doctor> listDoctors(Long size) {

		List<Doctor> doctors = new ArrayList<>();

		Doctor doctor = createDoctor(Long.valueOf(1));
		if (doctor != null) {
			System.out.println("Usuario asociado: \n\t"
					+ doctor.getUser().getUsername());
		} else {
			System.out.println("Doctor nulo");
		}
		doctorRepository.save(doctor);

		for (Long i = Long.valueOf(2); i <= size / 4; i++) {
			doctors.add(createDoctor(i));
		}

		return doctors;
	}

	private Doctor createDoctor(Long id) {

		Doctor doctor = new Doctor();

		doctor.setUser(userRepository.findOne(id));
		doctor.setRegNumber((Long.valueOf(String.valueOf((int) (Math.random() * 20000000)))));

		return doctor;
	}

	private List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		String[] firstnames = { "Juan", "Jose", "Alberto", "Pedro", "Carlos",
				"Julio", "Fernando", "Daniel" }, lastnames = { "Perez",
				"Lopez", "Mendez", "Ramirez" }, passwords = { "4242", "2121",
				"6363", "8484" };
		User ale = createUser("Alejandro", "Tarazona", "atarazona", "4242");
		ale.setId(Long.valueOf(1));
		users.add(ale);

		for (int i = 0; i < firstnames.length; i++) {
			for (int k = 0; k < lastnames.length; k++) {
				users.add(createUser(firstnames[i], lastnames[k],
						firstnames[i].substring(0, 2) + lastnames[k],
						passwords[k]));
			}
		}

		return users;
	}

	private User createUser(String firstname, String lastname, String username,
			String password) {
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(username + "@hxplus.com");
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress("Caracas");
		return user;
	}

}