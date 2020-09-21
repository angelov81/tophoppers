package bg.softuni.tophoppers.domain.service;

import bg.softuni.tophoppers.domain.entity.FarmEntity;

import java.util.List;
import java.util.Optional;

public interface FarmService {

  void initDefaultFarm();

  FarmEntity getFarm(String name);

  List<FarmEntity> getAllFarms();

  Optional<FarmEntity> getFarmById(String farmId);
}
