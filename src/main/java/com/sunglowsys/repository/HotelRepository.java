package com.sunglowsys.repository;

import com.sunglowsys.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query( "from Hotel hotel Where hotel.code like %:searchText% " +
    "or hotel.name like %:searchText% or hotel.hotelType like %:searchText% " +
    "or hotel.email like %:searchText% or hotel.mobile like %:searchText% " )
    List<Hotel> search(@RequestParam("searchText") String searchText);

}
