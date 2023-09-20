package com.geekster.project.Hotel.Management.Application.Repository;

import com.geekster.project.Hotel.Management.Application.Model.Room;
import com.geekster.project.Hotel.Management.Application.Model.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepo extends CrudRepository<Room,Long> {


    List<Room> findByRoomType(RoomType roomType);

    List<Room> findByRoomTypeAndRoomAvailableStatus(RoomType roomType, boolean b);
}
