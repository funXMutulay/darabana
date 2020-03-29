package org.quantum.nine.nioun.service;

import java.util.List;

import org.quantum.nine.nioun.entities.Activiste;


public interface ActivisteService {

	Activiste saveActiviste(Activiste activiste);

	Activiste updateActiviste(Activiste activiste);

	void deleteActiviste(Activiste activiste);

	Activiste getActivisteById(Long id);

	List<Activiste> getAllActivistes();

}
