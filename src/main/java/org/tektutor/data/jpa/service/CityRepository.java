package org.tektutor.data.jpa.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.tektutor.data.jpa.model.City;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
	@Query("select city from City city where city.cityName = :cityName ")
	City findByName(@Param("cityName") String cityName);
}