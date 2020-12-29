package dev.msnascimento.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServices {
	private RoomRepository roomRepository;

	@Autowired
	public RoomServices(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	private static List<Room> rooms = new ArrayList<Room>();

	static {
		for (int i = 0; i < 10; i++) {
			rooms.add(new Room(i, "Room" + i, "R" + i, "Q"));
		}
	}

	public List<Room> getAllRooms() {
		List<Room> rooms= new ArrayList<Room>();
		 this.roomRepository.findAll().forEach(rooms::add);
		 return rooms;
	}

}
