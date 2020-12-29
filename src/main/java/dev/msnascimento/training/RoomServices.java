package dev.msnascimento.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomServices {
	private static List<Room> rooms = new ArrayList<Room>();

	static {
		for (int i = 0; i < 10; i++) {
			rooms.add(new Room(i, "Room" + i, "R" + i, "Q"));
		}
	}

	public static List<Room> getAllRooms() {
		return rooms;
	}

}
