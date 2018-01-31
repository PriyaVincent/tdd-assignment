/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tektutor.data.jpa.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tektutor.data.jpa.SampleDataRestApplication;
import org.tektutor.data.jpa.model.City;

/**
 * Integration tests for {@link CityRepository}.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleDataRestApplication.class)
public class CityRepositoryIntegrationTests {

	@Autowired
	CityRepository repository;
	
	@Before
	public void setup() throws Exception {
		for(int i=0; i<20; i++){
			City city = new City();
			city.setCityName("Test"+i);
			repository.save(city);
		}	
	}

	@Test
	public void addCity() {
		City city = new City();
		city.setCityName("Chennai");
		City response = this.repository.save(city);
		assertTrue(response.getCityId() != null);
	}

	@Test
	public void findCityByName() {
		City city = new City();
		city.setCityName("Chennai");
		this.repository.save(city);
		City response = this.repository.findByName("Chennai");
		assertTrue(response.getCityName().equals("Chennai"));
	}

	@Test
	public void findsFirstPageOfCities() {
		Page<City> cities = this.repository.findAll(new PageRequest(0, 10));
		assertThat(cities.getTotalElements(), is(greaterThan(20L)));
	}
}