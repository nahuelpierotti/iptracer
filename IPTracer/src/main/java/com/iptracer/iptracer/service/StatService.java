package com.iptracer.iptracer.service;

import com.iptracer.iptracer.config.MapperConfig;
import com.iptracer.iptracer.dto.StatResponseDto;
import com.iptracer.iptracer.model.Stat;
import com.iptracer.iptracer.repository.IStatRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@AllArgsConstructor
@Service
public class StatService {

    private final IStatRepository statRepository;
    private List<StatResponseDto> estadisticsList;
    private MapperConfig modelMapper;

    public void save(Stat stat) {

        statRepository.save(stat);
    }

    public Stat getStatByCountry(String countryName) {
        return statRepository.getStatByCountry(countryName);
    }

    public List<StatResponseDto> getAll() {
        if(estadisticsList.isEmpty()) {
            estadisticsList=modelMapper.mapList(statRepository.findAll(), StatResponseDto.class);
            return this.estadisticsList;
        }else{
            return this.estadisticsList;
        }
    }

    public Double getDistanceAvg() {
        List<StatResponseDto> estadisticsList=getAll();
        double averageDistance=0.0;
        int sumInvocations=0;
        for(StatResponseDto estadistics:estadisticsList) {
            averageDistance+=estadistics.getDistance()*estadistics.getInvocations();
            sumInvocations+=estadistics.getInvocations();
        }
        return averageDistance/sumInvocations;
    }

    public Double getMaxOrMinDistance(String maxOrMin){
        List<StatResponseDto> estadisticsList=getAll();
        double distance=0.0;
        if(maxOrMin.equals("max")){
            distance=estadisticsList.stream().mapToDouble(e->e.getDistance()).max().orElseThrow(NoSuchElementException::new);
        }else{
            distance=estadisticsList.stream().mapToDouble(e->e.getDistance()).min().orElseThrow(NoSuchElementException::new);
        }
        return distance;
    }

}
