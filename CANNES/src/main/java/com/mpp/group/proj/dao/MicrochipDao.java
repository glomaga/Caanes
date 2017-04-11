package com.mpp.group.proj.dao;

<<<<<<< HEAD
public class MicrochipDao {

=======
import java.util.List;

import com.mpp.group.proj.model.Categories;
import com.mpp.group.proj.model.Microchip;

public interface MicrochipDao {
	
	public List<Microchip> listAllMicrochip();
	public void addMicrochip(Microchip microchip);
	public void updateMicrochip(Microchip microchip);
	public void deleteMicrochip(int id);
	public Microchip findMicrochipById(int id);
>>>>>>> refs/remotes/origin/master
}
