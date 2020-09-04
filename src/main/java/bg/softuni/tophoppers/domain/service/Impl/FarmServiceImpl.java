package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.FarmEntity;
import bg.softuni.tophoppers.domain.repository.FarmRepository;
import bg.softuni.tophoppers.domain.service.FarmService;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceImpl implements FarmService {

  private final FarmRepository farmRepository;

  public FarmServiceImpl(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  @Override
  public void initDefaultFarm() {
    if (this.farmRepository.count() == 0) {
      FarmEntity farm = new FarmEntity();
      farm.setName("Default");
      farm.setAddress("Local");
      farm.setEmail("info@tophoppers.com");
      this.farmRepository.save(farm);
    }
  }

  @Override
  public FarmEntity getFarm(String name) {
    return this.farmRepository.findByName(name);
  }
}
