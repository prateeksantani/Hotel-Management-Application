package com.geekster.project.Hotel.Management.Application.Controller;

import com.geekster.project.Hotel.Management.Application.Model.Room;
import com.geekster.project.Hotel.Management.Application.Model.RoomType;
import com.geekster.project.Hotel.Management.Application.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("rooms")
    public Iterable<Room>getAllRooms()
    {
        return roomService.getAllRooms();
    }
    @GetMapping("room/{id}")
    public Optional<Room> getRoomById(Long roomId)
    {
        return roomService.getRoomById(roomId);
    }

    @GetMapping("room/{roomType}")
    public List<Room>getAvailableRoomsByType(RoomType roomType){
        return roomService.getAvailableRoomsByType(roomType);
    }

    @PostMapping("room")
    public String addARoom(@RequestBody Room room)
    {
        return roomService.addARoom(room);
    }


    @PostMapping("rooms")
    public String addRooms(@RequestBody List<Room> roomList)
    {
        return roomService.addRooms(roomList);
    }

    //update room price by type
    @PutMapping("room/price")
    public String updateRoomPriceByType(@RequestParam RoomType roomType , @RequestParam Double priceIncrease)
    {
        return  roomService.updateRoomPriceByType( roomType , priceIncrease);
    }

    @DeleteMapping("room/{roomId}")
    public String deleteRoomById(@RequestParam Long roomId )
    {
        return roomService.deleteRoomById(roomId);
    }




}