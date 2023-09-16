package com.F1api.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.Constructor;
import com.F1api.repository.ConstructorRepository;

@Service
public class ConstructorService {

	@Autowired
	private ConstructorRepository constructor_repository;
	
	public List<Constructor> getConstructors() {
		List<Constructor> constructors = constructor_repository.findAll();
		Map<String, Object[]> c_titles_wins_races = constructor_repository.findTitlesWinsRaces().stream().collect(Collectors.toMap(
				o -> (String) o[0], o -> o));
		for (int i = constructors.size() - 1; i >= 0; i--) {
			if (!constructors.get(i).getName().equals("Team Lotus") && constructors.get(i).getName().contains("Lotus") && c_titles_wins_races.get(constructors.get(i).getName()) != null) {
				for (Constructor c : constructors) {
					if (c.getName().equals("Team Lotus")) {
						c.addRaces(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[3]));
						c.addWins(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[2]));
						c.addTitles(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[1]));
						break;
					}
				}
				constructors.remove(constructors.indexOf(constructors.get(i)));
			}
			else if (c_titles_wins_races.get(constructors.get(i).getName()) != null) {
				
				constructors.get(i).addRaces(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[3]));
				constructors.get(i).addWins(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[2]));
				constructors.get(i).addTitles(((Integer) c_titles_wins_races.get(constructors.get(i).getName())[1]));
			}
			else {
				constructors.remove(constructors.indexOf(constructors.get(i)));
			}
		}
		return constructors;
	}
	
	public byte[] getTeamLogo(String constructor_ref) throws IOException {
		Path path = Paths.get("src/main/resources/static/images/teams/" + constructor_ref + ".png");
        if (Files.exists(path)) return Files.readAllBytes(path);
		return Files.readAllBytes(Paths.get("src/main/resources/static/images/drivers/unknown.jpg"));
	}
}
