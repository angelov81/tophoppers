package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.FarmEntity;
import bg.softuni.tophoppers.domain.repository.FarmRepository;
import bg.softuni.tophoppers.domain.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
      farm.setEnabled(true);
      this.farmRepository.save(farm);
    }
  }

  @Override
  public FarmEntity getFarm(String name) {
    return this.farmRepository.findByName(name);
  }

  @Override
  public List<FarmEntity> getAllFarms() {
    return this.farmRepository.findAll();
  }

  @Override
  public Optional<FarmEntity> getFarmById(String farmId) {
    return this.farmRepository.findById(farmId);
  }
}
