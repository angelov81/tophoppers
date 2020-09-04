package bg.softuni.tophoppers.domain.service;

import bg.softuni.tophoppers.domain.entity.FarmEntity;

public interface FarmService {

  void initDefaultFarm();

  FarmEntity getFarm(String name);

}
