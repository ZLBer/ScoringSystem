package test.service;

import test.domain.Information;
import test.domain.Score;

import java.util.List;

public interface IGuardService {
Information getInformationBySerialNumber(String serialNumber);
    List<Score> checkScoring(String serialNumber);
}
