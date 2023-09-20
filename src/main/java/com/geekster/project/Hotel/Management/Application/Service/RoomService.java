package com.geekster.project.Hotel.Management.Application.Service;

import com.geekster.project.Hotel.Management.Application.Model.Room;
import com.geekster.project.Hotel.Management.Application.Model.RoomType;
import com.geekster.project.Hotel.Management.Application.Repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    IRoomRepo roomRepo;

    public Iterable<Room> getAllRooms() {

        return roomRepo.findAll();
    }

    public String addARoom(Room r) {
        roomRepo.save(r);
        return "Room added";
    }

    public String addRooms(List<Room> rooms) {

        roomRepo.saveAll(rooms);
        return "Rooms added";
    }

    public Optional<Room> getRoomById(Long id) {

        return roomRepo.findById(id);
    }

    public String updateRoomPriceByType(RoomType roomType, Double priceIncrease) {
        List<Room> roomList = roomRepo.findByRoomType(roomType);
        int newPercent = (int) (priceIncrease * 10);
        for (Room i : roomList) {
            Double newRoomPrice = i.getRoomPrice() + (i.getRoomPrice() * priceIncrease);
            i.setRoomPrice(newRoomPrice);
        }
        roomRepo.saveAll(roomList);

        return "All " + roomType.toString() + " rooms price Increased by " + newPercent + "%";
    }

    public List<Room> getAvailableRoomsByType(RoomType roomType) {
        return roomRepo.findByRoomTypeAndRoomAvailableStatus(roomType,false);
    }

    public String deleteRoomById(Long roomId) {
        roomRepo.deleteById(roomId);
        return "Room deleted";
    }
}
