package dev.msnascimento.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	private RoomServices roomServices;

	@Autowired
	public ApiController(RoomServices roomServices) {
		this.roomServices = roomServices;
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms(Model model) {
		return this.roomServices.getAllRooms();
	}
}